package com.newgaea.openEnd.Blocks;

import java.util.List;
import java.util.Random;

import com.newgaea.openEnd.OpenEndMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EndSlabBlock extends BlockHalfSlab {

	public EndSlabBlock(int par1, boolean par2) {
		super(par1,par2,Material.rock);
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		// TODO Auto-generated method stub
		return OpenEndMod.SmoothEndStone.getIcon(par1, par2);
	}


	public String getFullSlabName(int i) {
		// TODO Auto-generated method stub
		return "EndSlab";
	}
	@Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
	
}
