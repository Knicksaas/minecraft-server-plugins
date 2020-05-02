package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.World;
import org.bukkit.WorldBorder;

public class Worldborder {
	
	private static WorldBorder border;
	
	public static void setWorldBorder() {
		World world = Variables.plugin.getServer().getWorld("world");
		if(world.getWorldBorder() != null) {
			border = world.getWorldBorder();
		}
		border.setCenter(Variables.config.getInt("General.middle.x"), Variables.config.getInt("General.middle.z"));
		border.setSize(Variables.config.getDouble("General.borderSize"));
		border.setWarningDistance(2);
	}

	public static void removeWorldBorder() {
		border.reset();
	}
}
