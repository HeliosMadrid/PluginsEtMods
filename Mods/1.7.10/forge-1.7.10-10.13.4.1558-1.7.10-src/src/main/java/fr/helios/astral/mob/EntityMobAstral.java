package fr.helios.astral.mob;

import fr.helios.astral.ModAstral;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMobAstral extends EntityMob
{

    public EntityMobAstral(World world)
    {
        super(world);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
    }
    
    public Item getDropItem()
    {
        return ModAstral.sword_astral;
    }

}
