package fr.helios.divin.entity.tile;

import assets.divin.models.block.ModelCactalyseurDePuissance;
import fr.helios.divin.ModDivin;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityDivinSpecialRender extends TileEntitySpecialRenderer
{
    private static ModelCactalyseurDePuissance modelCatalyseur = new ModelCactalyseurDePuissance();
    public static ResourceLocation texture = new ResourceLocation(ModDivin.MODID, "textures/models/blocks/catalyseurDePuissance.png");
       
    public void renderTileEntityDivinAt(TileEntity tileEntity, double x, double y, double z, float partialTicks, int damageCounts)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(180F, 1.0F, 0.0F, 0.0F);
        this.bindTexture(texture);
        modelCatalyseur.renderAll();
        GlStateManager.popMatrix();
    }
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks, int damageCounts)
    {
        this.renderTileEntityAt(((TileEntityDivin) tileEntity), x, y, z, partialTicks, damageCounts);
    }
}
