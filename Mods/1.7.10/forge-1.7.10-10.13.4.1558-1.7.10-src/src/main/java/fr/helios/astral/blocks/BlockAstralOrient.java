package fr.helios.astral.blocks;

import fr.helios.astral.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;

public class BlockAstralOrient extends Block
{
    private IIcon front, back;
    public BlockAstralOrient(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(10F);
    }
    
    public void registerBlockIcons(IIconRegister iiconRegisters)
    {
        this.blockIcon = iiconRegisters.registerIcon(References.MODID + ":grill");
        this.front = iiconRegisters.registerIcon(References.MODID + ":enter");
        this.back = iiconRegisters.registerIcon(References.MODID + ":exit");
    }
    
    public IIcon getIcon(int side, int metadata)
    {       
            return side == 4 && metadata == 1 ? this.front : (side == 2 && metadata == 2 ? this.front : (side == 5 && metadata == 3 ? this.front : (side == 3 && metadata == 0 ? this.front : (side == 5 && metadata == 1 ? this.back : (side == 3 && metadata == 2 ? this.back : (side == 4 && metadata == 3 ? this.back : (side == 2 && metadata == 0 ? this.back : this.blockIcon)))))));
    } 
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }
    
    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis)
    {
        if(axis == ForgeDirection.UP || axis == ForgeDirection.DOWN && !world.isRemote)
        {
        int direction = world.getBlockMetadata(x, y, z);
        if(direction > 3)
        {
            direction = 0;
        }
        world.setBlockMetadataWithNotify(x, y, z, direction + 1, 3);
        return true;
        }
        return false;
    }
    
    public ForgeDirection[] getValidRotations(World world, int x, int y, int z)
    {
        return new ForgeDirection[] {ForgeDirection.UP, ForgeDirection.DOWN};    }

}
