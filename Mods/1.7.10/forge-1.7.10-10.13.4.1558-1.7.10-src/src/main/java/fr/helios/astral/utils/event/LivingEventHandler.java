package fr.helios.astral.utils.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.helios.astral.ModAstral;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class LivingEventHandler
{
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {
        ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
        ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
        ItemStack chestPlate = event.entityLiving.getEquipmentInSlot(3);
        ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
        
        if(boots != null && boots.getItem() == ModAstral.boots_astral && leggings != null && leggings.getItem() == ModAstral.leggings_astral && chestPlate != null && chestPlate.getItem() == ModAstral.chestpalte_astral && helmet != null && helmet.getItem() == ModAstral.helmet_astral)
        {
            boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
            leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving); 
            chestPlate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
            helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving); 
            event.ammount = 0F; 
        }
        
        if(event.source.getDamageType().equals("anvil"))
        {
            event.entityLiving.worldObj.newExplosion(event.entityLiving, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.ammount, true, true);
        }
    }
    
    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event)
    {
        ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
        if(boots != null && boots.getItem() == ModAstral.boots_astral)
        {
            boots.damageItem(MathHelper.floor_float(event.distance), event.entityLiving);
            event.distance = 0F;
            
            if(boots.stackSize == 0)
            {
                event.entityLiving.setCurrentItemOrArmor(1, null);
            }
        }
    }
}
