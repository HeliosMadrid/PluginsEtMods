package fr.helios.astral.utils.generation;

import net.minecraft.init.Blocks;
import net.minecraft.world.WorldProviderSurface;

public class WorldProviderAstral extends WorldProviderSurface
{
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        return this.worldObj.getTopBlock(par1, par2) == Blocks.obsidian || this.worldObj.getTopBlock(par1, par2) == Blocks.end_portal_frame || this.worldObj.getTopBlock(par1, par2) == Blocks.portal || this.worldObj.getTopBlock(par1, par2) == Blocks.snow_layer || this.worldObj.getTopBlock(par1, par2) == Blocks.fire;
    }
    
    public String getDimension()
    {
        return "astral";
    }
    
    public String getSaveFolder()
    {
        return "Astral";
    }
}