package com.newgaea.openEnd.items;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCrystalSpawner extends Item {

	public ItemCrystalSpawner(int par1) {
		super(par1);
		maxStackSize=1;
		setMaxDamage(64);
	}

		
		@Override
		public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		
		{
			if (par7 == 0)
	        {
	            --par5;
	        }

	        if (par7 == 1)
	        {
	            ++par5;
	        }

	        if (par7 == 2)
	        {
	            --par6;
	        }

	        if (par7 == 3)
	        {
	            ++par6;
	        }

	        if (par7 == 4)
	        {
	            --par4;
	        }

	        if (par7 == 5)
	        {
	            ++par4;
	        }

	        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	            return false;
	        final int i1 = par3World.getBlockId(par4, par5, par6);
	        final int i2 = par3World.getBlockId(par4, par5-1, par6);
	        if (i1 == 0) {
	        	if(i2==Block.obsidian.blockID)
	        	{
	        		if (!par3World.isRemote)
	                {
	        			EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(par3World);
	        			entityendercrystal.setLocationAndAngles((double)((float)par4 + 0.5F), (double)(par5 - 1f), (double)((float)par6 + 0.5F), (float) (0.5 * 360.0F), 0.0F);
	        			par3World.spawnEntityInWorld(entityendercrystal);
	                }
	        	}
	        }
	        
	        return false;
	}

}
