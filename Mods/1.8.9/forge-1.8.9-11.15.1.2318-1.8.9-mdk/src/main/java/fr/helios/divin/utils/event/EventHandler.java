package fr.helios.divin.utils.event;

import fr.helios.divin.ModDivin;
import fr.helios.divin.utils.network.DivinCapabilities;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class EventHandler
{
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
    
    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event)
    {
        if(event.entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            Item item = Items.skull;
            ItemStack stack = new ItemStack(item, 1, 3);
            
            NBTTagCompound compound = new NBTTagCompound();
            NBTTagCompound compound1 = new NBTTagCompound();
            
            stack.writeToNBT(compound);
            compound1.setString("SkullOwner", player.getName());  
            ((ItemSkull)item).updateItemStackNBT(compound1);
            compound.setTag("tag", compound1);
            stack.readFromNBT(compound);
            player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, stack));
        }
    }
}
