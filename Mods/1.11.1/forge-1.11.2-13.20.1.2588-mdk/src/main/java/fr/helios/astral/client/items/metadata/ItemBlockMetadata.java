package fr.helios.astral.client.items.metadata;

import fr.helios.astral.References;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetadata extends ItemBlock
{
    String[] unlocalizedNames;
    
    public ItemBlockMetadata(Block block, String[] unlocalizedNames)
    {
        super(block);
        
        this.unlocalizedNames = unlocalizedNames;
        setHasSubtypes(true);
        setMaxDamage(0);
    }
    
    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return References.MODID + "." + unlocalizedNames[stack.getMetadata()];
    }
}
