package com.newgaea.openEnd.schematics;

import java.io.IOException;
import java.io.InputStream;

import com.newgaea.openEnd.OpenEndMod;
import com.newgaea.openEnd.lib.Reference;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
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
		catch(IOException e)
		{
			OpenEndMod.logger.severe(e.toString());
		}
		return schematic;
	}
}
