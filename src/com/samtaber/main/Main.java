package com.samtaber.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.base.Base;
import com.samtaber.events.MuteChat;
import com.samtaber.events.PlayerJoin;
import com.samtaber.events.PlayerMove;

public class Main extends JavaPlugin{

	public static Main instance;
	public static ArrayList<String> frozen = new ArrayList<String>();
	
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new MuteChat(), this);
		
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		
	}
	
public static void announceStart(Player p) {
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(instance, new Runnable(){
			
			@Override
			public void run() {
				
				p.sendMessage(Base.globalPrefix + "Our main servers are down. Give us up to two minutes, and rejoin with /server hub!");
				
			}
			
		}, 500, 1200);
		
	}
	
}
