package ch.nte.mc.bungee.mlgrush.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.mlgrush.events.PlayerLeaveEvent;
import ch.nte.mc.bungee.mlgrush.main.Messages;
import ch.nte.mc.bungee.mlgrush.main.Variables;

public class CMD_login {

	public CMD_login(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mlgrush.login")) {
				if(Variables.adminList.contains(p.getName())) {
					p.sendMessage(ChatColor.RED + Messages.alreadyLoggedInMsg);
				} else {
					Variables.adminList.add(p.getName());
					PlayerLeaveEvent.removePlayer(p);
					p.sendMessage(ChatColor.GREEN + Messages.loginMsg);
				}
			} else {
				p.sendMessage(ChatColor.RED + Messages.noPermissionsMsg);
			}
		} else {
			System.out.println(Messages.playerOnlyCommandMsg);
		}
	}

}
