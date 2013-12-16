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
		String[] remaps=remapMethodNames("net/minecraft/world/gen/ChunkProviderEnd", "func_73154_d");
		OpenEndMod.logger.info(remaps[0].toString());
	}
	
	
	public static String[] remapMethodNames(String className, String... methodNames)
    {
        String internalClassName = FMLDeobfuscatingRemapper.INSTANCE.unmap(className.replace('.', '/'));
        String[] mappedNames = new String[methodNames.length];
        int i = 0;
        for (String mName : methodNames)
        {
            //mappedNames[i++] = FMLDeobfuscatingRemapper.INSTANCE.mapFieldName(internalClassName, fName, null);
        	mappedNames[i++]=FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(internalClassName,mName , null);
        }
        return mappedNames;
    }
}
