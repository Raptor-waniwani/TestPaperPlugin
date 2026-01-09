package com.github.raptorwaniwani.sneaksugarvaneharvest

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin


class SneakSugarCaneHarvest : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic

        server.pluginManager.registerEvents(EventListener, this)
    }
    override fun onDisable() {
        // Plugin shutdown logic
    }
}

object EventListener : Listener {
    private val HOES = setOf(
        Material.WOODEN_HOE,
        Material.STONE_HOE,
        Material.IRON_HOE,
        Material.GOLDEN_HOE,
        Material.DIAMOND_HOE,
        Material.NETHERITE_HOE
    )


    @EventHandler
    fun onRightClick(event: PlayerInteractEvent) {
        val player = event.player
        val item = player.inventory.itemInMainHand

        if (!event.player.isSneaking) return
        // 右クリックしたブロックのみ対象
        if (event.action != Action.RIGHT_CLICK_BLOCK) return


        // クワを持っていなければ無視
        if (item.type !in HOES) return

        val click = event.clickedBlock ?: return

        // サトウキビ以外は無視
        if (click.type !== Material.SUGAR_CANE) return

        // 一番下のサトウキビを探す
        var base = click
        while (base.getRelative(BlockFace.DOWN).type === Material.SUGAR_CANE) {
            base = base.getRelative(BlockFace.DOWN)
        }

        // 2段目以降をすべて破壊
        var above = base.getRelative(BlockFace.UP)
        var found = false
        while (above.type === Material.SUGAR_CANE) {
            found = true
            above.type = Material.AIR
            base.world.dropItemNaturally(above.location, ItemStack(Material.SUGAR_CANE))
            above = above.getRelative(BlockFace.UP)
        }

        if (found) event.player.sendMessage("サトウキビを収穫しました！")
    }
}
