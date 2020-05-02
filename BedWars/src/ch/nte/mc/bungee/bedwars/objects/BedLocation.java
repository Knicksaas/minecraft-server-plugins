package ch.nte.mc.bungee.bedwars.objects;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class BedLocation {

	private Location headLocation;
	private Location footLocation;
	private BlockFace face;
	
	public BedLocation(Location locHead,  Location locFoot, BlockFace face) {
		this.setFace(face);
		this.footLocation = locFoot;
		this.headLocation = locHead;
	}

	public Location getFootLocation() {
		return footLocation;
	}

	public void setFootLocation(Location footLocation) {
		this.footLocation = footLocation;
	}

	public Location getHeadLocation() {
		return headLocation;
	}

	public void setHeadLocation(Location headLocation) {
		this.headLocation = headLocation;
	}

	public BlockFace getFace() {
		return face;
	}

	public void setFace(BlockFace face) {
		this.face = face;
	}
}
