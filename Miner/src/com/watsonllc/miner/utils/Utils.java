package com.watsonllc.miner.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.watsonllc.miner.controllers.PointsController;

public class Utils {

	public static Player playerWithHighestPoints() {
	    double highestPoints = 0;
	    Player highestPointsPlayer = null;

	    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
	    	PointsController pc = new PointsController(player);
	        double playerPoints = pc.getPoints();
	        
	        if (playerPoints > highestPoints) {
	            highestPoints = playerPoints;
	            highestPointsPlayer = player;
	        }
	    }
	    
	    return highestPointsPlayer;
	}
}
