/**
 * 
 */
package com.newgaea.openEnd.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * @author Katrina
 *
 */
public class DEndStoneBlock extends Block {

	public DEndStoneBlock(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	@Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
}
