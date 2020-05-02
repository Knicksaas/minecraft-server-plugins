package ch.nte.mc.bungee.tablist.main;

import java.lang.reflect.Field;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class Main extends JavaPlugin implements Listener{
	
	public FileConfiguration config = this.getConfig();

	@Override
	public void onEnable() {
		System.out.println("Enabled!");
		registerEvents();
		this.saveDefaultConfig();
	}
	
	private void registerEvents() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	private void sendTablist(Player p, String header, String footer) {
		if(header == null) {
			header = "";
		}
		if(footer == null) {
			footer = "";
		}
		header = header.replace("&", "§");
		footer = footer.replace("&", "§");
		
		header = header.replace("%PLAYER%", p.getName());
		footer = footer.replace("%PLAYER%", p.getName());
		
		PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
		
		IChatBaseComponent tabheader = ChatSerializer.a("{\"text\": \"" + header + "\"}");
		IChatBaseComponent tabfooter = ChatSerializer.a("{\"text\": \"" + footer + "\"}");
		
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabheader);
		
		try {
			Field f = packet.getClass().getDeclaredField("b");
			f.setAccessible(true);
			f.set(packet, tabfooter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.sendPacket(packet);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		sendTablist(e.getPlayer(), config.getString("Header"), config.getString("Footer"));
	}
}
