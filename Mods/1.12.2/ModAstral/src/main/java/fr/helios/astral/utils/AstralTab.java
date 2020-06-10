package fr.helios.astral.utils;

import fr.helios.astral.items.AstralItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AstralTab extends CreativeTabs
{

    public AstralTab(String label)
    {
        super(label);
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(AstralItems.ecrin_centaure);
    }

}
