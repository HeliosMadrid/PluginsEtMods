package fr.helios.astral.blocks;

import java.util.Random;

import fr.helios.astral.ModAstral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockOreAstral extends Block
{

    public BlockOreAstral(Material material)
    {
        super(material);
        this.setCreativeTab(ModAstral.astralCreativeTab);
    }
    
    public int quantityDropped(Random rand)
    {
        return 1 + rand.nextInt(2);
    }
  
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        if(metadata == 0)
        {
            return ModAstral.gemmes;     
        }
        return ModAstral.gemmes;
    }

}
