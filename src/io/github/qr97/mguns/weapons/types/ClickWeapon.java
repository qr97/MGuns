package io.github.qr97.mguns.weapons.types;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface ClickWeapon extends Weapon {
	
	public ItemStack getItemStack();
	
	public String getName();
	
	public void onMeleeAttack(PlayerInteractEvent event);
	
}
