package fr.helios.divin.blocks;

import java.util.List;
import java.util.Random;

import fr.helios.divin.utils.EnumTypeClass;
import fr.helios.divin.utils.EnumAxisClass.EnumAxis;
import fr.helios.divin.utils.EnumTypeClass.EnumType;
import fr.helios.divin.utils.EnumTypeClass.EnumType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AstralMechaHeartBlock extends Block
{
   // public static final PropertyInteger ASTRAL_INTEGER = PropertyInteger.create("astral_integer", 0, 3);
    //public static final PropertyEnum ASTRAL_AXIS = PropertyEnum.create("axis", EnumAxis.class);
    public static final PropertyBool ASTRAL_BOOL = PropertyBool.create("astral_bool");
    //public static final PropertyDirection ASTRAL_DIRECTION = PropertyDirection.create("direction", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumType.class);

    public AstralMechaHeartBlock(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setDefaultState(getDefaultState().withProperty(ASTRAL_BOOL, false).withProperty(VARIANT, EnumTypeClass.EnumType.VARIANT_1));
        //this.setDefaultState(getDefaultState().withProperty(VARIANT, EnumType.VARIANT_1));
        //this.setDefaultState(getDefaultState().withProperty(ASTRAL_BOOL, true));
        //this.setDefaultState(getDefaultState().withProperty(ASTRAL_BOOL, false));
       // this.setDefaultState(getDefaultState().withProperty(ASTRAL_INTEGER, 0));
        //this.setDefaultState(getDefaultState().withProperty(ASTRAL_DIRECTION, EnumFacing.NORTH));
        //this.setDefaultState(getDefaultState().withProperty(ASTRAL_AXIS, EnumAxis.Y));
        //this.setHarvestLevel("pickaxe", 3, getDefaultState().withProperty(VARIANT, EnumType.VARIANT_1));
        //this.setHarvestLevel("pickaxe", 3, getDefaultState().withProperty(VARIANT, EnumType.VARIANT_2));
    }
    

    public IBlockState getStateFromMeta(int meta)
    {
        boolean astral_bool = (meta & 8) > 0;
        int type = meta & 1;
        //IBlockState state = this.getDefaultState();
        /*EnumFacing enumfacing = EnumFacing.getFront(meta);
        
        if(enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }*/
        
       /* switch(meta)
        {
            case 0:
                state = state.withProperty(ASTRAL_AXIS, EnumAxis.Y);
                break;
                
            case 1:
                state = state.withProperty(ASTRAL_AXIS, EnumAxis.X);
                break;
                
            case 2:
                state = state.withProperty(ASTRAL_AXIS, EnumAxis.Z);
                break;
                
            default:
                state = state.withProperty(ASTRAL_AXIS, EnumAxis.NONE);
        }*/
        
       // return state;
       //return this.getDefaultState().withProperty(ASTRAL_BOOL, Boolean.valueOf(astral_bool));
        return this.getDefaultState().withProperty(VARIANT, EnumType.values()[type]).withProperty(ASTRAL_BOOL, Boolean.valueOf(astral_bool));
       // return this.getDefaultState().withProperty(ASTRAL_INTEGER, Integer.valueOf(meta));
       // return this.getDefaultState().withProperty(ASTRAL_DIRECTION, enumfacing);
    }
    
    public String getUnlocalizedName(int metadata)
    {
        IBlockState state = this.getStateFromMeta(metadata);
        boolean astralBool = (Boolean)state.getValue(ASTRAL_BOOL);
 
        return super.getUnlocalizedName() + "." + ((EnumType)state.getValue(VARIANT)).getName() + "." + astralBool;
    }
    
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(world, pos, state);
    }

    private void setDefaultFacing(World world, BlockPos pos, IBlockState state)
    {
        if(!world.isRemote)
        {
            Block blockN = world.getBlockState(pos.north()).getBlock();
            Block blockS = world.getBlockState(pos.south()).getBlock();
            Block blockW = world.getBlockState(pos.west()).getBlock();
            Block blockE = world.getBlockState(pos.east()).getBlock();
            
            /*EnumFacing facing = (EnumFacing) state.getValue(ASTRAL_DIRECTION);
            
            if(facing == EnumFacing.NORTH && blockN.isFullBlock() && !blockS.isFullBlock())
            {
                facing = EnumFacing.SOUTH;
            }
            
            else if(facing == EnumFacing.SOUTH && blockS.isFullBlock() && !blockN.isFullCube())
            {
                facing = EnumFacing.NORTH;
            }
            
            else if(facing == EnumFacing.EAST && blockE.isFullBlock() && !blockW.isFullCube())
            {
                facing = EnumFacing.WEST;
            }
            
            else if(facing == EnumFacing.WEST && blockW.isFullBlock() && !blockE.isFullBlock())
            {
                facing = EnumFacing.EAST;
            }*/
        }
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        //return this.getDefaultState().withProperty(ASTRAL_DIRECTION, EnumFacing.SOUTH);
        //return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(ASTRAL_AXIS, EnumAxis.fromFacingAxis(facing.getAxis()));
    }*/
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(state.getBlock() != this)
        {
            return false;
        }
        else
        {
            boolean flag = ((Boolean) state.getValue(ASTRAL_BOOL).booleanValue());
            
            if(flag)
            {
                world.setBlockState(pos, state.withProperty(ASTRAL_BOOL, Boolean.valueOf(false)));
                
                return true;
            }
            else if(!flag)
            {
                world.setBlockState(pos, state.withProperty(ASTRAL_BOOL, Boolean.valueOf(true)));
                
                return true;
            }
            return false;
        }
        
        
        /*state = world.getBlockState(pos);        
        int i = ((Integer) state.getValue(ASTRAL_INTEGER)).intValue();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        
        if(i < 3)
        {
            world.setBlockState(pos, state.withProperty(ASTRAL_INTEGER, Integer.valueOf(i + 1)), 3);
        }
        
        else
        {
            world.setBlockToAir(pos);
            
            world.createExplosion(null, x, y, z, 10.0F, true);
        }
        
        return true;*/
    }

    @Override
    public float getBlockHardness(World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        
        if(state.getBlock() == this)
        {
            boolean astral_bool = (Boolean) state.getValue(ASTRAL_BOOL);
            int variant = state.getValue(VARIANT) == EnumTypeClass.EnumType.VARIANT_1 ? 1 : 0;
            
            if(astral_bool)
                return 2.5F + variant;
            else
                return 2.0F + variant;
        }
        return super.getBlockHardness(world, pos);
    }

    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int type = ((EnumType)state.getValue(VARIANT)).getMetadata();
        boolean astral_bool = (Boolean) state.getValue(ASTRAL_BOOL); 
        /*int meta = 0;
        
        switch(SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis) state.getValue(ASTRAL_AXIS)).ordinal()])
        {
            case 1:
                meta = 1;
                break;
                
            case 2:
                meta = 2;
                break;
                
            case 3:
                meta = 3;
                break;
        }*/
        
        //return ((EnumType)state.getValue(VARIANT)).getMetadata();
        return astral_bool ? 0 | 8 : 0;
       // return ((Integer) state.getValue(ASTRAL_INTEGER)).intValue();
       // return ((EnumFacing) state.getValue(ASTRAL_DIRECTION)).getIndex();
        //return meta;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion)
    {
        
        IBlockState state = world.getBlockState(pos);
        
        if(state.getBlock() == this)
        {
            boolean astra_bool = (Boolean) state.getValue(ASTRAL_BOOL);
            int variant = state.getValue(VARIANT) == EnumTypeClass.EnumType.VARIANT_1 ? 1 : 0;
            
            variant = variant + (astra_bool ? 2 : 0);
            
            int resistance = (3 + variant) * 3 / 5;
            
            return resistance;
        }
        return super.getBlockHardness(world, pos);
    }


    @Override
    protected BlockState createBlockState()
    {
        //return new BlockState(this, new IProperty[] {VARIANT});
        return new BlockState(this, new IProperty[] {ASTRAL_BOOL, VARIANT});
        //return new BlockState(this, new IProperty[] {ASTRAL_INTEGER});
        //return new BlockState(this, new IProperty[] {ASTRAL_DIRECTION});
       // return new BlockState(this, new IProperty[] {ASTRAL_AXIS});
    }
    
    static final class SwitchEnumAxis
    {
 
        static final int[] AXIS_LOOKUP = new int[EnumAxis.values().length];
 
        static
        {
            try
            {
                AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
            }
            catch(NoSuchFieldError var3)
            {
                ;
            }
 
            try
            {
                AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
            }
            catch(NoSuchFieldError var2)
            {
                ;
            }
 
            try
            {
                AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
            }
            catch(NoSuchFieldError var1)
            {
                ;
            }
        }

   /* @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        Block block = world.getBlockState(pos.down()).getBlock();
        boolean stone = Boolean.valueOf(block == Blocks.stone);
        
        return state.withProperty(ASTRAL_BOOL, stone);
    }*/

    public int damageDropped(IBlockState state)
    {
        int type = ((EnumType) state.getValue(VARIANT)).getMetadata();
        boolean astral_bool = (Boolean) state.getValue(ASTRAL_BOOL);
        
        //return ((EnumType)state.getValue(VARIANT)).getMetadata();
        //return astral_bool ? 0 | 8 : 0;
        return astral_bool ? type | 8 : type;
    }   

    /*@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if(state.getValue(VARIANT) == EnumType.VARIANT_1)
        {
            return Items.diamond;
        }
        
        else
        {
            return Item.getItemFromBlock(this);
        }
    }*/
    
   /* @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        //list.add(new ItemStack(this, 1, EnumType.VARIANT_1.getMetadata()));
       // list.add(new ItemStack(this, 1, EnumType.VARIANT_2.getMetadata()));
        /*list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
        list.add(new ItemStack(this, 1, 2));
        list.add(new ItemStack(this, 1, 3));
        list.add(new ItemStack(this, 1, 4));
        list.add(new ItemStack(this, 1, 5));
        list.add(new ItemStack(this, 1, 6));
        list.add(new ItemStack(this, 1, 7));
        list.add(new ItemStack(this, 1, 8));
        list.add(new ItemStack(this, 1, 9));
        list.add(new ItemStack(this, 1, 10));
    }*/

    /*@Override
    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosion)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        
        world.setBlockToAir(pos);
        world.createExplosion(null, x, y, z, 100.0F, true);
    }*/

    }
}

