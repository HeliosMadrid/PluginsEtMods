package fr.helios.astral.mob.boss.SF;

import fr.helios.astral.ModAstral;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMobAstralSF extends EntityMob
{

    public EntityMobAstralSF(World world)
    {
        super(world);
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.5D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.1D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699999988079071D);
    }
    
    public Item getDropItem()
    {
        return Items.apple;
    }

}
