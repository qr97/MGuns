package io.github.qr97.mguns.listeners;

import io.github.qr97.mguns.MGuns;
import io.github.qr97.mguns.weapons.types.ClickWeapon;
import io.github.qr97.mguns.weapons.types.Weapon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
	
	private MGuns plugin;
	
	public PlayerInteractListener(MGuns plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Weapon weapon = plugin.getWeapon(event.getPlayer().getItemInHand());
		
		if(weapon != null && weapon instanceof ClickWeapon) {
			ClickWeapon cWeapon = (ClickWeapon)weapon;
			if(plugin.canFire(event.getPlayer(), cWeapon)) {
				cWeapon.onClick(event);
			}
		}
	}
	
}
