package com.watsonllc.miner.listeners;

import org.bukkit.plugin.PluginManager;

import com.watsonllc.miner.Miner;
import com.watsonllc.miner.listeners.player.BlockBreak;

public class Listeners {
	public static void load() {
		PluginManager pm = Miner.instance.getServer().getPluginManager();
		
		pm.registerEvents(new BlockBreak(), Miner.instance);
	}
}
