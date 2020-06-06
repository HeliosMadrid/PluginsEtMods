package fr.helios.astral.utils.generation;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class AstralGenLayerBiome extends GenLayer
{
    protected BiomeGenBase[] baseBiome = {BiomeGenBase.hell};
    
    public AstralGenLayerBiome(long seed)
    {
        super(seed);
    }

    @Override
    public int[] getInts(int coordX, int coordZ, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width * depth);
        
        for(int dz = 0; dz < depth; dz++)
        {
            for(int dx = 0; dx < width; dx++)
            {
                this.initChunkSeed(dx + coordX, dz + coordZ);
                dest[(dx + dz * width)] = this.baseBiome[nextInt(this.baseBiome.length)].biomeID;
            }
        }
        return dest;
    }

}
