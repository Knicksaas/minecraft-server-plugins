package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class LobbyProtector implements Listener {

	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		if(!MainVariables.isGameRunning) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(!MainVariables.isGameRunning) {
			e.setCancelled(true);
		}
	}
}
