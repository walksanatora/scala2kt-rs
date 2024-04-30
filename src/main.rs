use std::{collections::VecDeque, fs};

use tree_sitter::{Node, Parser};

#[derive(Default)]
struct ConverterPassable {
    tokens: Vec<String>,
    last_kind: VecDeque<String>,
    depth: usize,
    init: Vec<String>
}

fn work_node(node: Node, src: &String, state: &mut ConverterPassable) {
    if src[node.byte_range()].contains("=>") {
        println!("{} contains a => \n{}\n",node.kind(), &src[node.byte_range()])
    }
    match node.kind() {
        "package_clause" => state.tokens.push(format!("{}\n\n",&src[node.byte_range()])),
        "import_declaration" => state.tokens.push(format!("{}\n",src[node.byte_range()].replace("._", ".*"))),
        "object_definition" | "class_definition" => {
            state.depth += 1;
            converter(node,src,state);
            state.depth -= 1;
            if !state.init.is_empty() {
                let join = state.init.join("\n\t");
                state.tokens.insert(state.tokens.len()-1,format!("\ninit {{\n\t{}\n}}\n",join));
                state.init.clear()
            }
        },

        "block" | "arguments" | "parameters" | "parameter" | "generic_type" | "stable_type_identifier" | "case_block" =>
            converter(node, src, state),

        "type_arguments" => state.tokens.push(
            src[node.byte_range()].replace('[',"<").replace(']',">")
        ),

        "annotation" => {
            let name1 = node.child_by_field_name("name").unwrap();
            let anno = &src[name1.byte_range()];
            let args = if let Some(args) = node.child_by_field_name("arguments") {
                &src[args.byte_range()]
            } else { "" };
            state.tokens.push(format!("@{}{}\n",anno,args))
        }

        "case_clause" => {
            converter(node.child_by_field_name("pattern").unwrap(), src, state);
            state.tokens.push(" -> ".to_string());
            converter(node.child_by_field_name("body").unwrap(), src, state);
            state.tokens.push("\n".to_string());
        }

        "def" => state.tokens.push("fun ".to_string()),

        ":" | "class" | "object" => state.tokens.push(format!("{} ",&src[node.byte_range()])),

        "=" => {//equals is weird. as it *can* be just a assignment. but it is also used for functions. which we must filter out
            if state.last_kind.front().unwrap() == "type_identifier" {
                //nop
            } else {
                state.tokens.push(" = ".to_string())
            }
        }

        "type_identifier" => {
            let data = &src[node.byte_range()];
            let mut split = data.split('.').map(str::to_string).collect::<Vec<String>>();
            let replace = split.last().unwrap().replace('[',"<").replace(']',">");
            let idx = split.len()-1;
            split[idx] = replace;
            state.tokens.push(split.join("."))
        }

        "." | "(" | ")" | "_" | //singular symbols
        "identifier" | "string" //data that just gets dumped as-is
            => state.tokens.push(src[node.byte_range()].to_string()),
        "template_body" | "function_definition" => {
            state.tokens.push("\n".to_string());
            converter(node,src,state);
        },
        "call_expression" => {
            if state.depth == 1 {
                let oldlen = state.tokens.len();
                converter(node, src, state);
                let mut worker = vec![];
                while state.tokens.len() > oldlen {
                    worker.push(state.tokens.pop().unwrap())
                }
                worker.reverse();
                state.init.push(worker.join(""))
            } else {
                state.tokens.push(format!("{}\n",&src[node.byte_range()]))
            }
        }
        
        "match" => {// to work around there being no specific parser for match statments to kotlin. we remap it here
            if let Some(mut pos) = state.tokens.iter().rev().position(|x| x.contains(' ') || x.contains('\n')) {
                let mut backup = vec![];
                while pos > 0 {
                    backup.push(state.tokens.pop().unwrap());
                    pos -= 1;
                }
                backup.reverse();
                state.tokens.push(format!("when ({}) \n",backup.join("")));
            } else {
                state.tokens.push("//WARNING: failed to find a space or newline for match here! be wary!\n".to_string())
            }
        }
        
        "field_expression" => {
            converter(node.child_by_field_name("value").unwrap(), src, state);
            state.tokens.push(format!(".{}",
                &src[node.child_by_field_name("field").unwrap().byte_range()]
            ))
        },

        "val_definition" | "var_definition" => {
            state.tokens.push(format!("{}{} {}",
                node.child_by_field_name("modifiers").map(|x| {format!("{} ",&src[x.byte_range()])}).unwrap_or("".to_string()),
                &node.kind()[0..3],
                &src[node.child_by_field_name("pattern").unwrap().byte_range()]
            ));
            
            if let Some(typ) = node.child_by_field_name("type") {
                state.tokens.push(format!(": {}",&src[typ.byte_range()]))
            }
            if let Some(val) = node.child_by_field_name("value") {
                state.tokens.push(" = ".to_string());
                converter(val,src,state);
            }
            state.tokens.push("\n".to_string())
        }

        "{" | "}"  | "comment" => state.tokens.push(format!("{}\n",&src[node.byte_range()])),

        "null_literal" => state.tokens.push("null".to_string()),
        _ => state.tokens.push(format!("//TODO: UNHANDLED: {} sexp: {} scala:\n{}\n",node.kind(),node.to_sexp(),&src[node.byte_range()].lines().map(
            |x| {
                format!("// {}",x)
            }
        ).collect::<Vec<String>>().join("\n")))
    }
}

fn converter(root: Node, src: &String, state: &mut ConverterPassable) {
    let mut cursor = root.walk();
    if root.child_count() == 0 {
        work_node(root, src, state);
        state.last_kind.push_front(root.kind().to_string());
        return;
    }
    for node in root.children(&mut cursor) {
        if state.last_kind.len() > 8 {
            let _ = state.last_kind.pop_back();
        }
        work_node(node,src,state);
        state.last_kind.push_front(node.kind().to_string());
    }
}

fn main() {

    let mut parser = Parser::new();
    parser.set_language(&tree_sitter_scala::language()).unwrap();

    let read = fs::read_to_string("OpenComputers/src/main/scala/li/cil/oc/OpenComputers.scala").unwrap();
    //let read = fs::read_to_string("test.scala").unwrap();
    let tree = parser.parse(&read,None).unwrap();
    let root = tree.root_node();

    let mut state = ConverterPassable::default();
    state.tokens.push(format!("//sexp tree: {}",tree.root_node().to_sexp()));
    converter(root, &read,&mut state);

    let _ = fs::write("OpenComputers.kt", state.tokens.join(""));    
    //println!("Hello, world!");
}
