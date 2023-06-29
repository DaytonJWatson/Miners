package com.watsonllc.miner.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("help")) {
			player.sendMessage("Miner Help Menu");
			player.sendMessage("");
			player.sendMessage("/help");
			player.sendMessage("/store");
			player.sendMessage("/points");
		}
		return false;
	}

}
