package ch.nte.mc.bungee.mlgrush.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.mlgrush.events.PlayerJoinEvent;
import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class CMD_logout {

	public CMD_logout(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mlgrush.logout")) {
				if(Variables.adminList.contains(p.getName())) {
					p.sendMessage(ChatColor.GREEN + Messages.logoutMsg);
					Variables.adminList.remove(p.getName());
					PlayerJoinEvent.addPlayer(p);
				} else {
					p.sendMessage(ChatColor.RED + Messages.alreadyLoggedOutMsg);
				}
			} else {
				p.sendMessage(ChatColor.RED + Messages.noPermissionsMsg);
			}
		} else {
			System.out.println(Messages.playerOnlyCommandMsg);
		}
	}

}
