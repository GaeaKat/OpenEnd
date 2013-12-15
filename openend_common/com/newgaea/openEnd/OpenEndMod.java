/**
 * 
 */
package com.newgaea.openEnd;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.newgaea.openEnd.Blocks.AlabasterBlock;
import com.newgaea.openEnd.Blocks.DEndBrickBlock;
import com.newgaea.openEnd.Blocks.DEndStoneBlock;
import com.newgaea.openEnd.Blocks.EndBrickBlock;
import com.newgaea.openEnd.Blocks.OEBlockStairs;
import com.newgaea.openEnd.Blocks.ScorchedLogBlock;
import com.newgaea.openEnd.Blocks.ScorchedWoodBlock;
import com.newgaea.openEnd.Blocks.SmoothDarkEndStoneBlock;
import com.newgaea.openEnd.Blocks.SmoothEndStoneBlock;
import com.newgaea.openEnd.items.ItemSchematicPlacer;
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
	public static CreativeTabs tabOpenEndItems=new CreativeTabs("tabOpenEndItems")
	{
		@Override
		public ItemStack getIconItemStack()
		{
			return new ItemStack(Item.enderPearl);
		}
	};
	public static Block DEndStone;
	public static Block EndBricks;
	public static Block DEndBricks;
	public static Block ScorchedLog;
	public static Block ScorchedWood;
	public static Block AlabasterStone;
	public static Block SmoothEndStone;
	public static Block SmoothDarkEndStone;
	public static Block EndBricksStairs;
	public static Block DEndBricksStairs;
	public static Block ScorchedWoodStairs;
	public static Block SmoothEndStoneStairs;
	public static Block SmoothDarkEndStoneStairs;
	public static Block EndStoneStairs;
	public static Block DarkEndStoneStairs;
	
	public void InitBlocks()
	{
		DEndStone=new DEndStoneBlock(Configs.DarkEndStoneId, Material.rock).setHardness(3.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("darkEndStone").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:dark_end_stone");
		GameRegistry.registerBlock(DEndStone,"DEndStone");
		LanguageRegistry.addName(DEndStone, "Dark End Stone");
		MinecraftForge.setBlockHarvestLevel(DEndStone, "pick", 0);
		
		EndBricks=new EndBrickBlock(Configs.EndBrickId, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("endbrick").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:end_stone_brick");
		GameRegistry.registerBlock(EndBricks, ItemMultiBrickBlock.class,"Endbricks");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.default.name","en_US", "Smooth Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.mossy.name","en_US", "Mossy Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.cracked.name","en_US", "Cracked Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.endbrick.chiseled.name","en_US", "Chisled Endstone Brick");
		MinecraftForge.setBlockHarvestLevel(EndBricks, "pick", 0);
		
		DEndBricks=new DEndBrickBlock(Configs.DarkEndBrickId, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("darkendbrick").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:dark_end_stone_brick");
		GameRegistry.registerBlock(DEndBricks, ItemMultiDBrickBlock.class,"DarkEndBricks");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.default.name","en_US", "Smooth Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.mossy.name","en_US", "Mossy Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.cracked.name","en_US", "Cracked Dark Endstone Brick");
		LanguageRegistry.instance().addStringLocalization("tile.darkendbrick.chiseled.name","en_US", "Chisled Dark Endstone Brick");
		MinecraftForge.setBlockHarvestLevel(DEndBricks, "pick", 0);
		
		ScorchedLog=new ScorchedLogBlock(Configs.ScorchedLogId).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("scorchedLog").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:scorched_log");
		GameRegistry.registerBlock(ScorchedLog,"ScorchedLog");
		LanguageRegistry.addName(ScorchedLog, "Scorched Log");
		MinecraftForge.setBlockHarvestLevel(ScorchedLog, "axe", 0);
		OreDictionary.registerOre("logWood", ScorchedLog);
		
		ScorchedWood=new ScorchedWoodBlock(Configs.ScorchedPlankId).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("ScorchedWood").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:scorched_wood");
		GameRegistry.registerBlock(ScorchedWood,"ScorchedWood");
		LanguageRegistry.addName(ScorchedWood, "Scorched Wood");
		MinecraftForge.setBlockHarvestLevel(ScorchedWood, "axe", 0);
		OreDictionary.registerOre("plankWood", ScorchedWood);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScorchedWood, 4),new ItemStack(ScorchedLog));
		
		AlabasterStone=new AlabasterBlock(Configs.AlabasterStoneId).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("alabaster").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:alabaster");
		GameRegistry.registerBlock(AlabasterStone,"alabasterStone");
		LanguageRegistry.addName(AlabasterStone, "Alabaster");
		MinecraftForge.setBlockHarvestLevel(AlabasterStone, "pick", 3);
		
		SmoothEndStone=new SmoothEndStoneBlock(Configs.SmoothEndStoneId).setHardness(3.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoothEndStone").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:smooth_end_stone");
		GameRegistry.registerBlock(SmoothEndStone, "smoothEndStone");
		LanguageRegistry.addName(SmoothEndStone, "Smooth End Stone");
		MinecraftForge.setBlockHarvestLevel(SmoothEndStone, "pick", 0);
		GameRegistry.addSmelting(Block.whiteStone.blockID, new ItemStack(SmoothEndStone), 0f);
		
		SmoothDarkEndStone=new SmoothDarkEndStoneBlock(Configs.DarkSmoothEndStoneId).setHardness(3.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoothDarkEndStone").setCreativeTab(tabOpenEndBlocks).setTextureName("openend:smooth_dark_end_stone");
		GameRegistry.registerBlock(SmoothDarkEndStone, "smoothDarkEndStone");
		LanguageRegistry.addName(SmoothDarkEndStone, "Smooth Dark End Stone");
		MinecraftForge.setBlockHarvestLevel(SmoothDarkEndStone, "pick", 0);
		GameRegistry.addSmelting(Configs.DarkEndStoneId, new ItemStack(SmoothDarkEndStone), 0f);
		
		
		EndStoneStairs=new OEBlockStairs(Configs.EndStoneStairsId, Block.whiteStone, 0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("endstoneSteps");
		GameRegistry.registerBlock(EndStoneStairs,"EndStoneStairs");
		LanguageRegistry.addName(EndStoneStairs, "End Stone Stairs");
		MinecraftForge.setBlockHarvestLevel(EndStoneStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(EndStoneStairs), "x  ","xx ","xxx",'x',new ItemStack(Block.whiteStone));
	
		
		
		DarkEndStoneStairs=new OEBlockStairs(Configs.DarkEndStoneStairsId,DEndStone,1).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("darkendstoneSteps");
		GameRegistry.registerBlock(DarkEndStoneStairs,"DarkEndStoneStairs");
		LanguageRegistry.addName(DarkEndStoneStairs, "Dark End Stone Stairs");
		MinecraftForge.setBlockHarvestLevel(DarkEndStoneStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(DarkEndStoneStairs), "x  ","xx ","xxx",'x',new ItemStack(DEndStone));
		
		EndBricksStairs=new OEBlockStairs(Configs.EndBrickStairsId,EndBricks,0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("endBrickSteps");
		GameRegistry.registerBlock(EndBricksStairs,"EndBrickStairs");
		LanguageRegistry.addName(EndBricksStairs, "End Brick Stairs");
		MinecraftForge.setBlockHarvestLevel(EndBricksStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(EndBricksStairs), "x  ","xx ","xxx",'x',new ItemStack(EndBricks));
		
		DEndBricksStairs=new OEBlockStairs(Configs.DarkEndBrickStairsId,DEndBricks,0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("darkEndBrickSteps");
		GameRegistry.registerBlock(DEndBricksStairs,"DarkEndBrickStairs");
		LanguageRegistry.addName(DEndBricksStairs, "Dark End Brick Stairs");
		MinecraftForge.setBlockHarvestLevel(DEndBricksStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(DEndBricksStairs), "x  ","xx ","xxx",'x',new ItemStack(DEndBricks));
		
		
		SmoothEndStoneStairs=new OEBlockStairs(Configs.SmoothEndStoneStairsId,SmoothEndStone,0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("smoothEndStoneSteps");
		GameRegistry.registerBlock(SmoothEndStoneStairs,"SmoothEndStoneStairs");
		LanguageRegistry.addName(SmoothEndStoneStairs, "Smooth End Stone Stairs");
		MinecraftForge.setBlockHarvestLevel(SmoothEndStoneStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(SmoothEndStoneStairs), "x  ","xx ","xxx",'x',new ItemStack(SmoothEndStone));
		
		SmoothDarkEndStoneStairs=new OEBlockStairs(Configs.DarkSmoothEndStoneStairsId,SmoothDarkEndStone,0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("DarkSmoothEndStoneSteps");
		GameRegistry.registerBlock(SmoothDarkEndStoneStairs,"SmoothDarkEndStoneStairs");
		LanguageRegistry.addName(SmoothDarkEndStoneStairs, "Smooth Dark End Stone Stairs");
		MinecraftForge.setBlockHarvestLevel(SmoothDarkEndStoneStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(SmoothDarkEndStoneStairs), "x  ","xx ","xxx",'x',new ItemStack(SmoothDarkEndStone));
		
		ScorchedWoodStairs=new OEBlockStairs(Configs.ScorchedWoodStairsId,ScorchedWood,0).setCreativeTab(tabOpenEndBlocks).setUnlocalizedName("ScorchedWoodSteps");
		GameRegistry.registerBlock(ScorchedWoodStairs,"ScorchedWoodStairs");
		LanguageRegistry.addName(ScorchedWoodStairs, "Scorched Wood Stairs");
		MinecraftForge.setBlockHarvestLevel(ScorchedWoodStairs, "pick", 0);
		GameRegistry.addShapedRecipe(new ItemStack(ScorchedWoodStairs), "x  ","xx ","xxx",'x',new ItemStack(ScorchedWood));
		
		
	}
	
	
	
	public static Item testSchematicPlacer;
	public void InitItems()
	{
		testSchematicPlacer=new ItemSchematicPlacer(Configs.schematicPlacer).setCreativeTab(tabOpenEndItems).setUnlocalizedName("schematicPlacer");
		GameRegistry.registerItem(testSchematicPlacer, "TestSchematicPlacer");
	}
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabOpenEndBlocks", "en_US","Open End Blocks");
		InitBlocks();
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabOpenEndItems", "en_US","Open End Items");
		InitItems();
	}	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
