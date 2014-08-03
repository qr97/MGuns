package io.github.qr97.mguns.weapons;

import io.github.qr97.mguns.weapons.types.ClickWeapon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TNTCannon implements ClickWeapon {

	private final String name = "TNTCannon";
	private ItemStack item;

	public TNTCannon() {
		ItemStack tntCannon = new ItemStack(Material.DISPENSER);

		ItemMeta meta = tntCannon.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "Lançador de TNT");
		List<String> loreList = new ArrayList<>();
		loreList.add("Lança TNTs");
		meta.setLore(loreList);
		tntCannon.setItemMeta(meta);

		item = tntCannon;

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
