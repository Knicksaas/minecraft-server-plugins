package ch.nte.mc.bungee.bedwars.teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class TeamForcer {

	public static void fillTeams() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			if(!MainVariables.playerTeamMap.containsKey(p)) {
				for(int i = 1; i<5; i++) {
					TeamChooser.addToTeam(p, i);
				}
			}
		}
	}
}
