package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.main.GameStartMechanism;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class CMD_start {

	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("start")) {
				GameStartMechanism.startCountdown();
				return true;
			} else {
				p.sendMessage(Messages.noPermission);
				return true;
			}
		} else {
			GameStartMechanism.startCountdown();
			return true;
		}
	}
}
