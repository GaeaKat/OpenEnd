package com.newgaea.openEnd.gen.structure;

import java.lang.reflect.Field;

import com.newgaea.openEnd.OpenEndMod;

import cpw.mods.fml.relauncher.ReflectionHelper;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class EndWorldGenHandler {

	
	
	MapGenEndVillage village=new MapGenEndVillage();
	@ForgeSubscribe
	public void onPopulate(PopulateChunkEvent.Post postEvent)
	{
		
		//OpenEndMod.logger.info(Integer.toString(postEvent.world.provider.dimensionId));
		if(postEvent.world.provider.dimensionId==1)
		{
			OpenEndMod.logger.info("Generating the end!");
			
			village.generateStructuresInChunk(postEvent.world, postEvent.rand, postEvent.chunkX, postEvent.chunkZ);
			
		}
	}
	@ForgeSubscribe
	public void onProvide(ChunkProviderEvent.ReplaceBiomeBlocks onProvider)
	{
		
	}
}
