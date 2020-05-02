package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import ch.nte.mc.bungee.bedwars.teams.Spectator;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class SpawnManager implements Listener {
	
	@EventHandler
	public void onPlayerDie(PlayerDeathEvent e) {
		if(MainVariables.isGameRunning) {
			e.getEntity().spigot().respawn();
			e.getDrops().clear();
			e.getEntity().teleport(MainVariables.playerTeamMap.get(e.getEntity()).getSpawn());
		} else {
			e.getEntity().spigot().respawn();
			e.getDrops().clear();
			e.getEntity().teleport(ConfigCopy.lobby);
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(MainVariables.isGameRunning) {
			Spectator.setToSpecMode(e.getPlayer());
			e.getPlayer().teleport(ConfigCopy.middle);
		} else {
			e.getPlayer().teleport(ConfigCopy.lobby);
		}
	}
}
