/**
 * 
 */
package com.newgaea.openEnd;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTextureTile;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import com.newgaea.openEnd.Blocks.DEndBrickBlock;
import com.newgaea.openEnd.Blocks.DEndStoneBlock;
import com.newgaea.openEnd.Blocks.EndBrickBlock;
import com.newgaea.openEnd.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * @author Katrina
 *
 */
@Mod(modid=Reference.MODID,name=Reference.MODNAME,version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class OpenEndMod {

	
	@Instance(Reference.MODID)
	public static OpenEndMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY,serverSide=Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger=event.getModLog();
		
		Configs.load(new Configuration(event.getSuggestedConfigurationFile()));
	}
	public static CreativeTabs tabOpenEndBlocks=new CreativeTabs("tabOpenEndBlocks")
	{
		@Override
		public ItemStack getIconItemStack()
		{
			return new ItemStack(Block.whiteStone);
		}
	};
	public static Block DEndStone;
	public static Block EndBricks;
	public static Block DEndBricks;
	public void InitBlocks()
	{
		DEndStone=new DEndStoneBlock(Configs.DarkEndStoneId, Material.rock).setHardness(3.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("darkEndStone").setCreativeTab(tabOpenEndBlocks);
		GameRegistry.registerBlock(DEndStone,"DEndStone");
		LanguageRegistry.addName(DEndStone, "Dark End Stone");
		MinecraftForge.setBlockHarvestLevel(DEndStone, "pick", 0);
		
		EndBricks=new EndBrickBlock(Configs.EndBrickId, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("endbrick").setCreativeTab(tabOpenEndBlocks);
		GameRegistry.registerBlock(EndBricks, ItemMultiBrickBlock.class,"Endbricks");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.default.name","en_US", "Smooth Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.mossy.name","en_US", "Mossy Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.cracked.name","en_US", "Cracked Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.chiseled.name","en_US", "Chisled Endstone Brick");
		MinecraftForge.setBlockHarvestLevel(EndBricks, "pick", 0);
		
		DEndBricks=new DEndBrickBlock(Configs.DarkEndBrickId, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("darkendbrick").setCreativeTab(tabOpenEndBlocks);
		GameRegistry.registerBlock(DEndBricks, ItemMultiDBrickBlock.class,"DarkEndBricks");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.default.name","en_US", "Smooth Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.mossy.name","en_US", "Mossy Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.cracked.name","en_US", "Cracked Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.chiseled.name","en_US", "Chisled Dark Endstone Brick");
		MinecraftForge.setBlockHarvestLevel(DEndBricks, "pick", 0);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabOpenEndBlocks", "en_US","Open End Blocks");
		InitBlocks();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
