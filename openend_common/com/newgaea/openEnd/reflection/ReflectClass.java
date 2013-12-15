package com.newgaea.openEnd.reflection;

import java.lang.reflect.Field;
import java.util.Map;

import com.newgaea.openEnd.OpenEndMod;

import net.minecraft.world.gen.ChunkProviderEnd;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

public class ReflectClass {

	
	
	public void reflectme()
	{
		String[] remaps=remapFieldNames("ChunkProviderEnd", "provideChunk");
		OpenEndMod.logger.info(remaps.toString());
		
	}
	
	
	public static String[] remapFieldNames(String className, String... fieldNames)
    {
        String internalClassName = FMLDeobfuscatingRemapper.INSTANCE.unmap(className.replace('.', '/'));
        String[] mappedNames = new String[fieldNames.length];
        int i = 0;
        for (String fName : fieldNames)
        {
            //mappedNames[i++] = FMLDeobfuscatingRemapper.INSTANCE.mapFieldName(internalClassName, fName, null);
        	mappedNames[i++]=FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(internalClassName,fName , null);
        }
        return mappedNames;
    }
}
