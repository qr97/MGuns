package io.github.qr97.mguns.listeners;

import io.github.qr97.mguns.MGuns;
import io.github.qr97.mguns.weapons.types.ClickWeapon;
import io.github.qr97.mguns.weapons.types.Weapon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Weapon weapon = MGuns.getInstance().getWeapon(event.getPlayer().getItemInHand());
		
		if(weapon != null && weapon instanceof ClickWeapon) {
			ClickWeapon cWeapon = (ClickWeapon)weapon;
			cWeapon.onMeleeAttack(event);
		}
	}
	
}
