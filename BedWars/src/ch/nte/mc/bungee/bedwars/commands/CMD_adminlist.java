package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class CMD_adminlist {
	
	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("adminlist")) {
				p.sendMessage(ChatColor.GRAY + "These admins are logged in to the list: " + MainVariables.adminList.toString());
				return true;
			} else {
				p.sendMessage(Messages.noPermission);
				return true;
			}
		} else {
			System.out.println("These admins are logged in to the list: " + MainVariables.adminList.toString());
			return true;
		}
	}

}
