package ch.nte.mc.bungee.bedwars.objects;

import org.bukkit.enchantments.Enchantment;

public class Enchantments {

	private Enchantment enchantment;
	private int level;
	
	public Enchantments(Enchantment enchantment, int level) {
		this.setEnchantment(enchantment);
		this.setLevel(level);
	}

	public Enchantment getEnchantment() {
		return enchantment;
	}

	public void setEnchantment(Enchantment enchantment) {
		this.enchantment = enchantment;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
