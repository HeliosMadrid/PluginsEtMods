package fr.helios.divin.proxy;

import java.io.File;

import fr.helios.divin.DivinCommon;
import fr.helios.divin.ModDivin;
import fr.helios.divin.blocks.DivinBlocks;
import fr.helios.divin.blocks.MagicalSteamBlock;
import fr.helios.divin.entity.tile.TileEntityInventoryRenderHelper;
import fr.helios.divin.items.DivinItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class DivinClient extends DivinCommon
{
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        DivinBlocks.registerItemFromBlock();
        DivinItems.registerItemsModels();
        //FMLCommonHandler.instance().bus().register(new TickClientHandlerEvent());
        //MinecraftForge.EVENT_BUS.register(new TickClientHandlerEvent());
    }

    @Override
    public void init()
    {
        super.init();
        TileEntityItemStackRenderer.instance = new TileEntityInventoryRenderHelper();
    }

}
