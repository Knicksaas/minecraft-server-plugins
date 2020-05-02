package ch.nte.mc.bungee.bedwars.teams;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.nte.mc.bungee.bedwars.cosmetics.TablistUpdater;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.ItemNames;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;

public class TeamChooser implements Listener {
	
	private static void invPreparer(Player p) {
		ItemStack team1 = new ItemStack(Material.WOOL, 1, (byte)14);
		ItemStack team2 = new ItemStack(Material.WOOL, 1, (byte)11);
		ItemStack team3 = new ItemStack(Material.WOOL, 1, (byte)4);
		ItemStack team4 = new ItemStack(Material.WOOL, 1, (byte)5);
		ItemMeta metaTeam1 = team1.getItemMeta();
		ItemMeta metaTeam2 = team2.getItemMeta();
		ItemMeta metaTeam3 = team3.getItemMeta();
		ItemMeta metaTeam4 = team4.getItemMeta();
		metaTeam1.setDisplayName(ItemNames.chooseRedTeam);
		metaTeam2.setDisplayName(ItemNames.chooseBlueTeam);
		metaTeam3.setDisplayName(ItemNames.chooseYellowTeam);
		metaTeam4.setDisplayName(ItemNames.chooseGreenTeam);
		team1.setItemMeta(metaTeam1);
		team2.setItemMeta(metaTeam2);
		team3.setItemMeta(metaTeam3);
		team4.setItemMeta(metaTeam4);
		switch (ConfigCopy.getTeamAmount) {
		case 2:
			p.getInventory().setItem(2, team1);
			p.getInventory().setItem(6, team2);
			break;
		case 3:
			p.getInventory().setItem(2, team1);
			p.getInventory().setItem(4, team2);
			p.getInventory().setItem(6, team3);
			break;
		case 4:
			p.getInventory().setItem(1, team1);
			p.getInventory().setItem(3, team2);
			p.getInventory().setItem(5, team3);
			p.getInventory().setItem(7, team4);
			break;
		}
		
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().setGameMode(GameMode.SURVIVAL);
		invPreparer(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent e) {
		removeFromTeam(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerWoolClick(PlayerInteractEvent e) {
		if(MainVariables.isGameRunning) {
			return;
		}
		e.setCancelled(true);
		switch (e.getItem().getItemMeta().getDisplayName()) {
			case ItemNames.chooseRedTeam:
				if(MainVariables.playerTeamMap.get(e.getPlayer()) != null) {
					if(MainVariables.playerTeamMap.get(e.getPlayer()).getColor() == ChatColor.RED) {
						e.getPlayer().sendMessage(Messages.alreadyInTeam);
						break;
					}
					removeFromTeam(e.getPlayer());
				}
				addToTeam(e.getPlayer(), 1);
				break;
			case ItemNames.chooseBlueTeam:
				if(MainVariables.playerTeamMap.get(e.getPlayer()) != null) {
					if(MainVariables.playerTeamMap.get(e.getPlayer()).getColor() == ChatColor.BLUE) {
						e.getPlayer().sendMessage(Messages.alreadyInTeam);
						break;
					}
					removeFromTeam(e.getPlayer());
				}
				addToTeam(e.getPlayer(), 2);
				break;
			case ItemNames.chooseYellowTeam:
				if(MainVariables.playerTeamMap.get(e.getPlayer()) != null) {
					if(MainVariables.playerTeamMap.get(e.getPlayer()).getColor() == ChatColor.YELLOW) {
						e.getPlayer().sendMessage(Messages.alreadyInTeam);
						break;
					}
					removeFromTeam(e.getPlayer());
				}
				addToTeam(e.getPlayer(), 3);
				break;
			case ItemNames.chooseGreenTeam:
				if(MainVariables.playerTeamMap.get(e.getPlayer()) != null) {
					if(MainVariables.playerTeamMap.get(e.getPlayer()).getColor() == ChatColor.GREEN) {
						e.getPlayer().sendMessage(Messages.alreadyInTeam);
						break;
					}
					removeFromTeam(e.getPlayer());
				}
				addToTeam(e.getPlayer(), 4);
				break;
		}
		
	}
	
	public static void removeFromTeam(Player p) {
		try {
			MainVariables.playerTeamMap.get(p).removeMember(p);
			MainVariables.playerTeamMap.remove(p);
		} catch (Exception e) {}
		
	}
	
	public static void addToTeam(Player p, int ID) {
		if(MainVariables.playerTeamMap.containsKey(p)) {
			return;
		}
		switch (ID) {
			case 1:
				if(MainVariables.team1.getMemberAmount()<(ConfigCopy.getTeamSize)) {
					MainVariables.team1.addMember(p);
					MainVariables.playerTeamMap.put(p, MainVariables.team1);
					p.sendMessage(ChatColor.DARK_GREEN + Messages.joninedTeam + MainVariables.team1.getColor() + MainVariables.team1.getColor().name());
				} else {
					p.sendMessage(ChatColor.RED + Messages.teamAlreadyFull);
				}
				break;
			case 2:
				if(MainVariables.team2.getMemberAmount()<(ConfigCopy.getTeamSize)) {
					MainVariables.team2.addMember(p);
					MainVariables.playerTeamMap.put(p, MainVariables.team2);
					p.sendMessage(ChatColor.DARK_GREEN + Messages.joninedTeam + MainVariables.team2.getColor() + MainVariables.team2.getColor().name());
				} else {
					p.sendMessage(ChatColor.RED + Messages.teamAlreadyFull);
				}
				break;
			case 3:
				if(MainVariables.team3.getMemberAmount()<(ConfigCopy.getTeamSize)) {
					MainVariables.team3.addMember(p);
					MainVariables.playerTeamMap.put(p, MainVariables.team3);
					p.sendMessage(ChatColor.DARK_GREEN + Messages.joninedTeam + MainVariables.team3.getColor() + MainVariables.team3.getColor().name());
				} else {
					p.sendMessage(ChatColor.RED + Messages.teamAlreadyFull);
				}
				break;
			case 4:
				if(MainVariables.team4.getMemberAmount()<(ConfigCopy.getTeamSize)) {
					MainVariables.team4.addMember(p);
					MainVariables.playerTeamMap.put(p, MainVariables.team4);
					p.sendMessage(ChatColor.DARK_GREEN + Messages.joninedTeam + MainVariables.team4.getColor() + MainVariables.team4.getColor().name());
				} else {
					p.sendMessage(ChatColor.RED + Messages.teamAlreadyFull);
				}
				break;
		}
		TablistUpdater.updateTablist();
	}
}
