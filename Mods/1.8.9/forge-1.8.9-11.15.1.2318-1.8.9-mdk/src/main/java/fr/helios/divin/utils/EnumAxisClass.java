package fr.helios.divin.utils;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class EnumAxisClass
{
    public static enum EnumAxis implements IStringSerializable
    {
        X("x"), Y("y"), Z("z"), NONE("none");
        
        private final String name;
        
        private EnumAxis(String name)
        {
            this.name = name;
        }
        
        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return name;
        }
        
        public static EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch(SwitchEnumAxis.AXIS_LOOKUP[axis.ordinal()])
            {
                case 1:
                    return X;
                    
                case 2:
                    return Y;
                    
                case 3:
                    return Z;
                    
                default:
                    return NONE;
            }
        }
        
        static final class SwitchEnumAxis
        {
            static final int[] AXIS_LOOKUP = new int[EnumFacing.Axis.values().length];
            
            static
            {
                try
                {
                    AXIS_LOOKUP[EnumFacing.Axis.X.ordinal()] = 1;
                }
                catch(NoSuchFieldError e)
                {
                    ;
                }
                
                try
                {
                    AXIS_LOOKUP[EnumFacing.Axis.Y.ordinal()] = 2;
                }
                
                catch(NoSuchFieldError e)
                {
                    ;
                }
     
                try
                {
                    AXIS_LOOKUP[EnumFacing.Axis.Z.ordinal()] = 3;
                }
                
                catch(NoSuchFieldError e)
                {
                    ;
                }
            }
        }
    }
    
}
