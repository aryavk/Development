package com.k.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryManager
{
    @Autowired
    @Qualifier("stateFactoryImpl")
    private StateFactory stateFactory;
    
    @Autowired
    @Qualifier("industryFactoryImpl")
    private IndustryFactory industryFactory;
    
    @Autowired
    @Qualifier("eventFactoryImpl")
    private EventFactory eventFactory;
    
    @Autowired
    @Qualifier("userFactoryImpl")
    private UserFactory userFactory;

    public StateFactory getStateFactory()
    {
        return stateFactory;
    }

    public IndustryFactory getIndustryFactory()
    {
        return industryFactory;
    }

    public EventFactory getEventFactory()
    {
        return eventFactory;
    }

    public UserFactory getUserFactory()
    {
        return userFactory;
    }       
}
