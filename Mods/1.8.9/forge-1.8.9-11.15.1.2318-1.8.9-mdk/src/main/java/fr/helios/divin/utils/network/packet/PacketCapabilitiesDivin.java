package fr.helios.divin.utils.network.packet;

import fr.helios.divin.utils.network.ScheduledPacketTask;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketCapabilitiesDivin implements IMessage
{

    public int money;  
    
    public long getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public PacketCapabilitiesDivin() {}
    
    public PacketCapabilitiesDivin(int money)
    {
        this.money = money;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        
    }
    
    public static class ServerHandler implements IMessageHandler <PacketCapabilitiesDivin, IMessage>
    {
        @Override
        public IMessage onMessage(PacketCapabilitiesDivin message, MessageContext ctx)
        {
            MinecraftServer.getServer().addScheduledTask(new ScheduledPacketTask(ctx.getServerHandler().playerEntity, message));
            return null;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static class ClientHandler implements IMessageHandler <PacketCapabilitiesDivin, IMessage>
    {
        @Override
        public IMessage onMessage(PacketCapabilitiesDivin message, MessageContext ctx)
        {
            Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(null, message));
            return null;
        }
    }
    
}
