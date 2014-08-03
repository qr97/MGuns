package io.github.qr97.mguns.weapons;

import io.github.qr97.mguns.weapons.types.ClickWeapon;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;

public class TorHammer implements ClickWeapon {

	private final String name = "TorHammer";
	private ItemStack item;
	
	public TorHammer() {
		ItemStack torHammer = new ItemStack(Material.DIAMOND_PICKAXE);
		
		ItemMeta meta = torHammer.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_BLUE + "TorHammer");
		meta.setLore(Arrays.asList("Cria um raio!"));
		
		torHammer.setItemMeta(meta);
		
		item = torHammer;
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
