package com.newgaea.openEnd.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;


public class OEBlockStairs extends BlockStairs
{
    public OEBlockStairs(int par1, Block par2Block, int par3)
    {
    	super(par1,par2Block,par3);
        this.setHardness(par2Block.blockHardness);
        this.setResistance(par2Block.blockResistance / 3.0F);
        this.setStepSound(par2Block.stepSound);
        this.setLightOpacity(255);
    }

   
}
