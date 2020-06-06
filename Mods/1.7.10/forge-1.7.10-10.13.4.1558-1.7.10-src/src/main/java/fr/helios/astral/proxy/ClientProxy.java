package fr.helios.astral.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.helios.astral.blocks.BlockAstralCoffre;
import fr.helios.astral.blocks.TileEntityAstral;
import fr.helios.astral.blocks.TileEntityAstralSpecialrenderer;
import fr.helios.astral.mob.EntityJoomda;
import fr.helios.astral.mob.EntityMobAstral;
import fr.helios.astral.mob.ModelJoomda;
import fr.helios.astral.mob.RenderJoomda;
import fr.helios.astral.mob.RenderMobAstral;
import fr.helios.astral.mob.boss.EntityDivinea;
import fr.helios.astral.mob.boss.ModelDivinea;
import fr.helios.astral.mob.boss.RenderDivinea;
import fr.helios.astral.utils.TESRInventoryRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBlaze;

public class ClientProxy extends ServerProxy
{
    public static int tesrRenderId;
    
    @Override
    public void registerRender()
    {
        System.out.println("côté client");
        
        tesrRenderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new TESRInventoryRenderer());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAstral.class, new TileEntityAstralSpecialrenderer());
        
        RenderingRegistry.registerEntityRenderingHandler(EntityMobAstral.class, new RenderMobAstral(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityJoomda.class, new RenderJoomda(new ModelJoomda(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDivinea.class, new RenderDivinea(new ModelDivinea(), 1.0F));
    }
}
