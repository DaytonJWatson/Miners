package com.watsonllc.miner.commands;

import com.watsonllc.miner.Miner;
import com.watsonllc.miner.commands.player.help;
import com.watsonllc.miner.commands.player.points;
import com.watsonllc.miner.commands.player.store;

public class Commands {
	public static void load() {
		Miner.instance.getCommand("help").setExecutor(new help());
		Miner.instance.getCommand("store").setExecutor(new store());
		Miner.instance.getCommand("points").setExecutor(new points());
		Miner.instance.getCommand("highest").setExecutor(new points());
	}
}