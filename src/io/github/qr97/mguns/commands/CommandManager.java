package io.github.qr97.mguns.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
	
	private Map<String, MGCommand> commands = new HashMap<>();
	
	public void registerCommand(MGCommand command) {
		commands.put(command.getName().toLowerCase(), command);
	}
	
	private MGCommand getCommand(String name) {
		String lowerName = name.toLowerCase();
		for(String cmdName : commands.keySet()) {
			if(cmdName.equals(lowerName)) {
				return commands.get(cmdName);
			}
		}
		
		return null;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length == 0) return false;
		
		MGCommand cmd = getCommand(args[0]);
		String[] cmdArgs = Arrays.copyOfRange(args, 1, args.length);
		
		if(cmd != null) {
			
			String permission = cmd.getPermission();
			if(permission != null) {
				if(!sender.hasPermission(permission)) {
					sender.sendMessage(ChatColor.DARK_RED + "Você não tem permissão!");
					return true;
				}
			}
			
			boolean executed = cmd.execute(sender, cmdArgs);
			if(!executed) {
				sender.sendMessage(cmd.getUsageMessage());
			}
			
			return true;
			
		} else {
			sender.sendMessage(ChatColor.RED + "Esse comando não existe!");
		}
		
		return true;
	}

}
