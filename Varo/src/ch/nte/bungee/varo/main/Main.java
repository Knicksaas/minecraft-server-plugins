package ch.nte.bungee.varo.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ch.nte.bungee.varo.variables.ConfigCopy;
import ch.nte.bungee.varo.variables.MainVariables;

public class Main extends JavaPlugin {
	
	public FileConfiguration config = this.getConfig();

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		MainVariables.plugin = this;
		ConfigCopy.copyConfig(config);
	}
}
