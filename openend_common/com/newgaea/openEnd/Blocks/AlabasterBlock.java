package com.newgaea.openEnd.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;

public class AlabasterBlock extends BlockStone {

	public AlabasterBlock(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }

	@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

}
