package com.samtaber.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteChat implements Listener{

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		e.setCancelled(true);
		
		
	}
	
	
}
