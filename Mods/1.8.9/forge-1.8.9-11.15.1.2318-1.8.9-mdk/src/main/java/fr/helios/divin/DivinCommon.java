package fr.helios.divin;

import java.io.File;
import java.net.NetworkInterface;

import com.oracle.jrockit.jfr.EventDefinition;

import fr.helios.divin.blocks.DivinBlocks;
import fr.helios.divin.blocks.MagicalSteamBlock;
import fr.helios.divin.items.DivinItems;
import fr.helios.divin.utils.event.EventHandler;
import fr.helios.divin.utils.network.DivinCapabilities;
import fr.helios.divin.utils.network.packet.MyMessage;
import fr.helios.divin.utils.network.packet.PacketCapabilitiesDivin;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class DivinCommon
{
    public static SimpleNetworkWrapper network;
    
    public void preInit(File configFile)
    {
        DivinBlocks.registerBlock();
        DivinItems.registerItems();
        network = NetworkRegistry.INSTANCE.newSimpleChannel("divinPacketChannel");
        network.registerMessage(MyMessage.Handler.class, MyMessage.class, 0, Side.SERVER);
        network.registerMessage(PacketCapabilitiesDivin.ClientHandler.class, PacketCapabilitiesDivin.class, 1, Side.CLIENT);
        network.registerMessage(PacketCapabilitiesDivin.ServerHandler.class, PacketCapabilitiesDivin.class, 1, Side.SERVER);
        //FMLCommonHandler.instance().bus().register(new EventHandler());
    }
    
    public void init()
    {
        DivinCapabilities.register();
    }
}
