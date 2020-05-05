package ch.nte.mc.bungee.bedwars.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
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
	
	private static int counter;

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
			p.setGameMode(GameMode.SURVIVAL);
			((CraftPlayer)p).getHandle().playerConnection.sendPacket(getText(winnerTeam));
			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 20, 1);
		}
		counter = 10;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainVariables.plugin, new Runnable() {
			
			@Override
			public void run() {
				switch (counter) {
				case 10:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 5:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 4:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 3:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 2:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 1:
					Bukkit.broadcastMessage(Messages.reloadCounter.replace("%TIME%", String.valueOf(counter)));
					break;
				case 0:
					for(Player p: Bukkit.getOnlinePlayers()) {
						p.kickPlayer(Messages.reloadMsg);
					}
					Bukkit.getServer().reload();
					break;
				}
				counter--;
			}
		}, 0L, 20L);
	}
	
	private static PacketPlayOutTitle getText(Team team) {
		switch (team.getColor().name()) {
			case "red":
				System.out.println("red");
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\" Team red won the game\",\"bold\":true,\"color\":\"red\"}"), 0, 10, 10);
			case "blue":
				System.out.println("blue");
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\" Team blue won the game\",\"bold\":true,\"color\":\"blue\"}"), 0, 10, 10);
			case "yellow":
				System.out.println("yellow");
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\" Team yellow won the game\",\"bold\":true,\"color\":\"yellow\"}"), 0, 10, 10);
			case "green":
				System.out.println("green");
				return new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\" Team green won the game\",\"bold\":true,\"color\":\"green\"}"), 0, 10, 10);
			default:
				System.out.println("BAD!!!");
				return null;
		}
	}
	
}
