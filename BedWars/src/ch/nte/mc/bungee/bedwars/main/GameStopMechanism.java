package ch.nte.mc.bungee.bedwars.main;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import ch.nte.mc.bungee.bedwars.objects.Team;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.variables.Messages;
import ch.nte.mc.bungee.bedwars.world.MapReseter;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class GameStopMechanism {

	public static void checkIfIsGameEnd() {
		switch (ConfigCopy.getTeamAmount) {
		case 2:
			if(MainVariables.team1.getMemberAmount() < 1) {
				gameEnd(MainVariables.team2);
			} else if (MainVariables.team2.getMemberAmount() < 1) {
				gameEnd(MainVariables.team1);
			}
			break;
		case 3:
			if(MainVariables.team1.getMemberAmount() < 1 && MainVariables.team2.getMemberAmount() < 1) {
				gameEnd(MainVariables.team3);
			} else if (MainVariables.team1.getMemberAmount() < 1 && MainVariables.team3.getMemberAmount() < 1) {
				gameEnd(MainVariables.team2);
			} else if (MainVariables.team2.getMemberAmount() < 1 && MainVariables.team3.getMemberAmount() < 1) {
				gameEnd(MainVariables.team1);
			}
			break;
		case 4:
			if(MainVariables.team1.getMemberAmount() < 1 && MainVariables.team2.getMemberAmount() < 1 && MainVariables.team3.getMemberAmount() < 1) {
				gameEnd(MainVariables.team4);
			} else if (MainVariables.team1.getMemberAmount() < 1 && MainVariables.team2.getMemberAmount() < 1 && MainVariables.team4.getMemberAmount() < 1) {
				gameEnd(MainVariables.team3);
			} else if (MainVariables.team1.getMemberAmount() < 1 && MainVariables.team3.getMemberAmount() < 1 && MainVariables.team4.getMemberAmount() < 1) {
				gameEnd(MainVariables.team2);
			} else if (MainVariables.team2.getMemberAmount() < 1 && MainVariables.team3.getMemberAmount() < 1 && MainVariables.team4.getMemberAmount() < 1) {
				gameEnd(MainVariables.team1);
			}
			break;
		}
	}
	
	private static void gameEnd(Team winnerTeam) {
		MapReseter.resetMap();
		MainVariables.isGameRunning = false;
		for(Player p: Bukkit.getServer().getOnlinePlayers()) {
			p.teleport(ConfigCopy.lobby);
			((CraftPlayer)p).getHandle().playerConnection.sendPacket(getText(winnerTeam));
		}
		Bukkit.broadcastMessage(Messages.reloadInTenSec);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainVariables.plugin, new Runnable() {
			
			@Override
			public void run() {
				for(Player p: Bukkit.getOnlinePlayers()) {
					p.kickPlayer("");
				}
				Bukkit.getServer().reload();	
			}
		}, 10*20L);
	}
	
	private static PacketPlayOutTitle getText(Team team) {
		switch (team.getColor().name()) {
			case "red":
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Team red won the game\",\"bold\":true,\"color\":\"red\"}"), 0, 10, 100);
			case "blue":
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Team blue won the game\",\"bold\":true,\"color\":\"blue\"}"), 0, 10, 100);
			case "yellow":
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Team yellow won the game\",\"bold\":true,\"color\":\"yellow\"}"), 0, 10, 100);
			case "green":
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Team green won the game\",\"bold\":true,\"color\":\"green\"}"), 0, 10, 100);
			default:
				return null;
		}
	}
	
}
