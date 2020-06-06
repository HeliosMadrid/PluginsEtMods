package fr.helios.divin.entity.tile;

import fr.helios.divin.blocks.DivinBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class TileEntityInventoryRenderHelper extends TileEntityItemStackRenderer
{
    private TileEntityDivin tileEntityDivin = new TileEntityDivin();
    
    @Override
    public void renderByItem(ItemStack stack)
    {
        Block block = Block.getBlockFromItem(stack.getItem());
        
        if(block == DivinBlocks.catalyseurDePuissance)
        {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tileEntityDivin, 0.0D, 0.0D, 0.0D, 0.0F);
        }
        else
        {
            super.renderByItem(stack);
        }
    }
}
