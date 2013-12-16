package com.newgaea.openEnd.gen.structure;

import java.lang.reflect.Field;

import com.newgaea.openEnd.OpenEndMod;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;

import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureMineshaftStart;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class EndWorldGenHandler {

	
	
	MapGenEndVillage village=new MapGenEndVillage();
	
	static
    {
        MapGenStructureIO.func_143034_b(StructureEndVillageStart.class, "EndVillage");
        StructureEndVillagePieces.func_143016_a();
    }
        
	@ForgeSubscribe
	public void onPopulate(PopulateChunkEvent.Post postEvent)
	{
		//OpenEndMod.logger.info(Integer.toString(postEvent.world.provider.dimensionId));
		if(postEvent.world.provider.dimensionId==1)
		{
			OpenEndMod.logger.info("Generating the end!");
			ExtendedBlockStorage[] arr=((ChunkProviderServer)postEvent.chunkProvider).loadChunk(postEvent.chunkX, postEvent.chunkZ).getBlockStorageArray();
			byte[] temp=new byte[arr.length];
			village.generate(postEvent.chunkProvider,postEvent.world,postEvent.chunkX,postEvent.chunkZ,temp);
			OpenEndMod.logger.info(Byte.toString(temp[1]));
			village.generateStructuresInChunk(postEvent.world, postEvent.rand, postEvent.chunkX, postEvent.chunkZ);
			
		}
	}
	@ForgeSubscribe
	public void onProvide(ChunkProviderEvent.ReplaceBiomeBlocks onProvider)
	{
		
	}
}
