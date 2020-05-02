package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import ch.nte.mc.bungee.mlgrush.main.MapResetter;
import ch.nte.mc.bungee.mlgrush.main.SandstoneBlock;
import ch.nte.mc.bungee.mlgrush.main.Variables;


public class SetBlockEvent implements Listener{

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(Variables.adminList.contains(e.getPlayer().getName())) {
			return;
		} 
		if(!Variables.go) {
			e.setCancelled(true);
		} else {
			MapResetter.blockList.add(new SandstoneBlock(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()));
		}
	}
	
	
	@EventHandler
	public void onPlaceToHigh(BlockPlaceEvent e) {
		if(Variables.adminList.contains(e.getPlayer().getName())) {
			return;
		} 
		if(Variables.go) {
			if(e.getBlock().getY() >= Variables.spawnRed.getBlockY()) {
				e.setCancelled(true);
			}
		}
	}
}
