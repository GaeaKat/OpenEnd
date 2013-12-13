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
					
				}
			}
		}
	}
}
