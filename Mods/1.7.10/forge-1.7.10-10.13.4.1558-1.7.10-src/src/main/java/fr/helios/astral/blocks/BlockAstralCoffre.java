package fr.helios.astral.blocks;

import fr.helios.astral.ModAstral;
import fr.helios.astral.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.helios.astral.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockAstralCoffre extends Block
{

    public BlockAstralCoffre(Material material)
    {
        super(material);
        this.setCreativeTab(ModAstral.astralCreativeTab);
        this.setBlockBounds(-0.1F, 0.1F, -0.1F, 0.9F, 1.0F, 0.9F);
        this.setHardness(2F);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityAstral();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return ClientProxy.tesrRenderId;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
       
        if(tile instanceof TileEntityAstral)
        {
            TileEntityAstral tileAstral = (TileEntityAstral)tile;
            switch(tileAstral.getDirection())
            {
                case 0:
                    
                    this.setBlockBounds(0.028F, 0.0F, 0.03F, 0.97F, 0.95F, 0.97F);  // North
                    
                    break;
                    
                case 1:
                    
                    this.setBlockBounds(0.028F, 0.0F, 0.03F, 0.97F, 0.95F, 0.97F);  // East
                   
                    break;
                    
                case 2:
                    
                    this.setBlockBounds(0.028F, 0.0F, 0.03F, 0.97F, 0.95F, 0.97F);  // South
                   
                    break;
                    
                case 3:
                   
                    this.setBlockBounds(0.028F, 0.0F, 0.03F, 0.97F, 0.95F, 0.97F); // West
                    
                    break;
            }
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(stack.hasDisplayName())
        {
            ((TileEntityAstral)tile).setCustomName(stack.getDisplayName());
        }
        
        if(stack.getItemDamage() == 0)
        {
            if(tile instanceof TileEntityAstral)
            {
                int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.50) & 3;
                ((TileEntityAstral)tile).setDirection((byte)direction);
            }
        }
    }
    
    @Override
    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis)
    {
        if((axis == ForgeDirection.UP || axis == ForgeDirection.DOWN) && !world.isRemote && world.isRemote && world.getBlockMetadata(x, y, z) == 0)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile instanceof TileEntityAstral)
            {
                TileEntityAstral tileAstral = (TileEntityAstral)tile;
                byte direction = tileAstral.getDirection();
                direction++;
                if(direction > 3)
                {
                    direction = 0;
                }
                tileAstral.setDirection(direction);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {

        if(world.isRemote)
        {
            return true;
        }
        
        else if(!world.isRemote)
        {
        player.openGui(ModAstral.instance, 0, world, x, y, z);   
        TileEntity tile = world.getTileEntity(x, y, z);       
        return true;
        } 
        return true;    
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);

        if (tileentity instanceof IInventory)
        {
            IInventory inv = (IInventory)tileentity;
       
            for (int i1 = 0; i1 < inv.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = inv.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = world.rand.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }
    
    public boolean onBlockEventReceived(World world, int x, int y, int z, int id, int value)
    {
        super.onBlockEventReceived(world, x, y, z, id, value);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null ? tileentity.receiveClientEvent(id, value) : false;
    }

}

