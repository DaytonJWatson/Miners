package com.watsonllc.miner.controllers;

import org.bukkit.entity.Player;

import com.watsonllc.miner.config.Data;

import de.ancash.actionbar.ActionBarAPI;

public class PointsController {
	
	Player player;
	String path;
	
	public PointsController(Player player) {
		this.path = player.getName()+".";
		this.player = player;
	}
	
	public void addPoints(double amount, boolean useMultiplier) {
		double balance = getPoints();
		double net = amount+balance;
		double multiplierNet = net*getMultiplier();
		
		if(useMultiplier) 
			Data.setDouble(path+"Points", net+multiplierNet);
		else
			Data.setDouble(path+"Points", net);
		return;
	}
	
	public void removePoints(double amount) {
		double balance = getPoints();
		double net = balance-amount;
		
		Data.setDouble(path+"Points", net);
		return;
	}
	
	public void setPoints(double amount) {
		Data.setDouble(path+"Points", amount);
		return;
	}
	
	public void increaseMultiplier(double amount) {
		Data.setDouble(path+"Multiplier", amount+getMultiplier());
		return;
	}
	
	public void decreaseMultiplier(double amount) {
		Data.setDouble(path+"Multiplier", getMultiplier()-amount);
		return;
	}
	
	public void setMultiplier(double amount) {
		Data.setDouble(path+"Multiplier", amount);
		return;
	}
	
	public double getMultiplier() {
		return Data.getDouble(path+"Multiplier");
	}
	
	public double getPoints() {
		return round(Data.getDouble(path+"Points"));
	}
	
	public void sendPointsUpdate() {
		ActionBarAPI.sendActionBar(player, getPoints() + " || " + getMultiplier());
		//ActionBarAPI.sendActionBar(player, "Points: " + getPoints() + " || Multiplier: " + getMultiplier());
		
		return;
	}
	
	// math
	
	public double round(double num) {
		return Math.round(num * 100.0) / 100.0;
	}
}
