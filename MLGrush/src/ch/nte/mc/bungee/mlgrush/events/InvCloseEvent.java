package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ch.nte.mc.bungee.mlgrush.main.InventorySetter;
import ch.nte.mc.bungee.mlgrush.main.Messages;

public class InvCloseEvent implements Listener{

	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		int stickSlot = 0;
		int pickSlot = 0;
		int blockSlot = 0;
		
		if(e.getInventory().getTitle() == Messages.configureInvMsg) {
			Inventory inventory = e.getInventory();
			for(int i = 0; i < inventory.getSize(); i++) {
				ItemStack item = inventory.getItem(i);
				if(item != null) {
					if(inventory.getItem(i).getType().toString().equalsIgnoreCase("stick")) {
						stickSlot = i;
						System.out.println("Stick slot: " + i);
					} else if (inventory.getItem(i).getType().toString().equalsIgnoreCase("wood_pickaxe")) {
						pickSlot = i;
						System.out.println("pick slot: " + i);
					} else if (inventory.getItem(i).getType().toString().equalsIgnoreCase("sandstone")) {
						blockSlot = i;
						System.out.println("block slot: " + i);
					} else {
						System.out.println("At slot were noting: " + i);
					}
				}
				
			}
			InventorySetter invSetter = new InventorySetter();
			invSetter.addInventoryConfig(e.getPlayer().getUniqueId(), stickSlot, pickSlot, blockSlot);
			System.out.println("Inv closed, save config");
		}
	}
}
