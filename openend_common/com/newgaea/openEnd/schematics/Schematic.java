package com.newgaea.openEnd.schematics;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Schematic {

	private short width;
	public short getWidth() {
		return width;
	}
	public void setWidth(short width) {
		this.width = width;
	}
	public short getHeight() {
		return height;
	}
	public void setHeight(short height) {
		this.height = height;
	}
	public short getLength() {
		return length;
	}
	public void setLength(short length) {
		this.length = length;
	}
	public Materials getMaterials() {
		return materials;
	}
	public void setMaterials(Materials materials) {
		this.materials = materials;
	}
	public byte[] getRawBlocks() {
		return rawBlocks;
	}
	public void setRawBlocks(byte[] rawBlocks) {
		this.rawBlocks = rawBlocks;
	}
	public byte[] getBlockData() {
		return blockData;
	}
	public void setBlockData(byte[] blockData) {
		this.blockData = blockData;
	}
	public byte[] getAddBlockId() {
		return addBlockId;
	}
	public void setAddBlockId(byte[] addBlockId) {
		this.addBlockId = addBlockId;
	}
	public short[] getBlocks() {
		return blocks;
	}
	public void setBlocks(short[] blocks) {
		this.blocks = blocks;
	}
	private short height;
	private short length;
	
	public enum Materials
	{
		Classic,
		Alpha,
	};
	private Materials materials;
	private byte[] rawBlocks;
	private byte[] blockData;
	private byte[] addBlockId;
	short[] blocks;
	
	
	private List<Entity> entities;
	public List<Entity> getEntities() {
		return entities;
	}
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	public List<TileEntity> getTileEntities() {
		return tileEntities;
	}
	public void setTileEntities(List<TileEntity> tileEntities) {
		this.tileEntities = tileEntities;
	}
	private List<TileEntity> tileEntities;
	public Schematic()
	{
		entities=new LinkedList<Entity>();
		tileEntities=new LinkedList<TileEntity>();
	}
	
	
	public static Schematic loadSchematic(NBTTagCompound nbtSchematic,World world)
	{
		Schematic schematic=new Schematic();
		schematic.setHeight(nbtSchematic.getShort("Height"));
		schematic.setWidth(nbtSchematic.getShort("Width"));
		schematic.setLength(nbtSchematic.getShort("Length"));
		schematic.setMaterials(Materials.valueOf(nbtSchematic.getString("Materials")));
		schematic.setRawBlocks(nbtSchematic.getByteArray("Blocks"));
		if(nbtSchematic.hasKey("AddBlocks"))
		{
			schematic.setAddBlockId(nbtSchematic.getByteArray("AddBlocks"));
		}
		schematic.blocks=new short[schematic.getRawBlocks().length];
		if(schematic.getAddBlockId()==null)
			schematic.setAddBlockId(new byte[0]);
		
		boolean extra=nbtSchematic.hasKey("Add") || nbtSchematic.hasKey("AddBlocks");
		byte extraBlocks[]=null;
		byte extraBlocksNibble[]=null;
		if(nbtSchematic.hasKey("AddBlocks"))
		{
			extraBlocksNibble=nbtSchematic.getByteArray("AddBlocks");
			extraBlocks=new byte[extraBlocksNibble.length*2];
			for(int i=0;i<extraBlocksNibble.length;i++)
			{
				extraBlocks[i*2+0]=(byte)((extraBlocksNibble[i]>>4) & 0xF);
				extraBlocks[i*2+1]=(byte)(extraBlocksNibble[i]&0xF);
			}
			
		}
		else if(nbtSchematic.hasKey("Add"))
		{
			extraBlocks=nbtSchematic.getByteArray("Add");
		}
		
		
		for(int i=0;i<schematic.rawBlocks.length;i++)
		{
			schematic.blocks[i]=(short)(schematic.rawBlocks[i]& 0xFF);
			if(extra)
				schematic.blocks[i]|=((extraBlocks[i]) & 0xFF) << 8;
		}
		
		schematic.setBlockData(nbtSchematic.getByteArray("Data"));
		List<Entity> ents=new LinkedList<Entity>();
		NBTTagList entities=nbtSchematic.getTagList("Entities");
		for(int i=0;i<entities.tagCount();i++)
		{
			NBTTagCompound entity=(NBTTagCompound) entities.tagAt(i);
			Entity entEntity=EntityList.createEntityFromNBT(entity, world);
			ents.add(entEntity);
		}
		schematic.setEntities(ents);
		
		List<TileEntity> tiles=new LinkedList<TileEntity>();
		NBTTagList tileEntities=nbtSchematic.getTagList("TileEntities");
		for(int i=0;i<tileEntities.tagCount();i++)
		{
			NBTTagCompound tile=(NBTTagCompound)tileEntities.tagAt(i);
			TileEntity tileEnt=TileEntity.createAndLoadEntity(tile);
			tiles.add(tileEnt);
		}
		schematic.setTileEntities(tiles);
		return schematic;
	}
	
	
}
