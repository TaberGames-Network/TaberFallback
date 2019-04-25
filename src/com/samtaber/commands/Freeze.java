package com.samtaber.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.samtaber.base.Base;
import com.samtaber.main.Main;

public class Freeze implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("freeze")) {
			
			if(args.length == 0) {
				
				sender.sendMessage(Base.globalPrefix + "Please specify a player!");
				
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(target == null) {
				
				sender.sendMessage(Base.globalPrefix + "Could not find player " + args[0]);
				
			}
			if(Main.frozen.contains(target.getName())) {
				
				Main.frozen.remove(target.getName());
				sender.sendMessage(Base.globalPrefix + "Player " + target.getName() + " has been unfrozen.");
				return true;
			}
			
if(!Main.frozen.contains(target.getName())) {
				
	Main.frozen.add(target.getName());
	Bukkit.getServer().getConsoleSender().sendMessage(Base.globalPrefix + "Frozen player " + target.getName());
	sender.sendMessage(Base.globalPrefix + "Player " + target.getName() + " has been frozen.");
	return true;
			}
			
			
			
		}
		
		
		return false;
	}

	
	
}
