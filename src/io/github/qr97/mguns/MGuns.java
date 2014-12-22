package io.github.qr97.mguns;

import io.github.qr97.mguns.commands.CommandManager;
import io.github.qr97.mguns.commands.GetCommand;
import io.github.qr97.mguns.commands.ListCommand;
import io.github.qr97.mguns.listeners.EntityShootBowListener;
import io.github.qr97.mguns.listeners.PlayerInteractListener;
import io.github.qr97.mguns.util.ItemUtils;
import io.github.qr97.mguns.weapons.AutoBow;
import io.github.qr97.mguns.weapons.TNTCannon;
import io.github.qr97.mguns.weapons.TorHammer;
import io.github.qr97.mguns.weapons.types.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MGuns extends JavaPlugin {
	
	private Map<String, Weapon> weaponsList = new HashMap<>();
	private CommandManager cmdManager = new CommandManager();
	
	@Override
	public void onEnable() {
		getCommand("mguns").setExecutor(cmdManager);
		
		registerCommands();
		
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new EntityShootBowListener(this), this);
		
		registerWeapons(new TNTCannon(), new AutoBow(), new TorHammer());
	}
	
	public Weapon getWeapon(String name) {
		Weapon weapon = weaponsList.get(name);
		
		if(weapon != null) {
			return weapon;
		}
		
		String lowerName = name.toLowerCase();
		
		for(Entry<String, Weapon> entry : weaponsList.entrySet()) {
			String weaponName = entry.getKey().toLowerCase();
			if(weaponName.startsWith(lowerName)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	public Weapon getWeapon(ItemStack stack) {
		for(Weapon weapon : weaponsList.values()) {
			if(ItemUtils.equals(weapon.getItemStack(), stack)) {
				return weapon;
			}
		}
		
		return null;
	}
	
	public Set<String> getWeaponsNameSet() {
		return weaponsList.keySet();
	}
	
	public void registerWeapons(Weapon... weapons) {
		for(Weapon weapon : weapons)
			weaponsList.put(weapon.getName(), weapon);
	}
	
	public boolean canFire(Player player, Weapon weapon) {
		return player.hasPermission("mguns.use." + weapon.getName().toLowerCase());
	}
	
	private void registerCommands() {
		cmdManager.registerCommand(new GetCommand(this));
		cmdManager.registerCommand(new ListCommand(this));
	}
	
	
}
