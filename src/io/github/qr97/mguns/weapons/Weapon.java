package io.github.qr97.mguns.weapons;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface Weapon extends Listener {
	
	public ItemStack getItemStack();
	
	public String getName();
	
	public void onMeleeAttack(PlayerInteractEvent event);
	
}
