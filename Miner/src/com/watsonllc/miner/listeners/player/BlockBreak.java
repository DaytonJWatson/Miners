package com.watsonllc.miner.listeners.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.watsonllc.miner.controllers.PointsController;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		PointsController pc = new PointsController(player);

		pc.addPoints(rewardAmount(block), true);
		pc.sendPointsUpdate();
	}

	// Gives the player points from TNT explosions.
	// excludes certain types of blocks.
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		TNTPrimed tnt = (TNTPrimed) event.getEntity();
		Player player = (Player) tnt.getSource();

		if (!(event.getEntity() instanceof TNTPrimed))
			return;

		if (!(tnt.getSource() instanceof Player))
			return;

		if (player == null)
			return;

		int blockCount = 0;
		for (Block block : event.blockList()) {
			if (excluded(block))
				return;

			blockCount++;
		}

		PointsController pc = new PointsController(player);
		pc.addPoints(blockCount, true);
		pc.sendPointsUpdate();
	}
	
	@EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
		if(!instaMine(event.getBlock()))
			return;
		
        event.setInstaBreak(true);
    }
	
	private double rewardAmount(Block block) {
		switch(block.getType()) {
		case COAL_ORE:
			return 10;
		case DEEPSLATE_COAL_ORE:
			return 12;
		case IRON_ORE:
			return 12;
		case DEEPSLATE_IRON_ORE:
			return 15;
		case COPPER_ORE:
			return 8;
		case DEEPSLATE_COPPER_ORE:
			return 10;
		case GOLD_ORE:
			return 25;
		case DEEPSLATE_GOLD_ORE:
			return 32;
		case DIAMOND_ORE:
			return 50;
		case DEEPSLATE_DIAMOND_ORE:
			return 62;
		case LAPIS_ORE:
			return 48;
		case DEEPSLATE_LAPIS_ORE:
			return 48;
		case REDSTONE_ORE:
			return 32;
		case DEEPSLATE_REDSTONE_ORE:
			return 36;
		case EMERALD_ORE:
			return 1000;
		case DEEPSLATE_EMERALD_ORE:
			return 1500;
		default:
			return 1;
		}
	}
	
	private boolean instaMine(Block block) {
		switch(block.getType()) {
		case COAL_ORE:
			return true;
		case DEEPSLATE_COAL_ORE:
			return true;
		case IRON_ORE:
			return true;
		case DEEPSLATE_IRON_ORE:
			return true;
		case COPPER_ORE:
			return true;
		case DEEPSLATE_COPPER_ORE:
			return true;
		case GOLD_ORE:
			return true;
		case DEEPSLATE_GOLD_ORE:
			return true;
		case DIAMOND_ORE:
			return true;
		case DEEPSLATE_DIAMOND_ORE:
			return true;
		case LAPIS_ORE:
			return true;
		case DEEPSLATE_LAPIS_ORE:
			return true;
		case REDSTONE_ORE:
			return true;
		case DEEPSLATE_REDSTONE_ORE:
			return true;
		case EMERALD_ORE:
			return true;
		case DEEPSLATE_EMERALD_ORE:
			return true;
		default:
			return false;
		}
	}

	private boolean excluded(Block block) {
		switch (block.getType()) {
		case TNT:
			return true;
		case GRASS:
			return true;
		case TALL_GRASS:
			return true;
		default:
			return false;
		}
	}
}