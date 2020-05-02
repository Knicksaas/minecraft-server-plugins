package ch.nte.mc.bungee.bedwars.commands;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.Messages;
import ch.nte.mc.bungee.bedwars.world.BedListener;

public class CMD_place {

	public static boolean exec(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("place")) {
				Location head = p.getLocation();
				Location foot = p.getLocation();
				foot.setZ(foot.getZ()+1);
				BedListener.replaceBed(head, foot, BlockFace.NORTH);
				return true;
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
