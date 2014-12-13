package com.k.business;

import java.util.SortedSet;

import com.k.model.EventModel;

public interface EventFactory
{
    public SortedSet<Event> getSet();
    public SortedSet<Event> searchEvents(Byte stateId, Integer industryId);
    public Event get(Integer id);
    public Event create(EventModel model);
    public void delete(Integer id);
}
