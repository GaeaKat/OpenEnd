package com.newgaea.openEnd.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class SmoothEndStoneBlock extends Block {

	public SmoothEndStoneBlock(int par1) {
		super(par1, Material.rock);
	}
	@Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
}
