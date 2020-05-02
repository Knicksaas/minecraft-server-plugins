package ch.nte.mc.bungee.test;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.Bed;
import org.bukkit.plugin.java.JavaPlugin;

public class BedPlaceTest extends JavaPlugin {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("place")) {
			Player p = (Player) sender;
			Location head = p.getLocation();
			Location foot = p.getLocation();
			foot.setZ(foot.getZ()+1);
			replaceBed(head, foot, BlockFace.NORTH);
			return true;
		}
		return false;
	}
	
	public static void replaceBed(Location bedHeadLocation, Location bedFeetLocation, BlockFace bedFacing) {
		if(bedFeetLocation != null) {
			Block b = bedFeetLocation.getBlock();
			b.setType(Material.BED_BLOCK);
			
			BlockState state = b.getState();
			Bed bed = new Bed(bedFacing);
			bed.setHeadOfBed(false);
			bed.setFacingDirection(bedFacing);
			state.setData(bed);
			state.update(true);
		}
		
		if(bedHeadLocation != null) {
			Block b = bedHeadLocation.getBlock();
			b.setType(Material.BED_BLOCK);
			
			BlockState state = b.getState();
			Bed bed = new Bed(bedFacing);
			bed.setHeadOfBed(true);
			bed.setFacingDirection(bedFacing);
			state.setData(bed);
			state.update(true);
		}
	}
}
