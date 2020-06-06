package fr.helios.dragon.init;

import fr.helios.dragon.References;
import fr.helios.dragon.items.ItemMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod 
{   
	public static Item lingot_de_dragonite;
	public static Item minerai_de_dragonite;
	
	public static void init()
	{
		lingot_de_dragonite = new ItemMod("lingot_de_dragonite");
		minerai_de_dragonite = new ItemMod("minerai_de_dragonite");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(lingot_de_dragonite, minerai_de_dragonite);
		

	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(lingot_de_dragonite);
		registerRender(minerai_de_dragonite);
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
