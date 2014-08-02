package io.github.qr97.mguns.commands;

import io.github.qr97.mguns.MGuns;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ListCommand implements MGCommand {
	
	private MGuns plugin;
	
	public ListCommand(MGuns plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public String getName() {
		return "list";
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsageMessage() {
		return "Use /mguns list";
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GREEN + "-- Armas disponíveis --");
		
		for(String weaponName : plugin.getWeaponsNameSet()) {
			sender.sendMessage(ChatColor.GOLD + weaponName);
		}
		
		return true;
	}

}
