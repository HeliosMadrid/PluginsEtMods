package fr.helios.divin.items;

import fr.helios.divin.ModDivin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class Gemmes extends Item
{
    
    public Gemmes()
    {
        super();
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if(!world.isRemote)
        {
        player.addChatMessage(new ChatComponentTranslation("item.gemmes.click.message", player.getDisplayNameString(), player.getPosition()));
        }
        player.addPotionEffect(new PotionEffect(20, 99));
        player.motionX -= 10;
        player.motionZ -= 10;
        player.capabilities.allowFlying = true;

        return stack;
    }
}
