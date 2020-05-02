package ch.nte.mc.bungee.bedwars.cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ch.nte.mc.bungee.bedwars.objects.Team;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class TablistUpdater implements Listener {

	public static void updateTablist() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			if(MainVariables.playerTeamMap.get(p) != null) {
				Team team = MainVariables.playerTeamMap.get(p);
				p.setPlayerListName(team.getColor()+team.getColor().name() + Messages.spaceBarBetweenName + team.getColor() + p.getDisplayName());
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		updateTablist();
	}
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		updateTablist();
	}
	
}
