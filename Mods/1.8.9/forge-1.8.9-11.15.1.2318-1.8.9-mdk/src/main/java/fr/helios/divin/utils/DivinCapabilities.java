/*package fr.helios.divin.utils;

import java.util.concurrent.Callable;

import fr.helios.divin.ModDivin;
import fr.helios.divin.utils.event.PacketCapabilitiesDivin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class DivinCapabilities implements ICapabilityProvider, INBTSerializable<NBTTagCompound>
{
    public int money;

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }
    
    @SubscribeEvent
    public void onPlayerCloned(PlayerEvent.Clone event)
    {
        if(event.wasDeath)
        {
            if(event.original.hasCapability(ModDivin.DIVIN_CAP, null))
            {
                DivinCapabilities cap = event.original.getCapability(ModDivin.DIVIN_CAP, null);
                DivinCapabilities newCap = event.entityPlayer.getCapability(ModDivin.DIVIN_CAP, null);
                newCap.setMoney(cap.getMoney());
            }
        }
    }
    
    @SubscribeEvent
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        if(!event.player.worldObj.isRemote)
        {
            event.player.getCapability(ModDivin.DIVIN_CAP, null).sync();
        }
    }
    
    @SubscribeEvent
    public void onAttachCapability(AttachCapabilitiesEvent.Entity event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            event.addCapability(new ResourceLocation(ModDivin.MODID + ":DIVIN_CAP"), new DivinCapabilities((EntityPlayer) event.getEntity()));
        }
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("Money", this.getMoney());
        
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound)
    {
        this.setMoney(compound.getInteger("Money"));
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return ModDivin.DIVIN_CAP != null && capability == ModDivin.DIVIN_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return ModDivin.DIVIN_CAP != null && capability == ModDivin.DIVIN_CAP ? (T)this : null;
    }
    
    public static class Storage implements Capability.IStorage<DivinCapabilities> {
        
        @Override
        public NBTBase writeNBT(Capability<DivinCapabilities> capability, DivinCapabilities instance, EnumFacing side)
        {
            return null;
        }
     
        @Override
        public void readNBT(Capability<DivinCapabilities> capability, DivinCapabilities instance, EnumFacing side, NBTBase nbt)
        {
     
        }
     
    }
     
    public static class Factory implements Callable<DivinCapabilities> {
        @Override
        public DivinCapabilities call() throws Exception
        {
            return null;
        }
    }
    
    private EntityPlayer player;
    
    public static void register()
    {
        CapabilityManager.INSTANCE.register(DivinCapabilities.class, new DivinCapabilities.Storage(), new DivinCapabilities.Factory());
    }
    
    public DivinCapabilities(EntityPlayer player)
    {
        this.money = 0;
        this.player = player;
    }
    
    public void sync()
    {
        PacketCapabilitiesDivin packet = new PacketCapabilitiesDivin(this.getMoney());
        
        if(!this.player.worldObj.isRemote)
        {
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            ModDivin.network.sendTo(packet, playerMP);
        }
        else
        {
            ModDivin.network.sendToServer(packet);
        }
    }

}*/
