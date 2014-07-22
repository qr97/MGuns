package io.github.qr97.mguns;

import io.github.qr97.mguns.commands.GetWeaponCommand;
import io.github.qr97.mguns.listeners.EntityShootBowListener;
import io.github.qr97.mguns.listeners.PlayerInteractListener;
import io.github.qr97.mguns.util.StackComparator;
import io.github.qr97.mguns.weapons.AutoBow;
import io.github.qr97.mguns.weapons.TNTCannon;
import io.github.qr97.mguns.weapons.types.Weapon;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MGuns extends JavaPlugin {
	
	private Map<String, Weapon> weaponsList = new HashMap<>();
	
	public Weapon getWeapon(String name) {
		return weaponsList.get(name);
	}
	
	@Override
	public void onEnable() {
		getCommand("getWeapon").setExecutor(new GetWeaponCommand(this));
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new EntityShootBowListener(this), this);
		registerWeapons(new TNTCannon(), new AutoBow());
	}
	
	public void registerWeapons(Weapon... weapons) {
		for(Weapon weapon : weapons)
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
