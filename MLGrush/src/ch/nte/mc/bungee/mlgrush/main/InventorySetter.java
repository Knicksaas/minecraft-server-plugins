package ch.nte.mc.bungee.mlgrush.main;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class InventorySetter {
	
	public static void itemInit() {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemStack pick = new ItemStack(Material.WOOD_PICKAXE);
		ItemStack block = new ItemStack(Material.SANDSTONE, 64);
		
		ItemMeta metaStick = stick.getItemMeta();
		ItemMeta metaPick = pick.getItemMeta();
		
		metaStick.addEnchant(Enchantment.KNOCKBACK, 1, true);
		metaPick.addEnchant(Enchantment.DIG_SPEED, 1, true);
		metaPick.addEnchant(Enchantment.DURABILITY, 100, true);
		
		stick.setItemMeta(metaStick);
		pick.setItemMeta(metaPick);
		
		Variables.pick = pick;
		Variables.stick = stick;
		Variables.block = block;
	}
	
	public void addInventoryConfig(UUID uuid, int stickSlot, int pickAxeSlot, int blockSlot) {
		String stUUID = uuid.toString();
		File file = new File(Variables.plugin.getDataFolder().getPath(), "inventorys.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(stUUID + ".Slot." + "stick", stickSlot);
		cfg.set(stUUID + ".Slot." + "pick", pickAxeSlot);
		cfg.set(stUUID + ".Slot." + "block", blockSlot);
		
		try {
			cfg.save(file);
			System.out.println("File saved!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Inventory getInventory(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(null, 9, Messages.configureInvMsg);
		String stUUID = p.getUniqueId().toString();
		
		File file = new File(Variables.plugin.getDataFolder().getPath(), "inventorys.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int slotStick;
		int slotPick;
		int slotBlock;
		
		if(!cfg.contains(stUUID)) {
			slotStick = 0;
			slotPick = 1;
			slotBlock = 8;
		} else {
			slotStick = cfg.getInt(stUUID + ".Slot." + "stick");
			slotPick = cfg.getInt(stUUID + ".Slot." + "pick");
			slotBlock = cfg.getInt(stUUID + ".Slot." + "block");
		}
		inv.setItem(slotStick, Variables.stick);
		inv.setItem(slotPick, Variables.pick);
		inv.setItem(slotBlock, Variables.block);
		return inv;
	}
	
	public void getInventroyConfig(Player p) {
		String stUUID = p.getUniqueId().toString();
		
		File file = new File(Variables.plugin.getDataFolder().getPath(), "inventorys.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int slotStick;
		int slotPick;
		int slotBlock;
		
		if(!cfg.contains(stUUID)) {
			slotStick = 0;
			slotPick = 1;
			slotBlock = 8;
		} else {
			slotStick = cfg.getInt(stUUID + ".Slot." + "stick");
			slotPick = cfg.getInt(stUUID + ".Slot." + "pick");
			slotBlock = cfg.getInt(stUUID + ".Slot." + "block");
		}
		
		p.getInventory().setItem(slotStick, Variables.stick);
		p.getInventory().setItem(slotPick, Variables.pick);
		p.getInventory().setItem(slotBlock, Variables.block);
	}
}
