package io.github.qr97.mguns.weapons;

import io.github.qr97.mguns.util.ItemUtils;
import io.github.qr97.mguns.weapons.types.ClickWeapon;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TNTCannon implements ClickWeapon {

	private final String name = "TNTCannon";
	private ItemStack item;

	public TNTCannon() {
		item = ItemUtils.createItem(Material.DISPENSER, ChatColor.DARK_GREEN + "Lançador de TNT",
				Arrays.asList("Lança TNTs"));

	}

	public String getName() {
		return name;
	}

	public ItemStack getItemStack() {
		return item;
	}

	public void onClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		if (event.getClickedBlock() != null) {
			event.setCancelled(true);
			return;
		}

		player.getWorld()
				.spawnEntity(player.getEyeLocation(), EntityType.PRIMED_TNT)
				.setVelocity(player.getLocation().getDirection().multiply(3));

	}

}
