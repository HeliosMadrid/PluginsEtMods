package fr.helios.astral.client.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.server.permission.PermissionAPI;

public class ItemAstral extends Item
{
    public static final String NAME = "astral_wand";
    
    public ItemAstral()
    {
        super();
        
        AstralItems.setItemName(this, NAME);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        //if(PermissionAPI.hasPermission(player, "astral.items.laser"))
        //{
            if(!world.isRemote)
            {
                if(!player.getIsInvulnerable() == player.isGlowing())
                {
                    player.setEntityInvulnerable(player.isGlowing());
                }
                else if(player.isGlowing() == false)
                {
                    player.setGlowing(true);
                }
                else if(player.isGlowing() == true)
                {
                    player.setGlowing(false);
                }
                else if(player.getIsInvulnerable() == false)
                {
                player.setEntityInvulnerable(true);
                }
                else if(player.getIsInvulnerable() == true)
                {
                    player.setEntityInvulnerable(false);
                }
                return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        //}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    }
}
