package ch.nte.mc.bungee.bedwars.variables;

import org.bukkit.ChatColor;

public class Messages {
	
	public static final ChatColor textColor = ChatColor.GRAY;
	public static final ChatColor contrastColor = ChatColor.YELLOW;
	public static final String prefix = textColor + "[" + ChatColor.YELLOW + "BedWars" + textColor + "] ";

	public static final String spaceBarBetweenName = textColor + " | ";

	public static final String alreadyInTeam = prefix + "You are already in this Team";
	public static final String teamAlreadyFull = prefix + "This team is already full! Choose an other one!";
	public static final String joninedTeam = prefix +"You successfully joined Team: ";
	public static final String noPermission = prefix + ChatColor.RED + "You don't have the permissions to perform this command!";
	public static final String playerOnlyCommand = "This is a player only command!";
	public static final String successfullLoggedIn = prefix +ChatColor.GREEN + "You are successfully logged in";
	public static final String successfullyLoggedOut = prefix +ChatColor.GREEN + "You are successfully logged out";
	public static final String alreadyLoggedIn = prefix +ChatColor.RED + "You are already logged in";
	public static final String alreadyLoggedOut = prefix +ChatColor.RED + "You are already logged out";
	public static final String configReloaded = "Config Reloaded!";
	
	public static final String joinMessage = textColor + " joined the game!";
	public static final String quitMessage = textColor + " left the game!";
	public static final String reloadCounter = prefix + "Server will restart in " + contrastColor +" %TIME% " + textColor +"seconds";
	
	public static final String suicideMessage = textColor + " died!";
	public static final String playerKilledByPlayerMsg = textColor + " was killed by ";
	
	public static final String ownBedMsg = prefix + "you can't destroy your own bed! You stupid human!";
	public static final String destroydBed = " destroyed the bed of team ";
	public static final String uCantSleep =  prefix + "You should win the game and not sleep in a bed!";
	
	public static final String commingSoon = "comming soon!";
	public static final String reloadMsg = ChatColor.RED + "The server is restarting... Dont waste yout time and choos a other game!";
}
