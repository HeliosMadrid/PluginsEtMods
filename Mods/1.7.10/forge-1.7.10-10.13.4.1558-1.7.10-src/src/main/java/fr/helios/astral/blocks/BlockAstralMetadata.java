package fr.helios.astral.blocks;

import java.util.List;


import fr.helios.astral.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockAstralMetadata extends Block
{
    public static String[] subBlock = new String[]{"lumiere1", "lumiere2", "lumiere3", "lumiere4"};
    public IIcon[] iconArray = new IIcon[subBlock.length];
    public BlockAstralMetadata()
    {
        super(Material.rock);
    }
    
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            list.add(new ItemStack(item, 1, i));        
        }
    }
    
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
        this.iconArray[i] = iconRegister.registerIcon(References.MODID + ":" +subBlock[i]);
        }
    }
    
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata >= 0 && metadata < subBlock.length)
        {
        return this.iconArray[metadata];
        }
        return this.iconArray[0];
    } 
    
    public int damageDropped(int metadata)
    {
        return metadata;
    }

}
