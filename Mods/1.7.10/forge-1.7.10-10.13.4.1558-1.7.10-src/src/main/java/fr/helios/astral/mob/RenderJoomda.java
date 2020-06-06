package fr.helios.astral.mob;

import fr.helios.astral.References;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderJoomda extends RenderLiving
{

    private final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/mob/joomda/joomda.png");
    
    public RenderJoomda(ModelJoomda modelJoomda, float shadow)
    {
        super(modelJoomda, shadow);
    }
 
    protected ResourceLocation getEntityTexture(Entity living)
    {
        return this.getMobJoomda((EntityJoomda)living);
    }
 
    private ResourceLocation getMobJoomda(EntityJoomda mobAtral)
    {
        return texture;
    }
    
}
