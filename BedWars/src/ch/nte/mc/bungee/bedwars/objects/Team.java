package ch.nte.mc.bungee.bedwars.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;

public class Team {

	private boolean bed = true;
	private int ID;
	private int size;
	private ChatColor color;
	private Location spawn;
	private List<Player> members = new ArrayList<>();
	
	public Team(int ID, int size) {
		if(ID>0 && ID<5) {
			this.ID = ID;
		}
		this.setSize(size);
		switch (ID) {
		case 1:
			color = ChatColor.RED;
			spawn = ConfigCopy.spawnTeam1;
			break;
		case 2:
			color = ChatColor.BLUE;
			spawn = ConfigCopy.spawnTeam2;
			break;
		case 3:
			color = ChatColor.YELLOW;
			spawn = ConfigCopy.spawnTeam3;
			break;
		case 4:
			color = ChatColor.GREEN;
			spawn = ConfigCopy.spawnTeam4;
			break;
		}
		
	}
	
	public void addMember(Player p) {
		members.add(p);
	}
	
	public void removeMember(Player p) {
		members.remove(p);
	}
	
	public List<Player> getMembers() {
		return members;
	}
	
	public int getMemberAmount() {
		return members.size();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ChatColor getColor() {
		return color;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		if(ID>0 && ID<5) {
			this.ID = ID;
		}
	}
	
	public Location getSpawn() {
		return spawn;
	}

	public boolean hasBed() {
		return bed;
	}

	public void setBed(boolean bed) {
		this.bed = bed;
	}
	
	public String getPrefix() {
		if(bed) {
			return ChatColor.GREEN + "✔ ";
		} else {
			return ChatColor.RED + "✘ ";
		}
	}
}
