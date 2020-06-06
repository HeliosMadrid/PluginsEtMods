package fr.helios.astral.utils;

import org.lwjgl.opengl.GL11;

import fr.helios.astral.References;
import fr.helios.astral.blocks.TileEntityAstral;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import java.awt.Color;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.helios.astral.utils.ContainerAstres;
import fr.helios.astral.ModAstral;
import fr.helios.astral.blocks.TileEntityAstral;

public class GuiAstres extends GuiContainer
{

    private static final ResourceLocation textures = new ResourceLocation(References.MODID, "textures/gui/container/astres.png");
    private TileEntityAstral tileAstres;
    private IInventory playerInv;
    
    public GuiAstres(TileEntityAstral tile, InventoryPlayer inventory)
    {
        super(new ContainerAstres(tile, inventory));
        this.tileAstres = tile;
        this.playerInv = inventory;
        this.allowUserInput = false;
        this.ySize = 170;
    }
    
    public void drawGuiContainerForegroundLayer(int x, int y)
    {
        String tileName = this.tileAstres.hasCustomInventoryName() ? this.tileAstres.getInventoryName() : I18n.format(this.tileAstres.getInventoryName());
        this.fontRendererObj.drawString(tileName, (this.xSize - this.fontRendererObj.getStringWidth(tileName)) / 2, 6, 0x0000CC);
        String invName = this.playerInv.hasCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName());
        this.fontRendererObj.drawString(invName, (this.xSize - this.fontRendererObj.getStringWidth(invName)) / 2, this.ySize - 96, 0);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
        this.mc.getTextureManager().bindTexture(textures);
        int k = (this.width - this.xSize) / 2; 
        int l = (this.height - this.ySize) / 2; 
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
