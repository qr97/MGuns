package io.github.qr97.mguns.weapons;

import io.github.qr97.mguns.util.ItemUtils;
import io.github.qr97.mguns.weapons.types.ClickWeapon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

public class TorHammer implements ClickWeapon {

	private final String name = "TorHammer";
	private ItemStack item;
	
	public TorHammer() {
		item = ItemUtils.createItem(Material.DIAMOND_PICKAXE, ChatColor.DARK_BLUE + "TorHammer",
				"Cria um raio!");
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
	public void onClick(PlayerInteractEvent event) {
		BlockIterator iterator = new BlockIterator(event.getPlayer(), 50);
		
		while(iterator.hasNext()) {
			Block block = iterator.next();
			if(block.getType() != Material.AIR) {
				block.getWorld().strikeLightning(block.getLocation());
				break;
			}
		}
		
	}

}
