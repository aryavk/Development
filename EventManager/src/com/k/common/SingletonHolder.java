package com.k.common;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k.business.FactoryManager;

@Component
public class SingletonHolder
{
    @Autowired
    private SessionFactory sessionFactory;
    
    private static SessionFactory staticSessionFactory;
    
    @Autowired
    private FactoryManager factoryManager;
    
    private static FactoryManager staticFactoryManager;
    
    @PostConstruct
    public void initialise()
    {
        staticFactoryManager = factoryManager;
        staticSessionFactory = sessionFactory;
    }
    
    public static Session getCurrentSession()
    {
        return staticSessionFactory.getCurrentSession();
    }
    
    public static FactoryManager getFactoryManager()
    {
        return staticFactoryManager;
    }
}
