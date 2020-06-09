package fr.helios.astral.blocks;

import java.util.List;

import com.google.common.collect.Lists;

import fr.helios.astral.blocks.list.CelestialLight;
import fr.helios.astral.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class AstralBlocks
{
    public static final AstralBlocks INSTANCE = new AstralBlocks();
    
    public static final Block celestial_light = new CelestialLight("celestial_light", Material.IRON);
    
    private List<Block> blocks = Lists.newArrayList();
    
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        for(Block block : blocks)
        {
            registerModel(block, (byte) 0);
        }
    }
    
    private void registerModel(Block block, byte metadata)
    {
        ItemBlock ib = new ItemBlock(block);
        ib.setRegistryName(block.getRegistryName());
        GameRegistry.findRegistry(Item.class).register(ib);
        
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), metadata, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getTranslationKey().substring(5)), "inventory"));
    }
    
    public List<Block> getBlocks()
    {
        return blocks;
    }
}
