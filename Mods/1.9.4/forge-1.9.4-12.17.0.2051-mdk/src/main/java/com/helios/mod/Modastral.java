package com.helios.mod;

import com.helios.mod.blocks.BlockMod;
import com.helios.mod.init.BlocksMod;
import com.helios.mod.init.CraftsMod;
import com.helios.mod.init.ItemsMod;
import com.helios.mod.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.MOD_NAME, version = References.VERSION)

public class Modastral
{
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY, modId = References.MODID)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlocksMod.init();
        BlocksMod.register();
        ItemsMod.init();
        ItemsMod.register();
        CraftsMod.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       proxy.registerRenders();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
