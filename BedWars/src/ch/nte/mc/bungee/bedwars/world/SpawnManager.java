package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ch.nte.mc.bungee.bedwars.cosmetics.ScoreBoardManager;
import ch.nte.mc.bungee.bedwars.main.GameStopMechanism;
import ch.nte.mc.bungee.bedwars.teams.Spectator;
import ch.nte.mc.bungee.bedwars.teams.TeamChooser;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class SpawnManager implements Listener {
	
	@EventHandler
	public void onPlayerDie(PlayerDeathEvent e) {
		Player p = e.getEntity();
        if(p.getKiller() instanceof Player) {
            p.sendMessage(Messages.prefix + MainVariables.playerTeamMap.get(p).getColor() + e.getEntity().getName() + 
            		Messages.playerKilledByPlayerMsg + MainVariables.playerTeamMap.get(p.getKiller()).getColor() + p.getKiller().getName());
        }
		e.setDeathMessage(Messages.prefix + MainVariables.playerTeamMap.get(e.getEntity()).getColor() + e.getEntity().getName() + Messages.suicideMessage);
		
		if(MainVariables.isGameRunning) {
			e.getEntity().spigot().respawn();
			e.getDrops().clear();
			if(MainVariables.playerTeamMap.get(e.getEntity()).hasBed()) {
				e.getEntity().teleport(MainVariables.playerTeamMap.get(e.getEntity()).getSpawn());
			} else {
				e.getEntity().teleport(ConfigCopy.middle);
				e.getEntity().setGameMode(GameMode.SPECTATOR);
				TeamChooser.removeFromTeam(e.getEntity());
				ScoreBoardManager.updateScoreBoard();
				GameStopMechanism.checkIfIsGameEnd();
			}
		} else {
			e.getEntity().spigot().respawn();
			e.getDrops().clear();
			e.getEntity().teleport(ConfigCopy.lobby);
		}
	}
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		TeamChooser.removeFromTeam(e.getPlayer());
		ScoreBoardManager.updateScoreBoard();
		GameStopMechanism.checkIfIsGameEnd();
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
