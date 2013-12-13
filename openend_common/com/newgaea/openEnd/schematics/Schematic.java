package com.newgaea.openEnd.schematics;

import net.minecraft.nbt.NBTTagCompound;
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
	
	public Schematic loadSchematic(NBTTagCompound nbtSchematic,World world)
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
			}
		}
		
		
		return schematic;
	}
	
	
}
