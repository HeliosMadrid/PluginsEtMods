package fr.helios.astral.utils;

import fr.helios.astral.blocks.TileEntityAstral;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerAstres extends Container
{
    
    private final TileEntityAstral tileAstral;
    
    public ContainerAstres(TileEntityAstral tile, InventoryPlayer inventory)
    {
        this.tileAstral = tile;
        tile.openInventory();
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(tile, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }
        this.bindPlayerInventory(inventory);
    }
    
    public TileEntityAstral getTileAstral()
    {
        return tileAstral;
    }

    private void bindPlayerInventory(InventoryPlayer inventory)
    {
        int i;
        
        for(i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 86 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 144));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileAstral.isUseableByPlayer(player);
    }
    
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.tileAstral.closeInventory();
    }
    
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(slotIndex < this.tileAstral.getSizeInventory())
            {
                if(!this.mergeItemStack(itemstack1, this.tileAstral.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 0, this.tileAstral.getSizeInventory(), false))
            {
                return null;
            }

            if(itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}
