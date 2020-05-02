package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.Messages;
import ch.nte.mc.bungee.bedwars.world.BedListener;

public class CMD_replacebed {

	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("replacebed")) {
				BedListener.replaceAllBeds();
				return true;
			} else {
				p.sendMessage(Messages.noPermission);
				return true;
			}
 		} else {
 			BedListener.replaceAllBeds();
 			return true;
		}
	}
}
