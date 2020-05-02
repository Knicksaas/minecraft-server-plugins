package ch.nte.mc.bungee.bedwars.world;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;

import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;

public class BorderWorld {

	private static WorldBorder border = Bukkit.getServer().getWorld("world").getWorldBorder();
	
	public static void createBorder() {
		border.setCenter(ConfigCopy.middle);
		border.setSize(ConfigCopy.getRadius);
		border.setWarningDistance(2);
	}
	
	public static void removeBorder() {
		border.reset();
	}
}
