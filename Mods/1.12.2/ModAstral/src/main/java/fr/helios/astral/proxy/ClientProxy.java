package fr.helios.astral.proxy;

import java.io.File;

import fr.helios.astral.blocks.AstralBlocks;
import fr.helios.astral.events.RegisteringEvent;
import fr.helios.astral.items.AstralItems;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        
        MinecraftForge.EVENT_BUS.register(AstralItems.INSTANCE);
        MinecraftForge.EVENT_BUS.register(AstralBlocks.INSTANCE);
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void postInit()
    {
        super.postInit();
    }

}
