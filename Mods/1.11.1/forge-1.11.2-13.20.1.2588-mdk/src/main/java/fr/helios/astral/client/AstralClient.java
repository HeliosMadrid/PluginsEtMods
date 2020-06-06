package fr.helios.astral.client;

import java.io.File;

import fr.helios.astral.client.items.AstralItems;
//import fr.helios.astral.client.util.GuiCustomMainMenu;
import fr.helios.astral.common.AstralCommon;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AstralClient extends AstralCommon
{
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        AstralItems.registerItemsModels();
    }
    
    @Override
    public void init()
    {
        super.init();
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @Override
    public void postInit()
    {
        super.postInit();
    }
    
   /* @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event)
    {
        if(event.getGui().getClass() == GuiMainMenu.class)
        {
            event.setGui(new GuiCustomMainMenu());
        }
    }*/
}
