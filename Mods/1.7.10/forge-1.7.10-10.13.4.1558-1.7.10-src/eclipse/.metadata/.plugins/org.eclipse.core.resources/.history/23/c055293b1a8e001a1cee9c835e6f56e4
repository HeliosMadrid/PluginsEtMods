package fr.helios.astral.mob.boss;

import fr.helios.astral.References;
import fr.helios.astral.mob.EntityMobAstral;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDivinea extends RenderLiving
{
    private final ResourceLocation textures = new ResourceLocation(References.MODID, "textures/entity/mob/divienea/divinea.png");
    
    public RenderDivinea(ModelDivinea modelDivinea, float shadow)
    {
        super(modelDivinea, shadow);
    }
    
    protected ResourceLocation getEntityTexture(Entity living)
    {
        return this.getMobAstralDivinea((EntityDivinea)living);
    }
 
    private ResourceLocation getMobAstralDivinea(EntityDivinea living)
    {
        return textures;
    }

}
