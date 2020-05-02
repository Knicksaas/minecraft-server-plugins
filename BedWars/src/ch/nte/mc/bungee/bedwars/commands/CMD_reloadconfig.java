package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class CMD_reloadconfig {

	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("reloadconfig")) {
				ConfigCopy.copyConfig(MainVariables.config);
				p.sendMessage(ChatColor.AQUA + Messages.configReloaded);
				return true;
			} else {
				p.sendMessage(Messages.noPermission);
				return true;
			}
		} else {
			ConfigCopy.copyConfig(MainVariables.config);
			System.out.println(Messages.configReloaded);
			return true;
		}
	}
}
