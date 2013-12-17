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
			list.appendTag(new NBTTagString(Integer.toString(i),page));
			page="";
			line=br.readLine();
		}
		nbt.setTag("pages", list);
		book.setTagCompound(nbt);
		OpenEndMod.EndVillage.addItem(new WeightedRandomChestContent(book, 99, 99, 99));
		
	}

}
