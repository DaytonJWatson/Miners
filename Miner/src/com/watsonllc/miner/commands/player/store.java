package com.watsonllc.miner.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class store implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("store")) {
			player.sendMessage("Miner Store Menu");
			player.sendMessage("");
			player.sendMessage("coming soon!");

			
		}
		return false;
	}

}
