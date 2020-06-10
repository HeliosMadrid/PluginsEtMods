package fr.helios.astral;

import org.apache.logging.log4j.Logger;

import fr.helios.astral.events.RegisteringEvent;
import fr.helios.astral.proxy.CommonProxy;
import fr.helios.astral.utils.AstralTab;
import fr.helios.astral.utils.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.MINECRAFT_VERSION)
public class AstralMod
{
    @Instance(References.MODID)
    public static AstralMod instance;
    
    @SidedProxy(modId = References.MODID, clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;
    
    public static final CreativeTabs ASTRAL_TAB = new AstralTab("astral_tab");
    
    public AstralMod()
    {
        MinecraftForge.EVENT_BUS.register(new RegisteringEvent());
    }
    
    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event.getSuggestedConfigurationFile());
        logger = event.getModLog();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
