package fr.helios.divin.blocks;

import fr.helios.divin.entity.tile.TileEntityDivin;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CatalyseurDePuissance extends Block implements ITileEntityProvider
{

    public CatalyseurDePuissance(Material material)
    {
        super(material);
        this.setUnlocalizedName("catalyseurDePuissance").setCreativeTab(CreativeTabs.tabRedstone).setHardness(10F).setResistance(99999F).setLightLevel(1.0F).setLightOpacity((int)10);
        //this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityDivin();
    }
    
    @Override
    public boolean hasTileEntity()
    {
        return true;
    }
    
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }
    
    @Override
    public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(world, pos, state, eventID, eventParam);
        TileEntity tileEntity = world.getTileEntity(pos);
        return tileEntity == null ? false : tileEntity.receiveClientEvent(eventID, eventParam);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityDivin();
    }

}
