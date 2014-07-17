package io.github.qr97.mguns.listener;

import io.github.qr97.mguns.MGuns;
import io.github.qr97.mguns.weapons.types.BowWeapon;
import io.github.qr97.mguns.weapons.types.Weapon;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class EntityShootBowListener implements Listener {

	@EventHandler
	public void onShoot(EntityShootBowEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Weapon weapon = MGuns.getInstance().getWeapon(
					player.getItemInHand());
			if(weapon != null && weapon instanceof BowWeapon) {
				BowWeapon bWeapon = (BowWeapon) weapon;
				bWeapon.onShoot(event);
			}
		}
	}

}
