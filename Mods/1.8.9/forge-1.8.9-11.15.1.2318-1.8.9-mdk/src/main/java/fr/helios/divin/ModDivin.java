package fr.helios.divin;

import java.net.NetworkInterface;
import java.nio.channels.NetworkChannel;

import org.apache.logging.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import fr.helios.divin.blocks.AstralMechaHeartBlock;
import fr.helios.divin.blocks.MagicalSteamBlock;
import fr.helios.divin.entity.tile.TileEntityDivin;
import fr.helios.divin.entity.tile.TileEntityDivinSpecialRender;
import fr.helios.divin.utils.network.DivinCapabilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "divin", name = "Mod Divin", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class ModDivin
{    
    
    
    @CapabilityInject(DivinCapabilities.class)
    public static final Capability<DivinCapabilities> DIVIN_CAP = null;
    
    public static final String MODID = "divin";
    public static boolean zoom;
    public static SimpleNetworkWrapper network;
    //network.registerMessage(PacketCapabilitiesDivin.ClientHandler.class, PacketCapabilitiesDivin.class, 3, Side.CLIENT);
   //network.registerMessage(PacketCapabilitiesDivin.ServerHandler.class, PacketCapabilitiesDivin.class, 3, Side.SERVER);
    
    @Instance(ModDivin.MODID)
    public static ModDivin instance;
    
    public static Logger logger;
    
    public static Block magicalSteam;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
       // DivinCapabilities.register();
        /*GameRegistry.registerTileEntity(TileEntityDivin.class, "tileEntityDivin");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDivin.class, new TileEntityDivinSpecialRender());*/
    }
    
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
    
    @SidedProxy(clientSide = "fr.helios.divin.proxy.DivinClient", serverSide = "fr.helios.divin.proxy.DivinServer")
    public static DivinCommon proxy;
}
