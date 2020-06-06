package fr.helios.astral.client.item;

import fr.helios.astral.References;
import fr.helios.astral.client.item.items.CelestialCrystal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = References.MODID)
public class ItemsAstral
{
    public static final Item celestial_crystal = new CelestialCrystal();
    
    public static void setItemName(Item item, String name)
    {
        item.setRegistryName(References.MODID, References.MODID + "." + name);
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event)
    {
        registerModel(celestial_crystal, (byte)0);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, byte metadata)
    {
        if(metadata < 0) metadata = 0;
        String resourceName = String.valueOf(item.getRegistryName()).substring(5).replace(".", ":");
        if(metadata > 0) resourceName += "_m" + String.valueOf(metadata);
        
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}
