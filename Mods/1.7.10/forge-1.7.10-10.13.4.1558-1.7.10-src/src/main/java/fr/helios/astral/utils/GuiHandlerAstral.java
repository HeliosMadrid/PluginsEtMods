package fr.helios.astral.utils;

import cpw.mods.fml.common.network.IGuiHandler;
import fr.helios.astral.blocks.TileEntityAstral;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.helios.astral.utils.GuiAstres;

public class GuiHandlerAstral implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityAstral)
        {
            return new ContainerAstres((TileEntityAstral)tile, player.inventory);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityAstral)
        {
            return new GuiAstres((TileEntityAstral)tile, player.inventory);
        }
        return null;
    }
}
