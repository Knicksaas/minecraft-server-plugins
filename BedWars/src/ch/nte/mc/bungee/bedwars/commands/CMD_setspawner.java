package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.Messages;
import ch.nte.mc.bungee.bedwars.world.Spawner;

public class CMD_setspawner {

	public static boolean exec(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("setspawner")) {
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("gold")) {
						Spawner.setSpawn("gold", p.getLocation());
					} else if (args[0].equalsIgnoreCase("iron")) {
						Spawner.setSpawn("iron", p.getLocation());
					} else if (args[0].equalsIgnoreCase("bronze")) {
						Spawner.setSpawn("bronze", p.getLocation());
					}
					return true;
				} else {
					return false;
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
