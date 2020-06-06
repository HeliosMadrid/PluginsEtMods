/*package fr.helios.astral.utils.generation;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.DimensionManager;

public class WorldTypeAstral extends WorldType
{
    public WorldTypeAstral()
    {
        super("StarLands");
        
        DimensionManager.unregisterProviderType(0);
        DimensionManager.registerProviderType(0, WorldProviderAstral.class, true);
    }
    
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parenLayer)
    {
        GenLayer ret = new BiomeGenLayerAstral(200L, parenLayer);
        
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
    
    public WorldChunkManager getChunkManager(World world)
    {
        return new WorldChunkManagerAstral(world);
    }
}*/
