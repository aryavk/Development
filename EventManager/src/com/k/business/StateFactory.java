package com.k.business;

import java.util.SortedSet;

public interface StateFactory
{
    public SortedSet<State> getSet();
    public State get(Byte id);
}
