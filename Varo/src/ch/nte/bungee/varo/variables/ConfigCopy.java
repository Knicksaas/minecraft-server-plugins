package ch.nte.bungee.varo.variables;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigCopy {
	
	public static int teamAmount;
	public static int borderSize;
	public static int dailyTime;
	
	public static Location spawn;

	public static void copyConfig(FileConfiguration config) {
		teamAmount = config.getInt("General.TeamAmount");
		borderSize = config.getInt("General.BorderRadius");
		dailyTime = config.getInt("General.DailyOnlineTime");
		
		spawn = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Locations.Spawn.x"), 100, config.getDouble("Locations.Spawn.z"));
	}
}
