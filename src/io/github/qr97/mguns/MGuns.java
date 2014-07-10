package io.github.qr97.mguns;

import io.github.qr97.mguns.commands.GetWeaponCommand;
import io.github.qr97.mguns.listener.PlayerInteractListener;
import io.github.qr97.mguns.util.StackComparator;
import io.github.qr97.mguns.weapons.TNTCannon;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MGuns extends JavaPlugin {
	
	private static MGuns instance;
	private Map<String, Weapon> weaponsList = new HashMap<>();
	
	public static MGuns getInstance() {
		return instance;
	}
	
	public Weapon getWeapon(String name) {
		return weaponsList.get(name);
	}
	
	@Override
	public void onEnable() {
		instance = this;
		getCommand("getWeapon").setExecutor(new GetWeaponCommand());
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
		registerWeapon(new TNTCannon());
	}
	
	public void registerWeapon(Weapon weapon) {
		weaponsList.put(weapon.getName().toLowerCase(), weapon);
	}
	
	public Weapon getWeapon(ItemStack stack) {
		for(Weapon weapon : weaponsList.values()) {
			if(StackComparator.equals(weapon.getItemStack(), stack)) {
				return weapon;
			}
		}
		
		return null;
	}
	
}
