package me.octo.client

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import lombok.SneakyThrows
import me.octo.client.commands.ConfigCommand
import me.octo.client.config.Config
import me.octo.client.features.example.Example
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.Event


@Mod(modid = "clientbase", name = "ClientBase", version = "1.0.0", clientSideOnly = true)
class ClientBase {

    @Mod.EventHandler
    @SneakyThrows
    fun init(event: FMLInitializationEvent?) {
        MinecraftForge.EVENT_BUS.register(this)
        Config().preload()
        registerEvents(
            Example()
        )
        registerCommand(ConfigCommand())
    }

    private fun registerEvents(vararg events: Any) {
        for (event in events) MinecraftForge.EVENT_BUS.register(event)
    }

    private fun registerCommand(vararg commands: Command) {
        for (command in commands) EssentialAPI.getCommandRegistry().registerCommand(command)
    }

    companion object {
        val mc: Minecraft = Minecraft.getMinecraft()
    }
}