package ch.nte.mc.bungee.mlgrush.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class MapResetter {
	
	public static List<SandstoneBlock> blockList = new ArrayList<>();
	
	public static void resetMap() {
		
		for(int i = 0; i< blockList.size(); i++) {
			SandstoneBlock block = blockList.get(i);
			Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()).setType(Material.AIR);
		}
		blockList.clear();
	}
}
