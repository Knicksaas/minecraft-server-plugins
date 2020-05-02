package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ch.nte.mc.bungee.mlgrush.main.MapResetter;
import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.PrefixManager;
import ch.nte.mc.bungee.mlgrush.main.Variables;
import ch.nte.mc.bungee.mlgrush.main.Worldborder;

public class PlayerLeaveEvent implements Listener {

	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		Worldborder.removeWorldBorder();
		Bukkit.getServer().setWhitelist(false);
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.DARK_GREEN + p.getName()+ Messages.leaveMsg);
		
	}
	
	@EventHandler
	public void playerDisconnect(PlayerQuitEvent e) {
		if(Variables.go) {
			MapResetter.resetMap();
			for(Player k : Bukkit.getServer().getOnlinePlayers()) {
				k.kickPlayer("Game over! The other Player left the game.");
			}
		
		} else {
			removePlayer(e.getPlayer());
		}
	}
	
	public static void removePlayer(Player p) {
		if(Variables.isRunning) {
			Variables.isRunning = false;
			System.out.println(Messages.gameAbortMsg);
			Bukkit.broadcastMessage(ChatColor.RED + Messages.gameAbortMsg);
		}
		if(Variables.pRed == p) {
			Variables.pRed = null;
			PrefixManager.updatePrefix();
			if(Variables.pBlue == p) {
				Variables.pBlue = null;
				PrefixManager.updatePrefix();
				System.err.println(Messages.errorMsg + " player add hasn't worked!");
			}
		} else if (Variables.pBlue == p) {
			Variables.pBlue = null;
			PrefixManager.updatePrefix();
			if(Variables.pRed == p) {
				Variables.pRed = null;
				PrefixManager.updatePrefix();
				System.err.println(Messages.errorMsg + " player add hasn't worked!");
			}
		} else {
			p.sendMessage(ChatColor.RED + Messages.errorMsg + " List is full!");
		}
	}
}
