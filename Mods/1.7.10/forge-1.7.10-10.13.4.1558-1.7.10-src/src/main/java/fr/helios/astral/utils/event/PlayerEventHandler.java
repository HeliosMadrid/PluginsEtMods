package fr.helios.astral.utils.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class PlayerEventHandler
{
    @SubscribeEvent
    public void onPlayerLogged(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
    {
        event.player.addChatMessage(new ChatComponentText("salut :" + event.player.getCommandSenderName()));
    }
    
    @SubscribeEvent
    public void onNameFormat(net.minecraftforge.event.entity.player.PlayerEvent.NameFormat event)
    {
        if(event.username.equals("Helios_38--password"))
        {
            event.entityPlayer.getEntityData().getString("team");
            event.displayname = "Staff MFF - Helios_38";
        }
    }
    
    @SubscribeEvent
    public void onItemFuck(ItemTooltipEvent event)
    {
        if(event.itemStack.getItem() == Items.bone)
        {
            event.toolTip.add("click droit sur ma bite pour la faire bander");
        }
        else if(event.itemStack.getItem() == Item.getItemFromBlock(Blocks.obsidian))
        {
            if(event.entityPlayer.isSneaking())
            {
                event.toolTip.add("resistance : 2000");
            }
            else 
            {
            event.toolTip.add("shift sur ma bite si tu t'appelle L*o*a*d");
            }
        }
    }
}