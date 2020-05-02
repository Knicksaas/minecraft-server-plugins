package ch.nte.mc.bungee.bedwars.variables;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigCopy {
	
	public static int getTeamSize;
	public static int getTeamAmount;
	public static int getRadius;
	
	public static Location lobby;
	public static Location middle;
	public static Location spawnTeam1;
	public static Location spawnTeam2;
	public static Location spawnTeam3;
	public static Location spawnTeam4;
	
	public static void copyConfig(FileConfiguration config) {
		getTeamSize = config.getInt("General.TeamSize");
		getTeamAmount = config.getInt("General.TeamAmount");
		getRadius = config.getInt("General.Radius");
		
		lobby = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.Lobby.x"), config.getDouble("Spawns.Lobby.y"),
				config.getDouble("Spawns.Lobby.z"), (float) config.getDouble("Spawns.Lobby.yaw"), 0f);
		middle = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.Middle.x"), config.getDouble("Spawns.Middle.y"),
				config.getDouble("Spawns.Middle.z"));
		spawnTeam1 = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.SpawnTeam1.x"),
				config.getDouble("Spawns.SpawnTeam1.y"), config.getDouble("Spawns.SpawnTeam1.z"), (float) config.getDouble("Spawns.SpawnTeam1.yaw"), 0f);
		spawnTeam2 = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.SpawnTeam2.x"),
				config.getDouble("Spawns.SpawnTeam2.y"), config.getDouble("Spawns.SpawnTeam2.z"), (float) config.getDouble("Spawns.SpawnTeam2.yaw"), 0f);
		spawnTeam3 = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.SpawnTeam3.x"),
				config.getDouble("Spawns.SpawnTeam3.y"), config.getDouble("Spawns.SpawnTeam3.z"), (float) config.getDouble("Spawns.SpawnTeam3.yaw"), 0f);
		spawnTeam4 = new Location(Bukkit.getServer().getWorld("world"), config.getDouble("Spawns.SpawnTeam4.x"),
				config.getDouble("Spawns.SpawnTeam4.y"), config.getDouble("Spawns.SpawnTeam4.z"), (float) config.getDouble("Spawns.SpawnTeam4.yaw"), 0f);
	}
}
