package com.watsonllc.miner.config;

import com.watsonllc.miner.Miner;

public class Config {
	
	public static void load() {
		create();
		Data.create();
	}
	
	public static void create() {
		Miner.instance.getConfig().options().copyDefaults(true);
		Miner.instance.saveDefaultConfig();
	}
	
	public static void save() {
		Miner.instance.saveConfig();
	}
	
}
