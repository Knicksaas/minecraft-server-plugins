package ch.nte.mc.bungee.bedwars.world;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class Spawner {

	public static void startSpawner() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainVariables.plugin, new Runnable() {
			@Override
			public void run() {
				ItemStack item = new ItemStack(Material.CLAY_BRICK);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§cBronze");
				item.setItemMeta(meta);
				spawn("bronze", item);
			}
		}, 20, 20);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainVariables.plugin, new Runnable() {
			@Override
			public void run() {
				ItemStack item = new ItemStack(Material.IRON_INGOT);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7Iron");
				item.setItemMeta(meta);
				spawn("iron", item);
			}
		}, 20*10, 20*10);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainVariables.plugin, new Runnable() {
			@Override
			public void run() {
				ItemStack item = new ItemStack(Material.GOLD_INGOT);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6Gold");
				item.setItemMeta(meta);
				spawn("gold", item);
			}
		}, 20*30, 20*30);
	}
	
	public static void setSpawn(String type, Location loc) {
		int i = 0;
		
		File file = new File(MainVariables.plugin.getDataFolder().getPath(), "spawner.yml");
		YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
		
		i = conf.getInt(type + ".amount");
		i++;
		conf.set(type + ".amount", i);
		
		conf.set(type + "." + i + ".world", loc.getWorld().getName());
		conf.set(type + "." + i + ".x", loc.getX());
		conf.set(type + "." + i + ".y", loc.getY());
		conf.set(type + "." + i + ".z", loc.getZ());
		
		try {
			conf.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void spawn(String type, ItemStack item) {
		File file = new File(MainVariables.plugin.getDataFolder().getPath(), "spawner.yml");
		YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
		
		int amount = conf.getInt(type + ".amount");
		
		for(int i = 1; i<amount+1; i++) {
			String world = conf.getString(type + "." + i +".world");
			double x = conf.getDouble(type + "." + i + ".x");
			double y = conf.getDouble(type + "." + i + ".y");
			double z = conf.getDouble(type + "." + i + ".z");
			Location loc = new Location(Bukkit.getWorld(world), x, y, z);
			
			loc.getWorld().dropItemNaturally(loc, item);
		}
	}
}
