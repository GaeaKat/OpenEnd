package com.newgaea.openEnd;

import com.newgaea.openEnd.Blocks.EndBrickBlock;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMultiBrickBlock extends ItemBlock {

	public ItemMultiBrickBlock(int par1) {
		super(par1);
		setHasSubtypes(true);
		this.setUnlocalizedName("EndBrick");
	}
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + EndBrickBlock.END_BRICK_TYPES[itemstack.getItemDamage()];
	}

}
