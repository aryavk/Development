package com.k.business;

import org.hibernate.Session;

import com.k.common.SingletonHolder;
import com.k.hibernate.KEntity;

public abstract class DomainObject<I extends Comparable<I>, E extends KEntity<I>> implements Comparable<DomainObject<I,E>>
{
    private I id;
    private E entity;
    
    protected DomainObject(E entity)
    {
        this.id = entity.getId();
        this.entity = entity;
    }

    public I getId()
    {
        return id;
    }

    public E getEntity()
    {
        return entity;
    }
    
    public abstract String getName();
    
    public FactoryManager getFactoryManager()
    {
        return SingletonHolder.getFactoryManager();
    }
    
    public Session getSession()
    {
        return SingletonHolder.getCurrentSession();
    }

    @Override
    public int compareTo(DomainObject<I,E> o)
    {
        return getId().compareTo(o.getId());
    }
}
