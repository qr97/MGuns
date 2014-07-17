package io.github.qr97.mguns.weapons.types;

import org.bukkit.event.player.PlayerInteractEvent;

public interface ClickWeapon extends Weapon {
	
	public void onClick(PlayerInteractEvent event);
	
}
