package fr.helios.astral.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockAstral extends BlockFalling
{

    public BlockAstral(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        slipperiness = 2F;
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
        entity.motionY += 10.0F;
    }

}
