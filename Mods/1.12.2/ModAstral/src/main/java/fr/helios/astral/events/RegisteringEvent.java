package fr.helios.astral.events;

import fr.helios.astral.items.AstralItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringEvent
{
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(AstralItems.INSTANCE.getItems().toArray(new Item[0]));
    }
}
