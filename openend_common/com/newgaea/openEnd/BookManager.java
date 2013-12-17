package com.newgaea.openEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

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
			while(br!=null)
			{
				books.add(line);
				line=br.readLine();
			}
			OpenEndMod.logger.info(temp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
