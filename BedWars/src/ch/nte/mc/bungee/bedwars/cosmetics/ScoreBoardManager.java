package ch.nte.mc.bungee.bedwars.cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;

public class ScoreBoardManager implements Listener {
	
	private static Scoreboard board;
	private static Objective obj;
	private static Score scoreTeam1;
	private static Score scoreTeam2;
	private static Score scoreTeam3;
	private static Score scoreTeam4;
	
	public static void initScoreBoard() {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		obj = board.registerNewObjective("asdf", "asdf");
		obj.setDisplayName(ChatColor.BOLD + "" + ChatColor.GOLD + "NTE-BedWars");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	}

	public static void updateScoreBoard() {
		initScoreBoard();
		if(MainVariables.isGameRunning) {
			switch (ConfigCopy.getTeamAmount) {
			case 2:
				scoreTeam1 = obj.getScore(MainVariables.team1.getPrefix() + MainVariables.team1.getColor() + MainVariables.team1.getColor().name());
				scoreTeam2 = obj.getScore(MainVariables.team2.getPrefix() + MainVariables.team2.getColor() + MainVariables.team2.getColor().name());
				scoreTeam1.setScore(MainVariables.team1.getMemberAmount());
				scoreTeam2.setScore(MainVariables.team2.getMemberAmount());
				break;
			case 3:
				scoreTeam1 = obj.getScore(MainVariables.team1.getPrefix() + MainVariables.team1.getColor() + MainVariables.team1.getColor().name());
				scoreTeam2 = obj.getScore(MainVariables.team2.getPrefix() + MainVariables.team2.getColor() + MainVariables.team2.getColor().name());
				scoreTeam3 = obj.getScore(MainVariables.team3.getPrefix() + MainVariables.team3.getColor() + MainVariables.team3.getColor().name());
				scoreTeam1.setScore(MainVariables.team1.getMemberAmount());
				scoreTeam2.setScore(MainVariables.team2.getMemberAmount());
				scoreTeam3.setScore(MainVariables.team3.getMemberAmount());
				break;
			case 4:
				scoreTeam1 = obj.getScore(MainVariables.team1.getPrefix() + MainVariables.team1.getColor() + MainVariables.team1.getColor().name());
				scoreTeam2 = obj.getScore(MainVariables.team2.getPrefix() + MainVariables.team2.getColor() + MainVariables.team2.getColor().name());
				scoreTeam3 = obj.getScore(MainVariables.team3.getPrefix() + MainVariables.team3.getColor() + MainVariables.team3.getColor().name());
				scoreTeam4 = obj.getScore(MainVariables.team4.getPrefix() + MainVariables.team4.getColor() + MainVariables.team4.getColor().name());
				scoreTeam1.setScore(MainVariables.team1.getMemberAmount());
				scoreTeam2.setScore(MainVariables.team2.getMemberAmount());
				scoreTeam3.setScore(MainVariables.team3.getMemberAmount());
				scoreTeam4.setScore(MainVariables.team4.getMemberAmount());
				break;
			}
		} else {
			
		}
		for(Player p: Bukkit.getOnlinePlayers()) {
			p.setScoreboard(board);
		}
	} 
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		updateScoreBoard();
	}
}
