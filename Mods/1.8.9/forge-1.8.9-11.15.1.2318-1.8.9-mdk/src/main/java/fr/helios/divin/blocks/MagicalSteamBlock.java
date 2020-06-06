package fr.helios.divin.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicalSteamBlock extends Block
{

    public MagicalSteamBlock(Material material)
    {
        super(material);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        //Item[] drop = new Item[] {Item.getItemFromBlock(DivinBlocks.magicalSteam), Items.blaze_powder};
        
        return Item.getItemFromBlock(DivinBlocks.magicalSteam);
    }

}
