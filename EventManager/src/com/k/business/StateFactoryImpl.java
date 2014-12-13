package com.k.business;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k.hibernate.StateEntity;

@Component("stateFactoryImpl")
public class StateFactoryImpl implements StateFactory
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired    
    private FactoryManager factoryManager;
    
    public SortedSet<State> getSet()
    {
        SortedSet<State> result = new TreeSet<State>();
        
        @SuppressWarnings("unchecked")
        List<StateEntity> list = sessionFactory.getCurrentSession().createCriteria(StateEntity.class).list();
        
        for (StateEntity entity : list)
            result.add(get(entity.getId()));
        
        return result;
    }
    
    public State get(Byte id)
    {
        StateEntity entity = (StateEntity) sessionFactory.getCurrentSession().get(StateEntity.class, id);
        
        return new State(entity);
    }
}
