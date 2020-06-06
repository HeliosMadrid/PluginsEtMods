package com.helios.mod.items;

import com.helios.mod.References;
import com.helios.mod.init.ItemsMod;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorASTRAL extends ItemArmor
{

    public ItemArmorASTRAL(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, 0, equipmentSlotIn);
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        if(this == ItemsMod.jambieresLune)
        {
            return References.MODID + ":textures/models/armor/armurLune_layer_2.png";
        }
        
        else if(this == ItemsMod.casqueLune || this == ItemsMod.plastronLune || this == ItemsMod.botesLune)
        {
            return References.MODID + ":textures/models/armor/armurlune_layer_1.png";
        }
        
        return null;
    }

}
