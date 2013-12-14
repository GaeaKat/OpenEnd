package com.newgaea.openEnd;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import net.minecraftforge.common.Configuration;

public class Configs {
	@Retention(RetentionPolicy.RUNTIME)
	private static @interface CfgId {
		public  boolean block() default false;
		public String comment() default "";
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	private static @interface CfgBool {public String comment() default "";}
	
	
	
	
	public static @CfgBool(comment="This setting controls whether the mod adds any world gen, recommended on!") boolean worldgen=true;
	
	
	// Blocks!
	public static @CfgId(block=true,comment="Block ID for Dark End Stone") int DarkEndStoneId=500;
	public static @CfgId(block=true,comment="Block ID for End Stone Bricks") int EndBrickId=501;
	public static @CfgId(block=true,comment="Block ID for Dark End Stone Bricks") int DarkEndBrickId=502;
	public static @CfgId(block=true,comment="Block ID for Scorched Log") int ScorchedLogId=503;
	public static @CfgId(block=true,comment="Block ID for Scorched Planks") int ScorchedPlankId=504;
	public static @CfgId(block=true,comment="Block ID for Alabaster Stone") int AlabasterStoneId=505;
	
	// Items!
	public static @CfgId(block=false,comment="Item ID for the test schematic Placer") int schematicPlacer=2015;
	
	public static void load(Configuration config)
	{
		try {
			config.load();
			Field[] fields=Configs.class.getFields();
			for(Field field:fields) {
				CfgId annotation=field.getAnnotation(CfgId.class);
				if(annotation!=null)
				{
					int id=field.getInt(null);
					if(annotation.block())
					{
						id=config.getBlock(field.getName(), id,annotation.comment()).getInt();
					}
					else
					{
						id=config.getItem(field.getName(), id, annotation.comment()).getInt();
					}
					field.setInt(null, id);
				}
				else
				{
					if(field.isAnnotationPresent(CfgBool.class))
					{
						CfgBool bAnnotation=field.getAnnotation(CfgBool.class);
						boolean bool=field.getBoolean(null);
						bool=config.get(Configuration.CATEGORY_GENERAL, field.getName(), bool,bAnnotation.comment()).getBoolean(bool);
						field.setBoolean(null, bool);
					}
				}
			}
		} catch (Exception e)
		{
			// Failed, throw somethign here later
		}
		finally
		{
			config.save();
		}
	}
}
