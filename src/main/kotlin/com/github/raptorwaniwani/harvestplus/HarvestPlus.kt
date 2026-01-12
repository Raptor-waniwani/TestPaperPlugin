package com.github.raptorwaniwani.harvestplus

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin


class HarvestPlus : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic

        server.pluginManager.registerEvents(EventListener, this)
    }
    override fun onDisable() {
        // Plugin shutdown logic
    }

object EventListener : Listener {

    }
}
