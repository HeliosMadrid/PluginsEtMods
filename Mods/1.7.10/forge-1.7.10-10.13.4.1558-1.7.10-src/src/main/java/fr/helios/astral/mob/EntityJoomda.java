package fr.helios.astral.mob;

import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityJoomda extends EntityAmbientCreature
{

    public EntityJoomda(World world)
    {
        super(world);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if(this.worldObj.getTotalWorldTime() % 80 == 0)
        {
            if(this.onGround)
            {
                this.jump();
            }
        }        
        
    }

    @Override
    protected void jump()
    {
        this.motionY = 0.41999998688697815D;
        
        if(this.isPotionActive(Potion.jump))
        {
            this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
        }
        
        float f = this.rotationYaw * 0.01745329F;
        this.motionX -= (double)(MathHelper.sin(f) * 0.5F);
        this.motionZ += (double)(MathHelper.cos(f) * 0.5F);
        
        this.isAirBorne = true;
        ForgeHooks.onLivingJump(this);
    }

}
