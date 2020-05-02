package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.ChatColor;

public class PrefixManager {
	
	public static void updatePrefix() {
		
		if(Variables.pRed != null) {
			Variables.pRed.setPlayerListName(ChatColor.RED + Variables.pRed.getName());
		}  
		if (Variables.pBlue != null) {
			Variables.pBlue.setPlayerListName(ChatColor.BLUE + Variables.pBlue.getName());
		}
		
	}

}
