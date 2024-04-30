//sexp tree: (compilation_unit (package_clause name: (package_identifier (identifier) (identifier) (identifier))) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) path: (identifier)) (import_declaration path: (identifier) path: (identifier) path: (identifier) path: (identifier) (namespace_wildcard)) (object_definition (annotation name: (type_identifier) arguments: (arguments (field_expression value: (identifier) field: (identifier)))) name: (identifier) body: (template_body (val_definition (modifiers) pattern: (identifier) value: (string)) (val_definition (modifiers) pattern: (identifier) value: (string)) (val_definition (modifiers) pattern: (identifier) value: (string)) (val_definition (modifiers) pattern: (identifier) value: (string)) (val_definition (modifiers) pattern: (identifier) type: (type_identifier) value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (identifier)))) (val_definition pattern: (identifier) type: (type_identifier) value: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier))) (call_expression function: (field_expression value: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)) field: (identifier)) field: (identifier)) arguments: (arguments (identifier))) (comment) (call_expression function: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier)))) (call_expression function: (field_expression value: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)) field: (identifier)) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier)))) (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (call_expression function: (field_expression value: (call_expression function: (field_expression value: (call_expression function: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier)) arguments: (arguments)) field: (identifier)) arguments: (arguments (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (string) (string))))) field: (identifier)) arguments: (arguments)))) (call_expression function: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier)) arguments: (arguments)) (call_expression function: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier)) arguments: (arguments (identifier))) (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)) (comment) (function_definition (annotation name: (type_identifier)) name: (identifier) parameters: (parameters (parameter name: (identifier) type: (generic_type type: (stable_type_identifier (identifier) (type_identifier)) type_arguments: (type_arguments (type_identifier))))) body: (block (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)))) (function_definition (annotation name: (type_identifier)) name: (identifier) parameters: (parameters (parameter name: (identifier) type: (generic_type type: (stable_type_identifier (identifier) (type_identifier)) type_arguments: (type_arguments (type_identifier))))) body: (block (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)))) (function_definition (annotation name: (type_identifier)) name: (identifier) parameters: (parameters (parameter name: (identifier) type: (type_identifier))) return_type: (type_identifier) body: (block (comment) (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (ascription_expression (parenthesized_expression (lambda_expression parameters: (bindings) (block (call_expression function: (field_expression value: (field_expression value: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier)))) field: (identifier)) field: (identifier)) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier))))))) (type_identifier)))))) (val_definition (modifiers) pattern: (identifier) type: (type_identifier) value: (block (val_definition pattern: (identifier) value: (match_expression value: (field_expression value: (field_expression value: (identifier) field: (identifier)) field: (identifier)) body: (case_block (case_clause pattern: (stable_identifier (identifier) (identifier)) body: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (string)))) (case_clause pattern: (wildcard) body: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (string))))))) (generic_function function: (field_expression value: (call_expression function: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)) field: (identifier)) arguments: (arguments)) field: (identifier)) type_arguments: (type_arguments (type_identifier))))) (var_definition pattern: (identifier) type: (type_identifier) value: (null_literal)) (comment) (comment) (comment) (comment) (comment) (comment))) (class_definition name: (identifier) body: (template_body)))package li.cil.oc

import java.nio.file.Paths
import li.cil.oc.common.IMC
import li.cil.oc.common.Proxy
import li.cil.oc.common.init.Blocks
import li.cil.oc.common.init.Items
import li.cil.oc.integration.Mods
import li.cil.oc.util.ThreadPoolFactory
import net.minecraft.block.Block
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.world.World
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.forgespi.Environment
import net.minecraftforge.fml.InterModComms
import net.minecraftforge.fml.ModContainer
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.fml.loading.FMLPaths
import net.minecraftforge.fml.network.simple.SimpleChannel
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import scala.collection.convert.ImplicitConversionsToScala.*
@Mod(OpenComputers.ID)
object OpenComputers
{
val ID = "opencomputers"
val Name = "OpenComputers"
val McVersion = "@MCVERSION@-forge"
val Version = "@VERSION@"
val log: Logger = LogManager.getLogger(Name)
val modContainer: ModContainer = ModLoadingContext.get.getActiveContainer
//OpenComputers.instance = Some()
// Must happen after loading Settings but before registry events are fired.

@SubscribeEvent
fun registerBlocks(e: RegistryEvent.Register<Block>){
}

@SubscribeEvent
fun registerItems(e: RegistryEvent.Register<Item>){
}

@SubscribeEvent
fun imc(e: InterModProcessEvent): Unit{
// Technically requires synchronization because IMC.sendTo doesn't check the loading stage.
}
val proxy: Proxy = {
val cls = when (Environment.get.getDist) 
{
Dist.CLIENT -> Class.forName("li.cil.oc.client.Proxy")
_ -> Class.forName("li.cil.oc.common.Proxy")
}

//TODO: UNHANDLED: generic_function sexp: (generic_function function: (field_expression value: (call_expression function: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments)) field: (identifier)) arguments: (arguments)) field: (identifier)) type_arguments: (type_arguments (type_identifier))) scala:
// cls.getConstructor().newInstance().asInstanceOf[Proxy]
}

var channel: SimpleChannel = null
//  private var instance: Option[OpenComputers] = None
//
//  def get = instance match {
//    case Some(oc) => oc
//    case _ => throw new IllegalStateException("not initialized")
//  }

init {
	FMLJavaModLoadingContext.get()
	.getModEventBus.register(this)
	MinecraftForge.EVENT_BUS.register(OpenComputers.proxy)
	FMLJavaModLoadingContext.get()
	.getModEventBus.register(OpenComputers.proxy)
	Paths.get("opencomputers"//TODO: UNHANDLED: , sexp: (",") scala:
// ,
"settings.conf")
	FMLPaths.CONFIGDIR.get().resolve().toFile()
	Settings.load()
	OpenComputers.proxy.preInit()
	MinecraftForge.EVENT_BUS.register(ThreadPoolFactory)
	Mods.preInit()
	Blocks.init()
	Items.init()
	e.enqueueWork(//TODO: UNHANDLED: ascription_expression sexp: (ascription_expression (parenthesized_expression (lambda_expression parameters: (bindings) (block (call_expression function: (field_expression value: (field_expression value: (field_expression value: (call_expression function: (field_expression value: (identifier) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier)))) field: (identifier)) field: (identifier)) field: (identifier)) arguments: (arguments (field_expression value: (identifier) field: (identifier))))))) (type_identifier)) scala:
// (() => {
//       InterModComms.getMessages(OpenComputers.ID).sequential.iterator.foreach(IMC.handleMessage)
//     }): Runnable
)
}
}
class OpenComputers
{
}
