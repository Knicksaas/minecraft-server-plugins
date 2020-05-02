package ch.nte.mc.bungee.bedwars.variables;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.main.Main;
import ch.nte.mc.bungee.bedwars.objects.PlaceableBlock;
import ch.nte.mc.bungee.bedwars.objects.Team;

public class MainVariables {
	
	public static Main plugin;
	
	public static FileConfiguration config;

	public static boolean isGameRunning;
	public static boolean isCountdownRunning;
	
	public static Team team1; 
	public static Team team2;
	public static Team team3;
	public static Team team4;
	
	public static Map<Player, Team> playerTeamMap = new HashMap<>();
	
	public static List<PlaceableBlock> blocks = new ArrayList<>();
	public static List<String> adminList = new ArrayList<>();
}