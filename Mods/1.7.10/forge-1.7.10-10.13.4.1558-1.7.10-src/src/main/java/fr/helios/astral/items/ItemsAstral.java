package fr.helios.astral.items;

import fr.helios.astral.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemsAstral extends Item
{

    @Override
    public void registerIcons(IIconRegister iconregister)
    {
        this.itemIcon = iconregister.registerIcon(References.MODID + ":luminous_wand");
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
        player.addChatMessage(new ChatComponentText("server : side" + side));
        player.addChatMessage(new ChatComponentText("server : metadata" + world.getBlockMetadata(x, y, z)));
        }
        else
        {
            player.addChatMessage(new ChatComponentText("client : side" + side));
            player.addChatMessage(new ChatComponentText("client : metadata" + world.getBlockMetadata(x, y, z)));
        }
        if(world.getBlock(x, y, z).rotateBlock(world, x, y, z, ForgeDirection.getOrientation(side)))
        {
            return true;
        }
        return false;
    }
}
