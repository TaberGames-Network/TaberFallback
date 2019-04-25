package com.samtaber.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.commands.Freeze;
import com.samtaber.events.PlayerMove;

public class Main extends JavaPlugin{

	public static Main instance;
	public static ArrayList<String> frozen = new ArrayList<String>();
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		this.getCommand("freeze").setExecutor((CommandExecutor)new Freeze());
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		
	}
	
}
