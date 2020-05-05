package ch.nte.mc.bungee.bedwars.teams;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class FriendlyFireManager implements Listener {

	@EventHandler
	public void onPlayerHit(EntityDamageByEntityEvent e) {
		try {
			if(e.getDamager() instanceof Player) {
				if(e.getEntity() instanceof Player) {
					if(MainVariables.playerTeamMap.get((Player) e.getEntity()).getID() == (MainVariables.playerTeamMap.get((Player)e.getDamager()).getID())){
						e.setCancelled(true);
					}
				}
			} else if (e.getDamager() instanceof Arrow) {
				Arrow arrow = (Arrow) e.getEntity();
				if(MainVariables.playerTeamMap.get((Player) e.getEntity()).getID() == (MainVariables.playerTeamMap.get((Player)arrow.getShooter()).getID())){
					e.setCancelled(true);
				}
			}
		} catch (Exception ex) {
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if(!MainVariables.isGameRunning) {
			e.setCancelled(true);
		}
	}

}
