package fr.helios.divin.utils.event;


import java.lang.reflect.Field;

import fr.helios.divin.DivinCommon;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S47PacketPlayerListHeaderFooter;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EventServerHandler
{
    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerLoggedInEvent event)
    {
        try
        {
            Packet packet = new S47PacketPlayerListHeaderFooter();
            Field fi1 = packet.getClass().getDeclaredFields()[0];
            fi1.setAccessible(true);
            ChatComponentText compH = new ChatComponentText("DivinHeader");
            fi1.set(packet, compH);
            fi1.setAccessible(false);
            Field fi2 = packet.getClass().getDeclaredFields()[1];
            fi2.setAccessible(true);
            ChatComponentText compF = new ChatComponentText("DivinFooter");
            fi2.set(packet, compF);
            fi2.setAccessible(false);
            
            DivinCommon.network.sendToServer((IMessage)packet);
        }
        catch(Exception e)
        {
            System.out.println("Error sending packet tab" + e);
        }
    }
}
