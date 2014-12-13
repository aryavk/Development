package com.k.hibernate;

public abstract class KEntity<I extends Comparable<I>>
{
    public abstract I getId();
    public abstract void setId(I id);
}
