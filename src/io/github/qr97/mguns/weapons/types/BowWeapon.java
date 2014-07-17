package io.github.qr97.mguns.weapons.types;

import org.bukkit.event.entity.EntityShootBowEvent;

public interface BowWeapon extends Weapon {
	
	public void onShoot(EntityShootBowEvent event);
	
}
