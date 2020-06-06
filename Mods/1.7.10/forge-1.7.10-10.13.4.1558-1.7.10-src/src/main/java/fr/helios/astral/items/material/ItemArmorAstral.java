package fr.helios.astral.items.material;



import fr.helios.astral.ModAstral;
import fr.helios.astral.References;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemArmorAstral extends ItemArmor
{

    public ItemArmorAstral(ArmorMaterial material, int type)
    {
        super(material, 0, type);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return References.MODID + ":textures/models/armor/astral_layer_2.png";
        }        
        return References.MODID + ":textures/models/armor/astral_layer_1.png";
    }
        
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == ModAstral.luminous_wand)
        {
            return true;
        }
        
        return false;
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
    {
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 220, 3));
        
        if(this.armorType == 0 && world.getBlockLightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) < 8)
        {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 0));
        }
        
        if(this.armorType == 2 && player.isSprinting() && player.onGround)
        {
            player.motionX *= 1.5F;
            player.motionZ *= 1.5F;
            player.addPotionEffect(new PotionEffect(Potion.jump.id, 60, 2));
        }
        
        if(this.armorType == 3 && player.isSneaking())
        {
            player.motionX *= 2F;
            player.motionZ *= 2F;
        }
    }
    

}

   
