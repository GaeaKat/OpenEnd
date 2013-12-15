/**
 * 
 */
package com.newgaea.openEnd.Blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * @author Katrina
 *
 */
public class EndBrickBlock extends Block {

	public static final String[] END_BRICK_TYPES = new String[] {"default", "mossy", "cracked", "chiseled"};
    public static final String[] END_BRICK_TEXTURE_NAMES = new String[] {null, "mossy", "cracked", "carved"};
    @SideOnly(Side.CLIENT)
    private Icon[] end_brick_icons;
	public EndBrickBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= END_BRICK_TEXTURE_NAMES.length)
        {
            par2 = 0;
        }

        return this.end_brick_icons[par2];
    }
	
	
	
	
	@Override
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for (int j = 0; j < END_BRICK_TYPES.length; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.end_brick_icons = new Icon[END_BRICK_TEXTURE_NAMES.length];

        for (int i = 0; i < this.end_brick_icons.length; ++i)
        {
            String s = this.getTextureName();

            if (END_BRICK_TEXTURE_NAMES[i] != null)
            {
                s = s + "_" + END_BRICK_TEXTURE_NAMES[i];
            }

            this.end_brick_icons[i] = par1IconRegister.registerIcon(s);
        }
    }
	@Override
	@Deprecated
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}
}
