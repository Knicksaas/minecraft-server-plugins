package ch.nte.mc.bungee.bedwars.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ch.nte.mc.bungee.bedwars.commands.CMD_adminlist;
import ch.nte.mc.bungee.bedwars.commands.CMD_login;
import ch.nte.mc.bungee.bedwars.commands.CMD_logout;
import ch.nte.mc.bungee.bedwars.commands.CMD_place;
import ch.nte.mc.bungee.bedwars.commands.CMD_reloadconfig;
import ch.nte.mc.bungee.bedwars.commands.CMD_replacebed;
import ch.nte.mc.bungee.bedwars.commands.CMD_setspawner;
import ch.nte.mc.bungee.bedwars.commands.CMD_start;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.world.BedListener;
import ch.nte.mc.bungee.bedwars.world.BorderWorld;
import ch.nte.mc.bungee.bedwars.world.MapReseter;

public class Main extends JavaPlugin{
	
	public FileConfiguration config = this.getConfig();
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		MainVariables.plugin = this;
		ConfigCopy.copyConfig(config);
		MainVariables.config = config;
		Initialization.init();
		BorderWorld.removeBorder();
	}
	
	@Override
	public void onDisable() {
		MapReseter.resetMap();
		BedListener.replaceAllBeds();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("start")) {
			return CMD_start.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("login")) {
			return CMD_login.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("logout")) {
			return CMD_logout.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("adminlist")) {
			return CMD_adminlist.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("reloadconfig")) {
			return CMD_reloadconfig.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("replacebed")) {
			return CMD_replacebed.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("place")) {
			return CMD_place.exec(sender);
		} else if (cmd.getName().equalsIgnoreCase("setspawner")) {
			return CMD_setspawner.exec(sender, args);
		}
		return false;
	}
}
