package io.github.qr97.mguns.commands;

import io.github.qr97.mguns.MGuns;
import io.github.qr97.mguns.weapons.types.Weapon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetWeaponCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Esse comando nao pode ser executado pelo console!");
			return true;
		}
		
		if(args.length != 1) {
			return false;
		}
		
		Player player = (Player) sender;
		Weapon weapon = MGuns.getInstance().getWeapon(args[0].toLowerCase());
		
		if(weapon != null) {
			player.getInventory().addItem(weapon.getItemStack());
			player.sendMessage(ChatColor.GREEN + "Você recebeu a arma " + weapon.getName() + "!");
		} else {
			player.sendMessage(ChatColor.DARK_RED + "Essa arma não existe!");
		}
		
		return true;
		
	}

}
