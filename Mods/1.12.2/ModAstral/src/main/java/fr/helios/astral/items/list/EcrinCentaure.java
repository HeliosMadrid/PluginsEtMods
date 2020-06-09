package fr.helios.astral.items.list;

import fr.helios.astral.items.AstralItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EcrinCentaure extends Item
{

    public EcrinCentaure(String name)
    {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);
        setMaxStackSize(32);
        
        AstralItems.INSTANCE.getItems().add(this);
    }
    
}
