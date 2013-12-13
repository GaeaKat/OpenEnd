package com.newgaea.openEnd.schematics;

import java.io.IOException;
import java.io.InputStream;

import com.newgaea.openEnd.OpenEndMod;
import com.newgaea.openEnd.lib.Reference;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SchematicManager {

	
	
	public static Schematic loadSchematic(String file,World world)
	{
		Schematic schematic=null;
		InputStream is=SchematicManager.class.getResourceAsStream("/assets/"+Reference.MODID.toLowerCase()+"/schematics/"+file+".schematic");
		try
		{
			NBTTagCompound comp=CompressedStreamTools.readCompressed(is);
			schematic=Schematic.loadSchematic(comp,world);
		}
		catch(Exception e)
		{
			OpenEndMod.logger.severe(e.toString());
		}
		return schematic;
	}
	
	
	
	public static void PlaceSchematic(Schematic schematic,World world,int x, int y, int z)
	{
		for(int i=0;i<schematic.getHeight();i++)
		{
			// Is this right?
			for(int j=0;j<schematic.getLength();j++)
			{
				for(int k=0;k<schematic.getWidth();k++)
				{
					try
					{
						int index=i*schematic.getWidth() *schematic.getLength() +j * schematic.getWidth()+k;
						short blockId=schematic.getBlocks()[index];
						short blockMeta=schematic.getBlockData()[index];
						// Add here ability to add in other mods later if(blockId=)
						if(blockId<0 || blockId>=4096)
							OpenEndMod.logger.severe("There is an Error here!");
						world.setBlock(k+x, i+y,j+z, blockId,blockMeta,2);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						OpenEndMod.logger.severe((String.format("Failed placing block id: %d", x)));
					}
				}
			}
		}
		for(TileEntity entity:schematic.getTileEntities())
		{
			world.setBlockTileEntity(entity.xCoord+x, entity.yCoord+y, entity.zCoord+z, entity);
		}
		
		// Add Entity loading into this later!
		//for(Entity ent:schematic.getEntities())
		//
		//}
	}
}
