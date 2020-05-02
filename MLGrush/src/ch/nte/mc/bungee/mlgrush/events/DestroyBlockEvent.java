package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import ch.nte.mc.bungee.mlgrush.main.BedListener;
import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class DestroyBlockEvent implements Listener {
	
	@EventHandler
	private void onBreak(BlockBreakEvent e) {
		
		BedListener bedListener = new BedListener();
		
		if(Variables.adminList.contains(e.getPlayer().getName())) {
			return;
		}
		
		if(!Variables.go) {
			e.setCancelled(true);
		}
		
		if(e.getBlock().getType() != Material.SANDSTONE) {
			e.setCancelled(true);
		}
		
		if(e.getBlock().getType() == Material.BED_BLOCK) {
			if(e.getBlock().getLocation().distance(Variables.spawnRed) < e.getBlock().getLocation().distance(Variables.spawnBlue)) {
				if(e.getPlayer().getName() == Variables.pRed.getName()) {
					e.getPlayer().sendMessage(ChatColor.RED + Messages.cantDestroyOwnBedMsg);
				} else if (e.getPlayer().getName() == Variables.pBlue.getName()) {
					Bukkit.broadcastMessage(ChatColor.GOLD + Messages.pointForMsg + e.getPlayer().getName());
					bedListener.givePointTo(e.getPlayer());
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 1);
					Variables.pRed.playSound(Variables.pRed.getLocation(), Sound.BAT_DEATH, 10, 1);
				}
			} else {
				if(e.getPlayer().getName() == Variables.pBlue.getName()) {
					e.getPlayer().sendMessage(ChatColor.RED + Messages.cantDestroyOwnBedMsg);
				} else if (e.getPlayer().getName() == Variables.pRed.getName()) {
					Bukkit.broadcastMessage(ChatColor.GOLD + Messages.pointForMsg + e.getPlayer().getName());
					bedListener.givePointTo(e.getPlayer());
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 1);
					Variables.pBlue.playSound(Variables.pBlue.getLocation(), Sound.BAT_DEATH, 10, 1);
				}
			}
		}
	}
}
