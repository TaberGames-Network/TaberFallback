package com.samtaber.events;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.samtaber.main.Main;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class PlayerJoin implements Listener{
	
	public static Main instance;
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE,ChatSerializer.a("{\"text\":\"§6§lGreetings!\"}"), 200 , 3500 , 400);
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,ChatSerializer.a("{\"text\":\"§7§oGive us up to two minutes, then relaunch your game!\"}"), 200 , 3500 , 400);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(subtitle);
		
		//Announcer
		Main.announceStart(p);
		
		//Vanish
		for(Player online : Bukkit.getOnlinePlayers()) {
			
			p.hidePlayer(online);
			online.hidePlayer(p);
		}
		//Freeze
		Main.frozen.add(p.getName());
		
	}
	

}
