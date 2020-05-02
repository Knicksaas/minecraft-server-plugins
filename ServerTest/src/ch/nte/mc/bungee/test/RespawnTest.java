package ch.nte.mc.bungee.test;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RespawnTest extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerDie(PlayerDeathEvent e) {
		e.getEntity().spigot().respawn();
		e.getDrops().clear();
	}
	
}
