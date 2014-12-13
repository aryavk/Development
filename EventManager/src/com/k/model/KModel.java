package com.k.model;

import java.util.Comparator;

public abstract class KModel<I extends Comparable<I>> implements Comparable<KModel<I>>
{
    public abstract I getId();
    public abstract String getName();
    
    @Override
    public int compareTo(KModel<I> other)
    {
        return getId().compareTo(other.getId());
    }
    
    private static class NameComparator implements Comparator<KModel<?>>
    {
        @Override
        public int compare(KModel<?> o1, KModel<?> o2)
        {
            return o1.getName().compareTo(o2.getName());
        }        
    }
    
    public static Comparator<KModel<?>> getDisplayComparator()
    {
        return new NameComparator();
    }
}
