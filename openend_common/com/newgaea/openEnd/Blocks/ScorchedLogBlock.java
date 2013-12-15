package com.newgaea.openEnd.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ScorchedLogBlock extends BlockRotatedPillar {

	@SideOnly(Side.CLIENT)
	protected Icon logTop;
	@SideOnly(Side.CLIENT)
	protected Icon logSide;
	public ScorchedLogBlock(int par1) {
		super(par1, Material.wood);
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		// TODO Auto-generated method stub
		logTop=par1IconRegister.registerIcon("openend:log_scorched_top");
		logSide=par1IconRegister.registerIcon("openend:log_scorched");
	}
	@Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getSideIcon(int i) {
		// TODO Auto-generated method stub
		return logSide;
	}
	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getEndIcon(int par1) {
		// TODO Auto-generated method stub
		return logTop;
	}
	@Override
	public boolean isWood(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
