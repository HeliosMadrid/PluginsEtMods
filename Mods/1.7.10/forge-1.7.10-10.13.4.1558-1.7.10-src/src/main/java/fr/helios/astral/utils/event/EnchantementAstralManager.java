package fr.helios.astral.utils.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantementAstralManager
{
    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) 
    {
        if (event.source.getEntity() instanceof EntityLivingBase) 
        {
            EntityLivingBase entity = (EntityLivingBase) event.source.getEntity();
            if (entity.getHeldItem() != null) 
            {
                if (hasEnchantment(entity.getHeldItem(), 120)) 
                {
                    event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 300, 0));
                }
            }
        }
    }
    
    public boolean hasEnchantment(ItemStack stack, int id)
    {
        boolean flag = false;
        if(stack.getEnchantmentTagList() != null)
        {
            for(int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++)
            {
                if(stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id)
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
            }
        }
        return flag;
    }

}
