package io.github.qr97.mguns.weapons;

import io.github.qr97.mguns.util.ItemUtils;
import io.github.qr97.mguns.weapons.types.BowWeapon;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class AutoBow implements BowWeapon {
	
	private final String name = "AutoBow";
	private ItemStack item;
	
	public AutoBow() {
		item = ItemUtils.createItem(Material.BOW, ChatColor.BLUE + name,
				Arrays.asList("Bow with auto aim"));
	}
	
	@Override
	public ItemStack getItemStack() {
		return item;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void onShoot(EntityShootBowEvent event) {
		Player player = (Player) event.getEntity();
		Arrow arrow = (Arrow)event.getProjectile();
		
		for(Entity entity : player.getNearbyEntities(15, 15, 15)) {
			if(entity instanceof LivingEntity && entity != player) {
				Vector vector = entity.getLocation().toVector().subtract(arrow.getLocation().toVector());
				arrow.setVelocity(vector);
				break;
			}
		}
	}

}
