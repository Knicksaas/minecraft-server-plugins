package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class CMD_login {

	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("login")) {
				if(!MainVariables.adminList.contains(p.getName())) {
					MainVariables.adminList.add(p.getName());
					p.sendMessage(Messages.successfullLoggedIn);
					return true;
				} else {
					p.sendMessage(Messages.alreadyLoggedIn);
					return true;
				}
			} else {
				p.sendMessage(Messages.noPermission);
				return true;
			}
		} else {
			System.out.println(Messages.playerOnlyCommand);
			return true;
		}
	}
}
