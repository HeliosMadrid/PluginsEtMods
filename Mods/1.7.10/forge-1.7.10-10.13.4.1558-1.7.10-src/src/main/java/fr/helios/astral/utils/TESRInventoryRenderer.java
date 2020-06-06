package fr.helios.astral.utils;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.helios.astral.ModAstral;
import fr.helios.astral.References;
import fr.helios.astral.blocks.TileEntityAstralSpecialrenderer;
import fr.helios.astral.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class TESRInventoryRenderer implements ISimpleBlockRenderingHandler
{
    private ModelCoffreAstral model = new ModelCoffreAstral();
    
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        if(block == ModAstral.coffre_astral && metadata == 0)
        {
            GL11.glPushMatrix();
            GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
            GL11.glTranslated(0.0, -1.0, 0.0);
            GL11.glRotatef(150, 0.0F, 2.0F, 0.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityAstralSpecialrenderer.texture);
            this.model.renderAll();
            GL11.glPopMatrix();
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return ClientProxy.tesrRenderId;
    }

}
