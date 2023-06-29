package com.watsonllc.miner.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watsonllc.miner.controllers.PointsController;
import com.watsonllc.miner.utils.Utils;

public class points implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		PointsController pc = new PointsController(player);
		
		if(cmd.getName().equalsIgnoreCase("points")) {
			player.sendMessage("You have " + pc.getPoints() + " points!");
		}
		
		if(cmd.getName().equalsIgnoreCase("highest")) {
			Bukkit.broadcastMessage(Utils.playerWithHighestPoints().getName() + " has the most points.");
			Utils.playerWithHighestPoints().sendMessage("You have the highest points");
		}
		return false;
	}

}
