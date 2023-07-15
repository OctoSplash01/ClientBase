package me.octo.client.features.example

import me.octo.client.ClientBase.Companion.mc
import me.octo.client.config.Config
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

class Example {
    @SubscribeEvent
    fun onTick(e: TickEvent.PlayerTickEvent) {
        if (mc.thePlayer.onGround && Config.example) mc.thePlayer.jump()
    }
}