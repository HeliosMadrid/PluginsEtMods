package fr.helios.astral;

import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

import org.apache.logging.log4j.Logger;

import fr.helios.astral.client.blocks.AstralBlocks;
import fr.helios.astral.client.items.AstralItems;
import fr.helios.astral.client.items.ItemAstral;
import fr.helios.astral.common.AstralCommon;
import fr.helios.astral.common.event.RegisteringHandler;
import fr.helios.astral.common.util.PermissionHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import scala.actors.remote.Proxy;

@Mod(modid = References.MODID, name = References.NAME, acceptedMinecraftVersions = References.MINECRAFT_VERSION)
public class ModAstral
{
    public ModAstral()
    {
        MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
    }
    
    @Instance(References.MODID)
    public static ModAstral instance;
    
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static AstralCommon proxy;
    
    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        //MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
        //PermissionAPI.setPermissionHandler(new PermissionHandler());
        //PermissionAPI.registerNode("astral.items.laser", DefaultPermissionLevel.OP, "Donne accès au god mod grace a ma bite");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
        GameRegistry.addRecipe(new ItemStack(Items.ENCHANTED_BOOK), new Object[]
                {
                    "XXX",
                    "ZYZ",
                    "XXX",
                    "X", Items.NETHER_STAR,
                    "Y", Blocks.DIAMOND_BLOCK,
                    "Z", new ItemStack(Items.DYE, 1, 6)
                });
        GameRegistry.addSmelting(new ItemStack(Blocks.DIRT), new ItemStack(Items.NETHER_STAR), 9999999999999999L);
        BrewingRecipeRegistry.addRecipe(new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.NETHER_STAR), new ItemStack(Blocks.DIRT));
    }
    
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event)
    {
        
    }
}
