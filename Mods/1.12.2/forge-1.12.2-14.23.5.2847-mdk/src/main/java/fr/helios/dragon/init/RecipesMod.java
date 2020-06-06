package fr.helios.dragon.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesMod 
{
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(ItemsMod.minerai_de_dragonite), new ItemStack(ItemsMod.lingot_de_dragonite), 100.5F);
	}
}
