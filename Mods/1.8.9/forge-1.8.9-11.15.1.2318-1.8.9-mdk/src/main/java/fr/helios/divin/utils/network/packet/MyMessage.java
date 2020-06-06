package fr.helios.divin.utils.network.packet;

import fr.helios.divin.DivinCommon;
import fr.helios.divin.ModDivin;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MyMessage implements IMessage
{
    private String text;
    
    public MyMessage() {}
    
    public MyMessage(String text)
    {
        this.text = text;
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
        text = ByteBufUtils.readUTF8String(buf);
    }
    
    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, text);
    }
    
    public static class Handler implements IMessageHandler <MyMessage, IMessage>
    {

        @Override
        public IMessage onMessage(MyMessage message, MessageContext ctx)
        {
            System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
            DivinCommon.network.sendToServer(new MyMessage("foorbar"));
            return null;
        }
        
    }
}
