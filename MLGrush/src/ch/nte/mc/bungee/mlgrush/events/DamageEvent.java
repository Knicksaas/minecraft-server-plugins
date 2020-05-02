package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import ch.nte.mc.bungee.mlgrush.main.Variables;

public class DamageEvent implements Listener{

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(e.getCause().equals(DamageCause.ENTITY_ATTACK)) {
				if(Variables.go) {
					((Player) e.getEntity()).setHealth(20.0);
				} else {
					e.setCancelled(true);
				}
			} else {
				e.setCancelled(true);
			}
		}
	}
}
