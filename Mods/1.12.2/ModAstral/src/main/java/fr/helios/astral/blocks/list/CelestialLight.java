package fr.helios.astral.blocks.list;

import fr.helios.astral.blocks.AstralBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CelestialLight extends Block
{

    public CelestialLight(String name, Material material)
    {
        super(material);
        setRegistryName(name);
        setLightLevel(10.0F);
        setTranslationKey(name);
        setHardness(10.0F);
        setResistance(999999.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        
        AstralBlocks.INSTANCE.getBlocks().add(this);
    }

}
