package com.samtaber.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.samtaber.base.Base;

public class Vanish implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(!(sender instanceof Player)) {
		sender.sendMessage(Base.globalPrefix + "You cannot vanish!");
		return true;
	}
	
	Player player = (Player) sender;
	
	if(cmd.getName().equalsIgnoreCase("vanish")) {
			
		for(Player online : Bukkit.getOnlinePlayers()) {
			
			player.hidePlayer(online);
			
		}
		
	}	
		return false;
	
	}
}
