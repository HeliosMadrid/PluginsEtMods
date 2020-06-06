package fr.helios.astral.client.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockAstral extends Block
{
    
    public static final String NAME = "luminous_crafting_table";
    public static final PropertyEnum<BlockAstral.EnumType> VARIANT = PropertyEnum.<BlockAstral.EnumType>create("varient", BlockAstral.EnumType.class);

    public BlockAstral(Material material)
    {
        super(material);
        
        AstralBlocks.setBlockName(this, NAME);
        setResistance(2000F);
        setHardness(10F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockAstral.EnumType.FIRST));
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }
    
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for(BlockAstral.EnumType type : BlockAstral.EnumType.values())
        {
            list.add(new ItemStack(item, 1, type.getMetadata()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockAstral.EnumType.bymetadata(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockAstral.EnumType) state.getValue(VARIANT)).getMetadata();
    }
    
    @Override
    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
    
    public static enum EnumType implements IStringSerializable
    {
        FIRST(0, "astral", "astral_block"),
        SECOND(1, "astral2", "astral_block_m1");
        
        private static final BlockAstral.EnumType[] META_LOOKUP = new BlockAstral.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        
        private EnumType(int meta, String name, String unlocalized)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalized;
        }
        
        public static String[] getUnlocalizedNames()
        {
            String[] names = new String[values().length];
            
            for(int i = 0; i < META_LOOKUP.length; i++)
                names[i] = META_LOOKUP[i].unlocalizedName;
            
            return names;

        }
        
        public int getMetadata()
        {
            return this.meta;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        @Override
        public String getName()
        {
            return this.name;
        }
        
        public static BlockAstral.EnumType bymetadata(int meta)
        {
            if(meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }
            
            return META_LOOKUP[meta];
        }
        
        static
        {
            for(BlockAstral.EnumType type : values())
            {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }

}
