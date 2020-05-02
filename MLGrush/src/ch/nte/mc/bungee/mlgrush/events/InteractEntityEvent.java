package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import ch.nte.mc.bungee.mlgrush.main.InventorySetter;

public class InteractEntityEvent implements Listener{

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			e.setCancelled(true);
			InventorySetter invSetter = new InventorySetter();
			Inventory inv = invSetter.getInventory(e.getPlayer());
			e.getPlayer().openInventory(inv);
		}
	}
}
