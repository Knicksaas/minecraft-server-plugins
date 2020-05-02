package ch.nte.mc.bungee.bedwars.villager;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class VillagerProtector implements Listener {

	@EventHandler
	public void onVillagerDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity().getType().equals(EntityType.VILLAGER)) {
			e.setCancelled(true);
		}
	}
	
}
