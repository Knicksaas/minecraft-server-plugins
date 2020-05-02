package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ch.nte.mc.bungee.mlgrush.main.InventorySetter;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class MoveEvent implements Listener{

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(!Variables.go) {
			return;
		}
		InventorySetter invSetter = new InventorySetter();
		if(e.getPlayer().getLocation().getBlockY() <= Variables.config.getInt("General.tpHeight")) {
			if(Variables.pRed.getName() == e.getPlayer().getName()) {
				e.getPlayer().teleport(Variables.spawnRed);
				e.getPlayer().getInventory().clear();
				invSetter.getInventroyConfig(e.getPlayer());
			} else if (Variables.pBlue.getName() == e.getPlayer().getName()) {
				e.getPlayer().teleport(Variables.spawnBlue);
				e.getPlayer().getInventory().clear();
				invSetter.getInventroyConfig(e.getPlayer());
			}
		}
	}
}
