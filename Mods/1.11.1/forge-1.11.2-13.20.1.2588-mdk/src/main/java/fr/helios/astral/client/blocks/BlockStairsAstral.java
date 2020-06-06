package fr.helios.astral.client.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStairsAstral extends BlockStairs
{
    
    public static final String NAME = "escalier_de_lumiere";

    public BlockStairsAstral(IBlockState modelState)
    {
        super(modelState);
        
        AstralBlocks.setBlockName(this, NAME);
        setResistance(5F);
        setHardness(5F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
