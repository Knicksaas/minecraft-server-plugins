package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import ch.nte.mc.bungee.bedwars.objects.PlaceableBlock;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class BuildDisabler implements Listener {

	@EventHandler
	public void onBuild(BlockPlaceEvent e) {
		if(!MainVariables.adminList.contains(e.getPlayer().getName())) {
			MainVariables.blocks.add(new PlaceableBlock(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()));
			if(!MainVariables.isGameRunning) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDestroy(BlockBreakEvent e) {
		if(!MainVariables.adminList.contains(e.getPlayer().getName())) {
			System.out.println(MainVariables.blocks.size());
			for(int i = 0; i<MainVariables.blocks.size(); i++) {
				PlaceableBlock block = MainVariables.blocks.get(i);
				if(block.getX() == e.getBlock().getX()) {
					if(block.getY() == e.getBlock().getY()) {
						if(block.getZ() == e.getBlock().getZ()) {
							e.setCancelled(false);
							return;
						} else {
							e.setCancelled(true);
						}
					} else {
						e.setCancelled(true);
					}
				} else {
					e.setCancelled(true);
				}
			}
			e.setCancelled(true);
		}
	}
}
