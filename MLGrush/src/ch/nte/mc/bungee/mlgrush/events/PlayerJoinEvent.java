package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.PrefixManager;
import ch.nte.mc.bungee.mlgrush.main.Run;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class PlayerJoinEvent implements Listener {
	
	@EventHandler
	public void OnJoinClearInv(org.bukkit.event.player.PlayerJoinEvent e) {
		e.getPlayer().getInventory().clear();
	}
	
	@EventHandler
	public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(ChatColor.DARK_GREEN + p.getName()+ Messages.joinMsg);
		
		Location loc = new Location(Bukkit.getServer().getWorld("world"), 
				Variables.config.getDouble("LobbyCoords.x"), Variables.config.getDouble("LobbyCoords.y"), Variables.config.getDouble("LobbyCoords.z"));
		p.teleport(loc);
	}
	
	@EventHandler
	public void twoPlayersOnline(org.bukkit.event.player.PlayerJoinEvent e) {
		if(Variables.isRunning) {
			System.out.println("Game running, return;");
			return;
		} else {
			addPlayer(e.getPlayer());
		}
		if(Bukkit.getServer().getOnlinePlayers().size() == 2) {
			System.out.println("2 Players are online");
			if(Variables.pRed != null && Variables.pBlue != null) {
				System.out.println(Messages.startGameMsg);
				new Run(Variables.plugin);
			}
		}
	}
	
	public static void addPlayer(Player p) {
		if(Variables.pRed == null) {
			Variables.pRed = p;
			PrefixManager.updatePrefix();
		} else if (Variables.pBlue == null) {
			Variables.pBlue = p;
			PrefixManager.updatePrefix();
		} else {
			p.sendMessage(ChatColor.RED + Messages.errorMsg + " List is full!");
		}
	}
}
