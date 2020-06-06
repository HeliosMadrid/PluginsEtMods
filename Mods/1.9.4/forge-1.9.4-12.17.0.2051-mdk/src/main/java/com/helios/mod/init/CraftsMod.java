package com.helios.mod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftsMod
{
    public static void init()
    {
        GameRegistry.addSmelting(BlocksMod.lumiereLunaire, new ItemStack(ItemsMod.fragementLunaire), 100.5F);
    }
    
}
