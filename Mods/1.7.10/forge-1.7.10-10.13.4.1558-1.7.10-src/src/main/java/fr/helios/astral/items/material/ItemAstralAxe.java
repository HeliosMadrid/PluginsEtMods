package fr.helios.astral.items.material;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAstralAxe extends ItemAxe
{

    public ItemAstralAxe(ToolMaterial material)
    {
        super(material);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
        for(int i = y; i < 256; i++)
        {
            if(world.getBlock(x, i, z).isWood(world, x, i, z))
            {
                stack.damageItem(1, living); 
                if(!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) 
                {
                    float f = 0.7F;
                    double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)i + d1, (double)z + d2, new ItemStack(world.getBlock(x, i, z), 1, world.getBlockMetadata(x, i, z))); 
                    entityitem.delayBeforeCanPickup = 10;
                    world.spawnEntityInWorld(entityitem); 
                }
                world.setBlockToAir(x, i, z); 
            }
            else
            {
                return super.onBlockDestroyed(stack, world, block, x, i, z, living);
            }
        }
        return super.onBlockDestroyed(stack, world, block, x, y, z, living);
    }
    

}
