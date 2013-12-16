package com.newgaea.openEnd.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureEndVillagePieces
{
    public static void func_143016_a()
    {
        MapGenStructureIO.func_143031_a(ComponentEndVillageHouse1.class, "ViBH");
        MapGenStructureIO.func_143031_a(ComponentEndVillageField.class, "ViDF");
        MapGenStructureIO.func_143031_a(ComponentEndVillageField2.class, "ViF");
        MapGenStructureIO.func_143031_a(ComponentEndVillageTorch.class, "ViL");
        MapGenStructureIO.func_143031_a(ComponentEndVillageHall.class, "ViPH");
        MapGenStructureIO.func_143031_a(ComponentEndVillageHouse4_Garden.class, "ViSH");
        MapGenStructureIO.func_143031_a(ComponentEndVillageWoodHut.class, "ViSmH");
        MapGenStructureIO.func_143031_a(ComponentEndVillageChurch.class, "ViST");
        MapGenStructureIO.func_143031_a(ComponentEndVillageHouse2.class, "ViS");
        MapGenStructureIO.func_143031_a(ComponentEndVillageStartPiece.class, "ViStart");
        MapGenStructureIO.func_143031_a(ComponentEndVillagePathGen.class, "ViSR");
        MapGenStructureIO.func_143031_a(ComponentEndVillageHouse3.class, "ViTRH");
        MapGenStructureIO.func_143031_a(ComponentEndVillageWell.class, "ViW");
        MapGenStructureIO.func_143031_a(ComponentEndVillageChurchDark.class, "ViSTC");
        MapGenStructureIO.func_143031_a(ComponentEndVillageSpire.class, "ViSpi");
    }

    @SuppressWarnings("unchecked")
	public static List getStructureVillageWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageHouse4_Garden.class, 4, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageChurch.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 1 + par1)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageHouse1.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageWoodHut.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageHall.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageField.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 1 + par1, 4 + par1)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageField2.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageHouse2.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0, 1 + par1)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageHouse3.class, 8, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 3 + par1 * 2)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageChurchDark.class, 1, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 3 + par1 * 2)));
        arraylist.add(new StructureEndVillagePieceWeight(ComponentEndVillageSpire.class, 1, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 3 + par1 * 2)));

        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            if (((StructureEndVillagePieceWeight)iterator.next()).villagePiecesLimit == 0)
            {
                iterator.remove();
            }
        }

        return arraylist;
    }

    private static int func_75079_a(List par0List)
    {
        boolean flag = false;
        int i = 0;
        StructureEndVillagePieceWeight structurevillagepieceweight;

        for (Iterator iterator = par0List.iterator(); iterator.hasNext(); i += structurevillagepieceweight.villagePieceWeight)
        {
            structurevillagepieceweight = (StructureEndVillagePieceWeight)iterator.next();

            if (structurevillagepieceweight.villagePiecesLimit > 0 && structurevillagepieceweight.villagePiecesSpawned < structurevillagepieceweight.villagePiecesLimit)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }

    private static ComponentEndVillage func_75083_a(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, StructureEndVillagePieceWeight par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8)
    {
        Class oclass = par1StructureVillagePieceWeight.villagePieceClass;
        Object object = null;

        if (oclass == ComponentEndVillageHouse4_Garden.class)
        {
            object = ComponentEndVillageHouse4_Garden.func_74912_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageChurch.class)
        {
            object = ComponentEndVillageChurch.func_74919_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageHouse1.class)
        {
            object = ComponentEndVillageHouse1.func_74898_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageWoodHut.class)
        {
            object = ComponentEndVillageWoodHut.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageHall.class)
        {
            object = ComponentEndVillageHall.func_74906_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageField.class)
        {
            object = ComponentEndVillageField.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageField2.class)
        {
            object = ComponentEndVillageField2.func_74902_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageHouse2.class)
        {
            object = ComponentEndVillageHouse2.func_74915_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentEndVillageHouse3.class)
        {
            object = ComponentEndVillageHouse3.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if(oclass== ComponentEndVillageChurchDark.class)
        {
        	object=ComponentEndVillageChurchDark.func_74919_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if(oclass== ComponentEndVillageSpire.class)
        {
        	object=ComponentEndVillageSpire.func_74919_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        return (ComponentEndVillage)object;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static ComponentEndVillage getNextVillageComponent(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        int j1 = func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

        if (j1 <= 0)
        {
            return null;
        }
        else
        {
            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int l1 = par2Random.nextInt(j1);
                Iterator iterator = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

                while (iterator.hasNext())
                {
                    StructureEndVillagePieceWeight structurevillagepieceweight = (StructureEndVillagePieceWeight)iterator.next();
                    l1 -= structurevillagepieceweight.villagePieceWeight;

                    if (l1 < 0)
                    {
                        if (!structurevillagepieceweight.canSpawnMoreVillagePiecesOfType(par7) || structurevillagepieceweight == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        ComponentEndVillage componentvillage = func_75083_a(par0ComponentVillageStartPiece, structurevillagepieceweight, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (componentvillage != null)
                        {
                            ++structurevillagepieceweight.villagePiecesSpawned;
                            par0ComponentVillageStartPiece.structVillagePieceWeight = structurevillagepieceweight;

                            if (!structurevillagepieceweight.canSpawnMoreVillagePieces())
                            {
                                par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(structurevillagepieceweight);
                            }

                            return componentvillage;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = ComponentEndVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (structureboundingbox != null)
            {
                return new ComponentEndVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            ComponentEndVillage componentvillage = getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (componentvillage != null)
            {
                int j1 = (componentvillage.getBoundingBox().minX + componentvillage.getBoundingBox().maxX) / 2;
                int k1 = (componentvillage.getBoundingBox().minZ + componentvillage.getBoundingBox().maxZ) / 2;
                int l1 = componentvillage.getBoundingBox().maxX - componentvillage.getBoundingBox().minX;
                int i2 = componentvillage.getBoundingBox().maxZ - componentvillage.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenEndVillage.villageSpawnBiomes))
                {
                    par1List.add(componentvillage);
                    par0ComponentVillageStartPiece.field_74932_i.add(componentvillage);
                    return componentvillage;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent getNextComponentVillagePath(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentVillageStartPiece.terrainType)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox structureboundingbox = ComponentEndVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (structureboundingbox != null && structureboundingbox.minY > 10)
            {
                ComponentEndVillagePathGen componentvillagepathgen = new ComponentEndVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
                int j1 = (componentvillagepathgen.getBoundingBox().minX + componentvillagepathgen.getBoundingBox().maxX) / 2;
                int k1 = (componentvillagepathgen.getBoundingBox().minZ + componentvillagepathgen.getBoundingBox().maxZ) / 2;
                int l1 = componentvillagepathgen.getBoundingBox().maxX - componentvillagepathgen.getBoundingBox().minX;
                int i2 = componentvillagepathgen.getBoundingBox().maxZ - componentvillagepathgen.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenEndVillage.villageSpawnBiomes))
                {
                    par1List.add(componentvillagepathgen);
                    par0ComponentVillageStartPiece.field_74930_j.add(componentvillagepathgen);
                    return componentvillagepathgen;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponent(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentVillagePath(ComponentEndVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
