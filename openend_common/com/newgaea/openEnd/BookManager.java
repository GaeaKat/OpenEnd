package com.newgaea.openEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

import com.newgaea.openEnd.lib.Reference;

public class BookManager {
	
	
	public static void Load()
	{
		try {
			InputStream is=BookManager.class.getResourceAsStream("/assets/"+Reference.MODID.toLowerCase()+"/books/index");
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(reader);
			List<String> books=new LinkedList<String>();
			String line=br.readLine();
			while(line!=null)
			{
				books.add(line);
				line=br.readLine();
			}
			for(String s:books)
			{
				loadBook(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void loadBook(String s) throws IOException {
		
		InputStream is=BookManager.class.getResourceAsStream("/assets/"+Reference.MODID.toLowerCase()+"/books/"+s);
		InputStreamReader reader=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(reader);
		String line=br.readLine();
		String title=br.readLine();
		String author=br.readLine();
		String spawnlistLong=br.readLine();
		String[] spawnlist=spawnlistLong.split(",");
		line=br.readLine();
		ItemStack book=new ItemStack(Item.writtenBook);
		NBTTagCompound nbt=book.getTagCompound();
		if(nbt==null)
			nbt=new NBTTagCompound();
		nbt.setString("author", author);
		nbt.setString("title", title);
		String curPage;
		NBTTagList list=new NBTTagList();
		list.setName("pages");
		int i=1;
		String page="";
		line=br.readLine();
		while(line!=null)
		{
			while(line!=null && !line.equalsIgnoreCase("-->>"))
			{
				page+=line;
				line=br.readLine();
			}	
			page=page.replace('^', '\n');
			list.appendTag(new NBTTagString(Integer.toString(i),page));
			page="";
			line=br.readLine();
		}
		nbt.setTag("pages", list);
		book.setTagCompound(nbt);
		
		for(String place:spawnlist)
		{
			if(place.equalsIgnoreCase("STRONGHOLD"))
			{
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
			}
			if(place.equalsIgnoreCase(("DUNGEON")))
			{
				ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
			}
			if(place.equalsIgnoreCase(("ENDVILLAGE")))
			{
				OpenEndMod.EndVillage.addItem(new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
			}
			if(place.equalsIgnoreCase(("ENDVILLAGECHURCH")))
			{
				OpenEndMod.EndChurch.addItem(new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
			}
			if(place.equalsIgnoreCase(("ENDVILLAGEDARKCHURCH")))
			{
				OpenEndMod.EndDarkChurch.addItem(new WeightedRandomChestContent(book, 1, 1, Configs.bookChance));
			}
			if(place.equalsIgnoreCase(("ALL")))
			{
				WeightedRandomChestContent content=new WeightedRandomChestContent(book, 1, 1, Configs.bookChance);
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, content);
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, content);
				ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, content);
				ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, content);
				ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, content);
				ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, content);
				ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, content);
				ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, content);
				ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, content);
				ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, content);
				OpenEndMod.EndChurch.addItem(content);
				OpenEndMod.EndVillage.addItem(content);
				OpenEndMod.EndDarkChurch.addItem(content);
			}
		}
		
		
	}

}
