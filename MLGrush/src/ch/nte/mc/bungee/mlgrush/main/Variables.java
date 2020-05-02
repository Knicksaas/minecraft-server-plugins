package ch.nte.mc.bungee.mlgrush.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Variables {
	
	public static Main plugin = null;
	public static FileConfiguration config = null;
	public static List<String> adminList = new ArrayList<>();
	public static boolean isRunning = false;
	public static boolean go = false;
	
	public static Player pBlue = null;
	public static Player pRed = null;
	
	public static Location spawnRed;
	public static Location spawnBlue;
	
	
	public static int pointsRed = 0;
	public static int pointsBlue = 0;
	
	public static ItemStack stick;
	public static ItemStack pick;
	public static ItemStack block;

}
