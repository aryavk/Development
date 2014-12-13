package com.k.business;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k.hibernate.EventEntity;
import com.k.model.EventModel;

@Component("eventFactoryImpl")
public class EventFactoryImpl implements EventFactory
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired    
    private FactoryManager factoryManager;
    
    public SortedSet<Event> getSet()
    {
        SortedSet<Event> result = new TreeSet<Event>();
        
        @SuppressWarnings("unchecked")
        List<EventEntity> list = sessionFactory.getCurrentSession().createCriteria(EventEntity.class).list();
        
        for (EventEntity entity : list)
            result.add(get(entity.getId()));
        
        return result;
    }
    
    public SortedSet<Event> searchEvents(Byte stateId, Integer industryId)
    {
        
    }
    
    public Event get(Integer id)
    {
        EventEntity entity = (EventEntity) sessionFactory.getCurrentSession().get(EventEntity.class, id);
        
        if (entity != null)
            return new Event(entity);
        else
            return null;
    }
    
    public Event create(EventModel model)
    {
        EventEntity entity = new EventEntity();
        
        model.validate();
        
        entity.setName(model.getName());
        entity.setIndustry(factoryManager.getIndustryFactory().get(model.getIndustry().getId()).getEntity());
        entity.setState(factoryManager.getStateFactory().get(model.getState().getId()).getEntity());
        entity.setLocation(model.getLocation());
        entity.setVenue(model.getVenue());
        entity.setWebsite(model.getWebsite());
        entity.setFromDate(model.getFromDate());
        entity.setToDate(model.getToDate());
        entity.setAttending(false);
        
        sessionFactory.getCurrentSession().save(entity);
        
        return new Event(entity);
    }
    
    public void delete(Integer id)
    {
        Event event = get(id);
        if (event != null)
            sessionFactory.getCurrentSession().delete(event.getEntity());
    }
}
