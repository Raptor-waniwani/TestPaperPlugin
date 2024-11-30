package com.github.raptorwaniwani.testPaperPlugin

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit.getServer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class TestPaperPlugin : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        println("wani hoge")
        server.pluginManager.registerEvents(EventListener, this)
    }
    override fun onDisable() {
        // Plugin shutdown logic
    }
}
object EventListener : Listener {
    @EventHandler
    fun onBreake(breakeE: BlockBreakEvent){
        var breaketext = Component.text("${breakeE.player.name}がBlockを破壊した。")
        //componentをインスタンス化
        getServer().broadcast(breaketext)
    }
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        var onJoinText = Component.text("§e${event.player.name}が参加しましま。")
        event.joinMessage(onJoinText)
    }
}
