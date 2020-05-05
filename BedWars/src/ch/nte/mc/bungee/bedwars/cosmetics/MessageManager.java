package ch.nte.mc.bungee.bedwars.cosmetics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class MessageManager implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(Messages.prefix + e.getPlayer().getName()+ Messages.joinMessage);
	}
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		if(MainVariables.playerTeamMap.get(e.getPlayer()) != null) {
			e.setQuitMessage(Messages.prefix + MainVariables.playerTeamMap.get(e.getPlayer()).getColor() + e.getPlayer().getName() + Messages.quitMessage);
		}
		e.setQuitMessage(Messages.prefix + e.getPlayer().getName() + Messages.quitMessage);
	}
}
