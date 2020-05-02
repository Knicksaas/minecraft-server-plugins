package ch.nte.mc.bungee.mlgrush.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class Run {
	
	private Main plugin;
	private int task;
	private PacketPlayOutTitle nr5;
	private PacketPlayOutTitle nr4;
	private PacketPlayOutTitle nr3;
	private PacketPlayOutTitle nr2;
	private PacketPlayOutTitle nr1;
	private int counter;
	
	public Run(Main plugin) {
		this.plugin = plugin;
		Variables.isRunning = true;
		initLocation();
		System.out.println("Logs init!");
		titleGenerator();
		startScheduler();
	}
	
	private void initLocation() {
		System.out.println("initLocation exec");
		Variables.spawnRed = new Location(Bukkit.getServer().getWorld("world"), Variables.config.getInt("Spawn.pointRed.x"),
				Variables.config.getDouble("Spawn.pointRed.y"), Variables.config.getDouble("Spawn.pointRed.z"), 180, 0);
		System.out.println(Variables.spawnRed.getBlockX() + " " + Variables.spawnRed.getBlockY() + " " + Variables.spawnRed.getBlockZ());
		Variables.spawnBlue = new Location(Bukkit.getServer().getWorld("world"), Variables.config.getDouble("Spawn.pointBlue.x"),
				Variables.config.getDouble("Spawn.pointBlue.y"), Variables.config.getDouble("Spawn.pointBlue.z"));
		System.out.println(Variables.spawnBlue.getBlockX() + " " + Variables.spawnBlue.getBlockY() + " " + Variables.spawnBlue.getBlockZ());
	}
	
	private void titleGenerator() {
		nr5 = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"5\",\"bold\":true,\"color\":\"dark_purple\"}"), 0, 10, 10);
		nr4 = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"4\",\"bold\":true,\"color\":\"dark_blue\"}"), 0, 10, 10);
		nr3 = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"3\",\"bold\":true,\"color\":\"blue\"}"), 0, 10, 10);
		nr2 = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"2\",\"bold\":true,\"color\":\"green\"}"), 0, 10, 10);
		nr1 = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"1\",\"bold\":true,\"color\":\"yellow\"}"), 0, 10, 10);
	}
	
	private void startScheduler() {
		counter = 6;
		if(!Variables.isRunning) {
			return;
		}
		task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				if(Variables.go) {
					System.out.println("has finaly started, return, abort");
					Bukkit.getScheduler().cancelTask(task);
					return;
				}
				if(!Variables.isRunning) {
					System.out.println("isn't running, return, abort");
					Bukkit.getScheduler().cancelTask(task);
					return;
				}
				if(counter > 0) {
					counter = counter - 1;
					for(Player p : Bukkit.getOnlinePlayers()) {
						switch(counter){
							case 5:
								System.out.println(counter);
								((CraftPlayer)p).getHandle().playerConnection.sendPacket(nr5);
								p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
								break;
							case 4:
								System.out.println(counter);
								((CraftPlayer)p).getHandle().playerConnection.sendPacket(nr4);
								p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
								break;
							case 3:
								System.out.println(counter);
								((CraftPlayer)p).getHandle().playerConnection.sendPacket(nr3);
								p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
								break;
							case 2:
								System.out.println(counter);
								((CraftPlayer)p).getHandle().playerConnection.sendPacket(nr2);
								p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
								break;
							case 1:
								System.out.println(counter);
								((CraftPlayer)p).getHandle().playerConnection.sendPacket(nr1);
								p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
								break;
						}
					}
				} else if(counter == 0) {
					start();
					Variables.go = true;
				} else {
					return;
				}
			}
		}, 0L, 20L);
	}
	
	private void start() {
		System.out.println("Game Started successfully");
		Worldborder.setWorldBorder();
		Variables.pRed.teleport(Variables.spawnRed);
		Variables.pBlue.teleport(Variables.spawnBlue);
		InventorySetter invSetter = new InventorySetter();
		invSetter.getInventroyConfig(Variables.pBlue);
		invSetter.getInventroyConfig(Variables.pRed);
		ScoreBoardManager.updateScoreboardForAll();
	}

}
