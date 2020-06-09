package fr.helios.astral.items.list;

import fr.helios.astral.items.AstralItems;
import fr.helios.astral.utils.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GemmesItem extends Item
{
    public GemmesItem(String name)
    {
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);
        setMaxStackSize(64);
        
        AstralItems.INSTANCE.getItems().add(this);
    }
}
