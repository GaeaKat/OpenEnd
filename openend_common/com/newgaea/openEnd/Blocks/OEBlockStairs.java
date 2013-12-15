package com.newgaea.openEnd.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.World;


public class OEBlockStairs extends BlockStairs
{
    public OEBlockStairs(int par1, Block par2Block, int par3)
    {
    	super(par1,par2Block,par3);
    }

    @Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
}
