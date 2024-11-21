package com.github.raptorwaniwani.testPaperPlugin

import org.bukkit.plugin.java.JavaPlugin

class TestPaperPlugin : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        println("wani hoge")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
