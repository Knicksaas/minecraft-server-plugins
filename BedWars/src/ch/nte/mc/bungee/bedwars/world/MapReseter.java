package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import ch.nte.mc.bungee.bedwars.objects.PlaceableBlock;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class MapReseter {

	public static void resetMap() {
		for(int i = 0; i<MainVariables.blocks.size(); i++) {
			PlaceableBlock block = MainVariables.blocks.get(i);
			Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()).setType(Material.AIR);
		}
		MainVariables.blocks.clear();
	}
}
