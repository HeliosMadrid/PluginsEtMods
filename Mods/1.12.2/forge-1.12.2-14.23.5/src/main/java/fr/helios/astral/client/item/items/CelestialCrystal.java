package fr.helios.astral.client.item.items;

import fr.helios.astral.client.item.ItemsAstral;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CelestialCrystal extends Item
{
    public static final String NAME = "celestial_crystal";
    
    public CelestialCrystal()
    {
        super();
        ItemsAstral.setItemName(this, NAME);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setFull3D();
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        boolean test = true;
        if(!world.isRemote && test == true)
        {
            player.sendMessage(new TextComponentString("Ne joue pas avec ceci c'est le dernier §4fragement de ma §2divinité aujourd'hui perdu"));
            world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ, 0.25, 0.25, 0.25, 10);
            test = false;
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    }
}
