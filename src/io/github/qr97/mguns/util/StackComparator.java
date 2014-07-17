package io.github.qr97.mguns.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StackComparator {
	
	public static boolean equals(ItemStack stack1, ItemStack stack2) {
		if(!stack1.isSimilar(stack2))
			return false;
		
		ItemMeta meta1 = stack1.getItemMeta();
		ItemMeta meta2 = stack2.getItemMeta();
		
		if(meta1.hasDisplayName() != meta2.hasDisplayName() || meta1.hasLore() != meta2.hasLore()) {
			return false;
		}
		
		boolean sameName = true;
		boolean sameLore = true;
		
		if(meta1.hasDisplayName()) {
			sameName = meta1.getDisplayName().equals(meta2.getDisplayName());
		}
		
		if(meta1.hasLore()) {
			sameLore = meta1.getLore().equals(meta2.getLore());
		}
		
		return sameName && sameLore;
		
	}
	
}
