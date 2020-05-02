package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoardManager {
	
	public static void updateScoreboardForAll() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			updateScoreBoard(p);
		}
	}
	
	public static void updateScoreBoard(Player p) {
		Scoreboard borad = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = borad.registerNewObjective("Board for", "point table");
		obj.setDisplayName(ChatColor.BOLD + "NTE-MLGrush");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score pBlue = obj.getScore(ChatColor.BLUE + Variables.pBlue.getName());
		Score pRed = obj.getScore(ChatColor.RED + Variables.pRed.getName());
		
		pBlue.setScore(Variables.pointsBlue);
		pRed.setScore(Variables.pointsRed);
		
		p.setScoreboard(borad);
	}
}
