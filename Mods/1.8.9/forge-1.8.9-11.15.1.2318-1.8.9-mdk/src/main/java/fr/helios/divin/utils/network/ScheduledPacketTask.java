package fr.helios.divin.utils.network;

import fr.helios.divin.DivinCommon;
import fr.helios.divin.ModDivin;
import fr.helios.divin.utils.network.packet.PacketCapabilitiesDivin;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ScheduledPacketTask implements Runnable
{
    
    private EntityPlayer player;
    private PacketCapabilitiesDivin message;
    
    public ScheduledPacketTask(EntityPlayer player, PacketCapabilitiesDivin message)
    {
        this.player = player;
        this.message = message;
    }

    @Override
    public void run()
    {
        EntityPlayer player = this.player == null ? getPlayer() : this.player;
        player.getCapability(ModDivin.DIVIN_CAP, null).setMoney(message.money);
    }
    
    @SideOnly(Side.CLIENT)
    private EntityPlayer getPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }

}
