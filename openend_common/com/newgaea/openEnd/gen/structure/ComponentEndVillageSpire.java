package com.newgaea.openEnd.gen.structure;

import java.util.List;
import java.util.Random;

import com.newgaea.openEnd.Configs;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentEndVillageSpire extends ComponentEndVillage {

	public ComponentEndVillageSpire() {}

    public ComponentEndVillageSpire(ComponentEndVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static ComponentEndVillageSpire func_74919_a(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 5, 12, 9, par6);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(par1List, structureboundingbox) == null ? new ComponentEndVillageSpire(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6) : null;
    }
	@Override
	public boolean addComponentParts(World par1World, Random par2Random,
			StructureBoundingBox par3StructureBoundingBox) {
		if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
        }
		
		int l = par2Random.nextInt(32) + 6;
        int i1 = par2Random.nextInt(4) + 1;
        int j1;
        int k1;
        int l1;
        int i2;
        for (j1 = 0; j1 < 0 + l && j1 < 128; ++j1)
        {
            for (k1 = 0 - i1; k1 <= 0 + i1; ++k1)
            {
                for (l1 = 0 - i1; l1 <= 0 + i1; ++l1)
                {
                    i2 = k1 - 0;
                    int j2 = l1 - 0;

                    if (i2 * i2 + j2 * j2 <= i1 * i1 + 1)
                    {
                        this.placeBlockAtCurrentPosition(par1World,Configs.AlabasterStoneId,0,k1,j1,l1,par3StructureBoundingBox);
                    }
                }
            }
        }
		
		
		
		
		return true;
		
	}

}
