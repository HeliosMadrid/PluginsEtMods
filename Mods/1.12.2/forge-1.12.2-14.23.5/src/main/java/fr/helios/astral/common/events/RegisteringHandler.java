package fr.helios.astral.common.events;

import fr.helios.astral.client.item.ItemsAstral;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringHandler
{
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemsAstral.celestial_crystal);
    }
}
