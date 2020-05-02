package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ch.nte.mc.bungee.mlgrush.commands.CMD_adminlist;
import ch.nte.mc.bungee.mlgrush.commands.CMD_login;
import ch.nte.mc.bungee.mlgrush.commands.CMD_logout;
import ch.nte.mc.bungee.mlgrush.events.DamageEvent;
import ch.nte.mc.bungee.mlgrush.events.DestroyBlockEvent;
import ch.nte.mc.bungee.mlgrush.events.DropEvent;
import ch.nte.mc.bungee.mlgrush.events.HugnerEvent;
import ch.nte.mc.bungee.mlgrush.events.InteractEntityEvent;
import ch.nte.mc.bungee.mlgrush.events.InvCloseEvent;
import ch.nte.mc.bungee.mlgrush.events.MoveEvent;
import ch.nte.mc.bungee.mlgrush.events.PlayerJoinEvent;
import ch.nte.mc.bungee.mlgrush.events.PlayerLeaveEvent;
import ch.nte.mc.bungee.mlgrush.events.SetBlockEvent;
import ch.nte.mc.bungee.mlgrush.events.WeatherEvent;

public class Main extends JavaPlugin{
	
	public FileConfiguration config = this.getConfig();

	@Override
	public void onEnable() {
		Variables.plugin = this;
		Variables.config = config;
		System.out.println("[MLGrush] enabled!");
		this.saveDefaultConfig();
		registerEvent();
		InventorySetter.itemInit();
		Worldborder.setWorldBorder();
		Worldborder.removeWorldBorder();
	}
	
	public void registerEvent() {
		this.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerLeaveEvent(), this);
		this.getServer().getPluginManager().registerEvents(new MoveEvent(), this);
		this.getServer().getPluginManager().registerEvents(new DestroyBlockEvent(), this);
		this.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		this.getServer().getPluginManager().registerEvents(new HugnerEvent(), this);
		this.getServer().getPluginManager().registerEvents(new DropEvent(), this);
		this.getServer().getPluginManager().registerEvents(new InteractEntityEvent(), this);
		this.getServer().getPluginManager().registerEvents(new InvCloseEvent(), this);
		this.getServer().getPluginManager().registerEvents(new SetBlockEvent(), this);
		this.getServer().getPluginManager().registerEvents(new WeatherEvent(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("login")) {
			new CMD_login(sender, cmd, label, args);
			return true;
		} else if (cmd.getName().equalsIgnoreCase("logout")) {
			new CMD_logout(sender, cmd, label, args);
			return true;
		} else if (cmd.getName().equalsIgnoreCase("adminlist")) {
			new CMD_adminlist(sender, cmd, label, args);
			return true;
		}
		return false;
	}
	
	@Override
	public void onDisable() {
		System.out.println("[MLGrush] disabled!");
	}
}
