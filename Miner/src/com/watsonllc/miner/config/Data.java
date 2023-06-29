package com.watsonllc.miner.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.watsonllc.miner.Miner;

public class Data {

	private static File dataFile = new File(Miner.instance.getDataFolder(), "data.yml");
	private static YamlConfiguration data = YamlConfiguration.loadConfiguration(dataFile);
	
	public static void create() {
		if(dataFile.exists())
			return;
		
		try {
			data.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void save() {
		try {
			data.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(String path, String value) {
		data.set(path, value);
		save();
	}
	
	public static void setDouble(String path, double value) {
		data.set(path, value);
		save();
	}
	
	public static int getInt(String path) {
		return data.getInt(path);
	}
	
	public static double getDouble(String path) {
		return data.getDouble(path);
	}
}
