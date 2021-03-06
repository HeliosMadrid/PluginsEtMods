package fr.helios.astral.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockMetadataAstral extends ItemBlock
{

    public ItemBlockMetadataAstral(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return this.field_150939_a.getIcon(2, metadata);
    }
    
    public int getMetadata(int metadata)
    {
        return metadata;
    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
        int metadata = stack.getItemDamage();

        if (metadata < 0 || metadata >= BlockAstralMetadata.subBlock.length)
        {
            metadata = 0;
        }

        return super.getUnlocalizedName() + "." + BlockAstralMetadata.subBlock[metadata];
    }

}
