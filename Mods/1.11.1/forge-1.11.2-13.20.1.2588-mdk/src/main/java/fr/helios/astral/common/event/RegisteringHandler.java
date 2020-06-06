package fr.helios.astral.common.event;

import fr.helios.astral.References;
import fr.helios.astral.client.blocks.AstralBlocks;
import fr.helios.astral.client.items.AstralItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class RegisteringHandler
{
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //event.getRegistry().registerAll(AstralBlocks.escalier_de_lumiere);
        //event.getRegistry().registerAll(AstralBlocks.escalier_de_lumiere);
    }
    
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(AstralItems.astral_wand);
    }
    
    @EventBusSubscriber(modid = References.MODID)
    public class EventHandlerCommon
    {
        /*
            * Affiche un message de bienvenue au joueur lorsqu'il rejoint la partie
            */
        @SubscribeEvent
        public void onPlayerLoggedIn(PlayerLoggedInEvent event)
        {
            event.player.sendMessage(new TextComponentString("Bienvenue " + event.player.getDisplayNameString() + " sur la partie"));
        }
    }
}
