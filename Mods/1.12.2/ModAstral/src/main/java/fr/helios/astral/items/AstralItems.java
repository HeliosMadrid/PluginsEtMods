package fr.helios.astral.items;

import java.util.List;

import com.google.common.collect.Lists;

import fr.helios.astral.items.list.EcrinCentaure;
import fr.helios.astral.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = References.MODID)
public class AstralItems
{
    public static final AstralItems INSTANCE = new AstralItems();
    
    public static final Item ecrin_centaure = new EcrinCentaure("ecrin_centaure");
    
    public List<Item> items = Lists.newArrayList();
    
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        for(Item item : items)
        {
            registerModel(item, (byte) 0);
        }
    }
    
    private void registerModel(Item item, byte metadata)
    {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getTranslationKey().substring(5)), "inventory"));
    }
    
    public List<Item> getItems()
    {
        return items;
    }
}
