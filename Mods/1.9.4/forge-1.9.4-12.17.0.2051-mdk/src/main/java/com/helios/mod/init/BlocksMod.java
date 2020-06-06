package com.helios.mod.init;

import com.helios.mod.References;
import com.helios.mod.blocks.BlockMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksMod
{
    public static Block lumiereLunaire;
    
    public static void init()
    {
        lumiereLunaire = new BlockMod(Material.ROCK).setUnlocalizedName("lumiereLunaire").setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    public static void register()
    {
        GameRegistry.registerBlock(lumiereLunaire, lumiereLunaire.getUnlocalizedName().substring(5));
    }
    
    public static void registerRenders()
    {
        registerRender(lumiereLunaire);
    }
    
    private static void registerRender(Block block)
    {
        
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
