package ch.nte.mc.bungee.mlgrush.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener{

	@EventHandler
	public void onChangeWeather(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
}
