package fr.helios.astral.blocks;

import org.lwjgl.opengl.GL11;

import fr.helios.astral.References;
import fr.helios.astral.utils.ModelCoffreAstral;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.helios.astral.ModAstral;
import fr.helios.astral.blocks.TileEntityAstral;

public class TileEntityAstralSpecialrenderer extends TileEntitySpecialRenderer
{
    public ModelCoffreAstral model = new ModelCoffreAstral();
    public static ResourceLocation texture = new ResourceLocation(References.MODID, "textures/models/blocks/ModelCoffreTexture.png");
    
    public TileEntityAstralSpecialrenderer()
    {
        this.func_147497_a(TileEntityRendererDispatcher.instance);
    }
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick)
    {
        this.renderTileEntityAstralAt((TileEntityAstral)tile,  x,  y,  z,  partialRenderTick);
    }

    private void renderTileEntityAstralAt(TileEntityAstral tile, double x, double y, double z, float partialRenderTick)
    {
        TileEntityAstral tileAstral = (TileEntityAstral)tile;
        switch(tileAstral.getDirection())
        {
            case 0:
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.53F, y + 1.44F, z + 0.47F);
                GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
                GL11.glRotated(90F * tile.getDirection() + 180F, 0.0F, 1.0F, 0.0F);
                this.bindTexture(texture);
                float f1 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialRenderTick;
                f1 = 1.0F - f1;
                f1 = 1.0F - f1 * f1 * f1;
                this.model.upPlate.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
                this.model.verrouePlate.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
                this.model.serrurePlate.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
                this.model.renderAll();
                GL11.glPopMatrix();   
                
                break;
                
            case 1:
                
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.53F, y + 1.44F, z + 0.53F);
                GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
                GL11.glRotated(90F * tile.getDirection() + 180F, 0.0F, 1.0F, 0.0F);
                this.bindTexture(texture);
                float f2 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialRenderTick;
                f2 = 1.0F - f2;
                f2 = 1.0F - f2 * f2 * f2;
                this.model.upPlate.rotateAngleX = -(f2 * (float)Math.PI / 2.0F);
                this.model.verrouePlate.rotateAngleX = -(f2 * (float)Math.PI / 2.0F);
                this.model.serrurePlate.rotateAngleX = -(f2 * (float)Math.PI / 2.0F);
                model.renderAll();
                GL11.glPopMatrix();   
               
                break;
                
            case 2:
                
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.47F, y + 1.44F, z + 0.53F);
                GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
                GL11.glRotated(90F * tile.getDirection() + 180F, 0.0F, 1.0F, 0.0F);
                this.bindTexture(texture);
                float f3 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialRenderTick;
                f3 = 1.0F - f3;
                f3 = 1.0F - f3 * f3 * f3;
                this.model.upPlate.rotateAngleX = -(f3 * (float)Math.PI / 2.0F);
                this.model.verrouePlate.rotateAngleX = -(f3 * (float)Math.PI / 2.0F);
                this.model.serrurePlate.rotateAngleX = -(f3 * (float)Math.PI / 2.0F);
                model.renderAll();
                GL11.glPopMatrix();      
               
                break;
                
            case 3:
               
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.47F, y + 1.44F, z + 0.47F);
                GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
                GL11.glRotated(90F * tile.getDirection() + 180F, 0.0F, 1.0F, 0.0F);
                this.bindTexture(texture);
                float f4 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialRenderTick;
                f4 = 1.0F - f4;
                f4 = 1.0F - f4 * f4 * f4;
                this.model.upPlate.rotateAngleX = -(f4 * (float)Math.PI / 2.0F);
                this.model.verrouePlate.rotateAngleX = -(f4 * (float)Math.PI / 2.0F);
                this.model.serrurePlate.rotateAngleX = -(f4 * (float)Math.PI / 2.0F);
                model.renderAll();
                GL11.glPopMatrix();  
                
                break;
        }

    }

}
