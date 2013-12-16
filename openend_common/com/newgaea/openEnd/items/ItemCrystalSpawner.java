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
		
		public void checkSummoning(World world,int x,int y, int z)
		{
			
			int xCorner=-1;
			int zCorner=-1;
			
			// Long way round I know, there is probably better but is only 20 blocks
			// x +5 z+ 5
			
			boolean blocks;
			boolean fin=false;;
			

			blocks=checkArea(world, x, y, z, 0);
			if(blocks)
			{
				xCorner=x+5;
				zCorner=z+5;
				fin=true;
			}
			blocks=checkArea(world, x, y, z, 1);
			if(blocks)
			{
				xCorner=x+5;
				zCorner=z+5;
				fin=true;
			}
			blocks=checkArea(world, x, y, z, 2);
			if(blocks)
			{
				xCorner=x+5;
				zCorner=z+5;
				fin=true;
			}
			blocks=checkArea(world, x, y, z, 3);
			if(blocks)
			{
				xCorner=x+5;
				zCorner=z+5;
			}
			for(int i=0;i<4;i++)
			{
				if(checkArea(world, x, y, z, i))
				{
					switch(i)
					{
					case 0:
						xCorner=x+5;
						zCorner=z+5;
						break;
					case 1:
						xCorner=x+5;
						zCorner=z-5;
						break;
					case 2:
						xCorner=x-5;
						zCorner=z+5;
						break;
					case 3:
						xCorner=x-5;
						zCorner=z-5;
						break;
					}
				}
			}
		}

		public boolean checkArea(World world,int x,int y,int z,int direction)
		{
			boolean blocksComplete=true;
			
			switch(direction)
			{
			case 0:
				for(int i=x;i<x+5;i++)
				{
					for(int j=z;j<z+5;j++)
					{
						if(world.getBlockId(i, y-2, j)!=Block.obsidian.blockID)
						{
							blocksComplete=false;
							break;
						}
					}
				}
				return blocksComplete;
				
				
				
			case 1:
				for(int i=x;i<x+5;i++)
				{
					for(int j=z;j>z-5;j--)
					{
						if(world.getBlockId(i, y-2, j)!=Block.obsidian.blockID)
						{
							blocksComplete=false;
							break;
						}
					}
				}
				return blocksComplete;
				
				
				case 2:
				for(int i=x;i>x-5;i--)
				{
					for(int j=z;j<z+5;j++)
					{
						if(world.getBlockId(i, y-2, j)!=Block.obsidian.blockID)
						{
							blocksComplete=false;
							break;
						}
					}
				}
				
				return blocksComplete;
				
				case 3:
				for(int i=x;i>x-5;i--)
				{
					for(int j=z;j>z-5;j--)
					{
						if(world.getBlockId(i, y-2, j)!=Block.obsidian.blockID)
						{
							blocksComplete=false;
							break;
						}
					}
				}
				return blocksComplete;
				default:
					return false;
			}
			
		}
}
