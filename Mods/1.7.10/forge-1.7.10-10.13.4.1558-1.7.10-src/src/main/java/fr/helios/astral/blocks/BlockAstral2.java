package fr.helios.astral.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.helios.astral.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAstral2 extends Block
{
    private IIcon top, bottom;
    public BlockAstral2(Material material)
    {
        super(material);
    }
    
    public void registerBlockIcons(IIconRegister iiconRegisters)
    {
        this.blockIcon = iiconRegisters.registerIcon(References.MODID + ":fragement_etoile");
        this.top = iiconRegisters.registerIcon(References.MODID + ":fragement_froid");
        this.bottom = iiconRegisters.registerIcon(References.MODID + ":fragement_chaud");
    }
    
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 2 || side == 3)
        {
            return this.bottom;
        }
        else if(side == 1 || side == 0)
        {
            return this.top;
        }
        return this.blockIcon;
    }  

}
