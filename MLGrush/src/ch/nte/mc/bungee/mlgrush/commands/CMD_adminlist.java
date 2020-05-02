package ch.nte.mc.bungee.mlgrush.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class CMD_adminlist {
	
	public CMD_adminlist(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mlgrush.adminlist")) {
				p.sendMessage(ChatColor.AQUA + Messages.adminListMsg + Variables.adminList.toString());
			} else {
				p.sendMessage(ChatColor.RED + Messages.noPermissionsMsg);
			}
		} else {
			System.out.println(Messages.adminListMsg + Variables.adminList.toString());
		}
	}

}
