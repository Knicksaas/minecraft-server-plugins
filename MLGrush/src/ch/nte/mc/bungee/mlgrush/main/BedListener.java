package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.entity.Player;

public class BedListener {

	public void givePointTo(Player p) {
		Variables.pBlue.teleport(Variables.spawnBlue);
		Variables.pRed.teleport(Variables.spawnRed);
		MapResetter.resetMap();
		
		if(p.getName() == Variables.pRed.getName()) {
			Variables.pointsRed = Variables.pointsRed + 1;
			ScoreBoardManager.updateScoreboardForAll();
		} else {
			Variables.pointsBlue = Variables.pointsBlue + 1;
			ScoreBoardManager.updateScoreboardForAll();
		}
	}
}
