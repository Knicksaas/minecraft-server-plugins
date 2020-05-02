package ch.nte.mc.bungee.bedwars.villager;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class Villager implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			e.setCancelled(true);
			Player p = e.getPlayer();
			
			createMenu(p);
			
		}
	}
	
	private static void createMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "Choose a category!");
		
		inv.setItem(0, getCustomPane("", (byte) 15));
		inv.setItem(1, getCustomPane("", (byte) 15));
		inv.setItem(2, getCustomPane("", (byte) 15));
		inv.setItem(3, getCustomPane("", (byte) 15));
		inv.setItem(4, getCustomPane("", (byte) 15));
		inv.setItem(5, getCustomPane("", (byte) 15));
		inv.setItem(6, getCustomPane("", (byte) 15));
		inv.setItem(7, getCustomPane("", (byte) 15));
		inv.setItem(8, getCustomPane("", (byte) 15));
		
		inv.setItem(9, getCustomItem(Material.SANDSTONE, "§eBlocks"));
		inv.setItem(10, getCustomItem(Material.CHAINMAIL_CHESTPLATE, "§6Armor"));
		inv.setItem(11, getCustomItem(Material.STONE_PICKAXE, "§8Tools"));
		inv.setItem(12, getCustomItem(Material.IRON_SWORD, "§7Weapons"));
		inv.setItem(13, getCustomItem(Material.BOW, "§4Bows"));
		inv.setItem(14, getCustomItem(Material.APPLE, "§cFood"));
		inv.setItem(15, getCustomItem(Material.POTION, "§9Drinks"));
		inv.setItem(16, getCustomItem(Material.CHEST, "§aStorage"));
		inv.setItem(17, getCustomItem(Material.TNT, "§5Special!"));
		
		inv.setItem(18, getCustomPane("", (byte) 15));
		inv.setItem(19, getCustomPane("", (byte) 15));
		inv.setItem(20, getCustomPane("", (byte) 15));
		inv.setItem(21, getCustomPane("", (byte) 15));
		inv.setItem(22, getCustomPane("", (byte) 15));
		inv.setItem(23, getCustomPane("", (byte) 15));
		inv.setItem(24, getCustomPane("", (byte) 15));
		inv.setItem(25, getCustomPane("", (byte) 15));
		inv.setItem(26, getCustomPane("", (byte) 15));
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getInventory().getName().equalsIgnoreCase("Choose a category!")) {
			e.setCancelled(true);
			Merchant villager = new Merchant();
			Player p = (Player)e.getWhoClicked();
			switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§eBlocks":
					Recipes.addBlocks(villager);
					villager.setTitle("§eBlocks");
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§6Armor":
					villager.setTitle("§6Armor");
					switch (MainVariables.playerTeamMap.get(p).getColor().name()) {
						case "RED":
							Recipes.addArmor(villager, Color.RED);
							break;
						case "BLUE":
							Recipes.addArmor(villager, Color.BLUE);
							break;
						case "YELLOW":
							Recipes.addArmor(villager, Color.YELLOW);
							break;
						case "GREEN":
							Recipes.addArmor(villager, Color.GREEN);
							break;
					}
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§8Tools":
					villager.setTitle("§8Tools");
					Recipes.addTools(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§7Weapons":
					villager.setTitle("§7Weapons");
					Recipes.addWeapons(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§4Bows":
					villager.setTitle("§4Bows");
					Recipes.addBows(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§cFood":
					villager.setTitle("§cFood");
					Recipes.addFood(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§9Drinks":
					villager.setTitle("§9Drinks");
					Recipes.addPotions(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§aStorage":
					villager.setTitle("§aStorage");
					Recipes.addChests(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
				case "§5Special!":
					villager.setTitle("§5Special!");
					Recipes.addSpecials(villager);
					villager.setCustomer(p);
					villager.openTrading(p);
					break;
			}
		}
	}

	private static ItemStack getCustomItem(Material material, String name) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack getCustomPane(String name, byte data) {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
}
