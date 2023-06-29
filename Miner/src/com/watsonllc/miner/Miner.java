package com.watsonllc.miner;

import org.bukkit.plugin.java.JavaPlugin;

import com.watsonllc.miner.commands.Commands;
import com.watsonllc.miner.config.Config;
import com.watsonllc.miner.listeners.Listeners;

public class Miner extends JavaPlugin {
	
	public static Miner instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Config.load();
		Commands.load();
		Listeners.load();
	}
	
	@Override
	public void onDisable() {
		
	}
}