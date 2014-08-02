package io.github.qr97.mguns.commands;

import org.bukkit.command.CommandSender;

public interface MGCommand {
	
	public String getName();
	
	public String getPermission();
	
	public String getUsageMessage();
	
	public boolean execute(CommandSender sender, String[] args);
	
}
