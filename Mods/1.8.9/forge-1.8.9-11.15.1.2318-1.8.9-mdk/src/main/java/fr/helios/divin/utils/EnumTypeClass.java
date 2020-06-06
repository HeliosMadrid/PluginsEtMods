package fr.helios.divin.utils;

import net.minecraft.util.IStringSerializable;

public class EnumTypeClass
{
    public static enum EnumType implements IStringSerializable
    {
        
        VARIANT_1(0, "on"), VARIANT_2(1, "off");
        private static final EnumType[] METADATA = new EnumType[values().length];
        private final String name;
        private final int metadata;        
        
        private EnumType(int metadata, String name)
        {
            this.metadata = metadata;
            this.name = name;
        }
        
        @Override
        public String getName()
        {
            return name;
        }       
        
        public int getMetadata()
        {
            return metadata;
        }
        
        public String toString()
        {
            return name;
        }
        
        public static EnumType getStateFromMeta(int metadata)
        {
            if(metadata < 0 || metadata >= METADATA.length)
            {
                metadata = 0;
            }
            
            return METADATA[metadata];
        }
        
        static 
        {
            EnumType[] var0 = values();
            int var1 = var0.length;
            
            for(int var2 = 0; var2 < var1; var2++)
            {
                EnumType var3 = var0[var2];
                METADATA[var3.getMetadata()] = var3;
            }
        }
    }
}
