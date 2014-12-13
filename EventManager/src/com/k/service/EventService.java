package com.k.service;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k.business.FactoryManager;
import com.k.business.Event;
import com.k.model.EventModel;

@Service
public class EventService
{
    @Autowired    
    private FactoryManager factoryManager;
    
    @Transactional(readOnly = true)
    public SortedSet<EventModel> getEvents(Byte stateId, Integer industryId)
    {
        SortedSet<EventModel> result = new TreeSet<EventModel>();
        
        SortedSet<Event> events = new TreeSet<Event>();
        
        events = factoryManager.getEventFactory().searchEvents(stateId, industryId);
        
        for (Event entity : events)
        {
            result.add(entity.toModel());            
        }
        
        return result;
    }
    
    @Transactional(readOnly = true)
    public EventModel get(Integer id)
    {
        return factoryManager.getEventFactory().get(id).toModel();
    }
    
    @Transactional
    public EventModel create(EventModel model)
    {
        return factoryManager.getEventFactory().create(model).toModel();
    }
    
    @Transactional
    public EventModel modify(Integer id, EventModel model)
    {
        Event event = factoryManager.getEventFactory().get(id);
        event.modify(model);
        return event.toModel();
    }
    
    @Transactional
    public void delete(Integer id)
    {
        factoryManager.getEventFactory().delete(id);
    }
    
    @Transactional
    public void attend(Integer id)
    {
        Event event = factoryManager.getEventFactory().get(id);
        event.setAttending(true);
    }
    
    @Transactional
    public void notAttend(Integer id)
    {
        Event event = factoryManager.getEventFactory().get(id);
        event.setAttending(false);
    }
}
