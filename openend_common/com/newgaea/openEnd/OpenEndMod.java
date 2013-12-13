/**
 * 
 */
package com.newgaea.openEnd;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;

import com.newgaea.openEnd.Blocks.DEndStoneBlock;
import com.newgaea.openEnd.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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
	public static Block DEndStone;
	public void InitBlocks()
	{
		DEndStone=new DEndStoneBlock(Configs.DarkEndStoneId, Material.rock)
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
