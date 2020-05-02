package ch.nte.mc.bungee.bedwars.world;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Bed;

import ch.nte.mc.bungee.bedwars.cosmetics.ScoreBoardManager;
import ch.nte.mc.bungee.bedwars.objects.BedLocation;
import ch.nte.mc.bungee.bedwars.objects.Team;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class BedListener implements Listener {
	
	private static List<BedLocation> bedlist = new ArrayList<>();

	@EventHandler
	public void onBedDistroy(BlockBreakEvent e) {
		if(e.getBlock().getType() == Material.BED_BLOCK) {
			double distance = 999999999;
			Team team = null;
			for(int i = 1; i<=ConfigCopy.getTeamAmount; i++) {
				double actualDistance = 99999999;
				switch (i) {
				case 1:
					actualDistance = e.getBlock().getLocation().distance(ConfigCopy.spawnTeam1);
					if(actualDistance < distance) {
						distance = actualDistance;
						team = MainVariables.team1;
					}
					break;
				case 2:
					actualDistance = e.getBlock().getLocation().distance(ConfigCopy.spawnTeam2);
					if(actualDistance < distance) {
						distance = actualDistance;
						team = MainVariables.team2;
					}
					break;
				case 3:
					actualDistance = e.getBlock().getLocation().distance(ConfigCopy.spawnTeam3);
					if(actualDistance < distance) {
						distance = actualDistance;
						team = MainVariables.team3;
					}
					break;
				case 4:
					actualDistance = e.getBlock().getLocation().distance(ConfigCopy.spawnTeam4);
					if(actualDistance < distance) {
						distance = actualDistance;
						team = MainVariables.team4;
					}
					break;
				}
			}
			if(MainVariables.playerTeamMap.get(e.getPlayer()).getColor() == team.getColor()) {
				e.getPlayer().sendMessage(Messages.ownBedMsg);
			} else {
				team.setBed(false);
				ScoreBoardManager.updateScoreBoard();
				String msg = Messages.prefix +  MainVariables.playerTeamMap.get(e.getPlayer()).getColor() + e.getPlayer().getName() + Messages.textColor +
						Messages.destroydBed + team.getColor() + team.getColor().name();
				Bukkit.broadcastMessage(msg);
				addBedToList(e.getBlock());
				e.getBlock().getDrops().clear();
				e.getBlock().setType(Material.AIR);
			}
		}
	}
	
	public static void replaceAllBeds() {
		for(int i = 0; i<bedlist.size(); i++) {
			replaceBed(bedlist.get(i).getHeadLocation(), bedlist.get(i).getFootLocation(), bedlist.get(i).getFace());
		}
	}
	
	private static void addBedToList(Block block) {
		Block bedHead;
	 	Block bedFeet;
	 	Bed bedBlock = (Bed) block.getState().getData();
	 	if (!bedBlock.isHeadOfBed()) {
	 		bedFeet = block;
	 		bedHead = getBedNeighborOf(bedBlock, block);
	 	} else {
	 		bedHead = block;
	 		bedFeet = getBedNeighborOf(bedBlock, block);
	 	}
	 	bedlist.add(new BedLocation(bedHead.getLocation(), bedFeet.getLocation(), bedBlock.getFacing()));
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
	

	private static Block getBedNeighborOf(Bed bed, Block block) {
		switch (bed.getFacing()) {
		case NORTH:
			if(bed.isHeadOfBed()) {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()+1);
			} else {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()-1);
			}
		case SOUTH:
			if(bed.isHeadOfBed()) {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()-1);
			} else {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX(), block.getY(), block.getZ()+1);
			}
		case EAST:
			if(bed.isHeadOfBed()) {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX()-1, block.getY(), block.getZ());
			} else {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX()+1, block.getY(), block.getZ());
			}
		case WEST:
			if(bed.isHeadOfBed()) {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX()+1, block.getY(), block.getZ());
			} else {
				return Bukkit.getServer().getWorld("world").getBlockAt(block.getX()-1, block.getY(), block.getZ());
			}
		default:
			break;
		}
		return null;
	}
	
}
