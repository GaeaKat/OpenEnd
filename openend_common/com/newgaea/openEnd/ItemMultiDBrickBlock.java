package com.newgaea.openEnd;

import com.newgaea.openEnd.Blocks.DEndBrickBlock;


import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMultiDBrickBlock extends ItemBlock {
	public ItemMultiDBrickBlock(int par1) {
		super(par1);
		setHasSubtypes(true);
		this.setUnlocalizedName("DarkEndBrick");
	}
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + DEndBrickBlock.END_BRICK_TYPES[itemstack.getItemDamage()];
	}
}
