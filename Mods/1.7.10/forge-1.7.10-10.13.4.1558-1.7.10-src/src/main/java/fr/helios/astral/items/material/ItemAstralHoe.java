package fr.helios.astral.items.material;

import fr.helios.astral.ModAstral;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemAstralHoe extends ItemHoe
{

    public ItemAstralHoe(ToolMaterial material)
    {
        super(material);
    }
    
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == ModAstral.sword_astral && input.getItem() == ModAstral.sword_astral || repair.getItem() == ModAstral.shovel_astral && input.getItem() == ModAstral.shovel_astral || repair.getItem() == ModAstral.pickaxe_astral && input.getItem() == ModAstral.pickaxe_astral || repair.getItem() == ModAstral.axe_astral && input.getItem() == ModAstral.axe_astral || repair.getItem() == ModAstral.hoe_astral && input.getItem() == ModAstral.hoe_astral || repair.getItem() == ModAstral.luminous_wand)
        {
            return true;
        }
        return false;
    }

}
