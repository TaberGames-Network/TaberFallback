package com.samtaber.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.samtaber.main.Main;

public class PlayerMove implements Listener{
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		if(Main.frozen.contains(p.getName())) {
			
			e.setTo(e.getFrom());
			
			
		}
		
	}
	
}
