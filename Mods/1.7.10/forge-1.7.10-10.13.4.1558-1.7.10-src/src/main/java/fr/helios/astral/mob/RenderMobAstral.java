package fr.helios.astral.mob;

import fr.helios.astral.References;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderMobAstral extends RenderBiped
{
    private final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/mob/mobastral/mob_astral.png");
    
    public RenderMobAstral(ModelBiped model, float shadow)
    {
        super(model, shadow);
    }
    
    protected ResourceLocation getEntityTexture(EntityLiving living)
    {
        return this.getMobAstral((EntityMobAstral)living);
    }
 
    private ResourceLocation getMobAstral(EntityMobAstral mobAstral)
    {
        return texture;
    }

}
