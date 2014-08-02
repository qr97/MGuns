package io.github.qr97.mguns.commands;

import io.github.qr97.mguns.MGuns;
import io.github.qr97.mguns.weapons.types.Weapon;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCommand implements MGCommand {

	private MGuns plugin;
	
	public GetCommand(MGuns plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean execute(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Esse comando nao pode ser executado pelo console!");
			return true;
		}
		
		if(args.length != 1) {
			return false;
		}
		
		Player player = (Player) sender;
		Weapon weapon = plugin.getWeapon(args[0].toLowerCase());
		
		if(weapon != null) {
			player.getInventory().addItem(weapon.getItemStack());
			player.sendMessage(ChatColor.GREEN + "Você recebeu a arma " + weapon.getName() + "!");
		} else {
			player.sendMessage(ChatColor.DARK_RED + "Essa arma não existe!");
		}
		
		return true;
		
	}

	@Override
	public String getName() {
		return "get";
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsageMessage() {
		return "Use /get <weapon>";
	}


}
