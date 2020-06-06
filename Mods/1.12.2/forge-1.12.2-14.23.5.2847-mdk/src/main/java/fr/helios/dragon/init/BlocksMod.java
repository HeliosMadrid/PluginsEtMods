package fr.helios.dragon.init;

import fr.helios.dragon.References;
import fr.helios.dragon.blocks.BlockMod;
import fr.helios.dragon.blocks.BlockOreMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod 
{
	public static Block dragonite, block_ore;
	
	public static void init()
	{
		dragonite = new BlockMod("dragonite", Material.ROCK);
		block_ore = new BlockOreMod("block_ore", 3, 1, 8);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(dragonite, block_ore);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				new ItemBlock(dragonite).setRegistryName(dragonite.getRegistryName()),
				new ItemBlock(block_ore).setRegistryName(block_ore.getRegistryName())
				);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(dragonite));
		registerRender(Item.getItemFromBlock(block_ore));
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
