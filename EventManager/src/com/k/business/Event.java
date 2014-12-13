package com.k.business;

import java.util.Calendar;

import com.k.common.Modelable;
import com.k.hibernate.EventEntity;
import com.k.model.EventModel;

public class Event extends DomainObject<Integer, EventEntity> implements Modelable
{
    Event(EventEntity entity)
    {
        super(entity);
    }
    
    public String getName()
    {
        return getEntity().getName();
    }
    
    public State getState()
    {
        return getFactoryManager().getStateFactory().get(getEntity().getState().getId());
    }
    
    public String getLocation()
    {
        return getEntity().getLocation();
    }
    
    public Industry getIndustry()
    {
        return getFactoryManager().getIndustryFactory().get(getEntity().getIndustry().getId());
    }
    
    public Calendar getFromDate()
    {
        return getEntity().getFromDate();
    }
    
    public Calendar getToDate()
    {
        return getEntity().getToDate();
    }
    
    public String getVenue()
    {
        return getEntity().getVenue();
    }
    
    public String getWebsite()
    {
        return getEntity().getWebsite();
    }
    
    public String getResponsiblePeople()
    {
        return getEntity().getResponsiblePeople();
    }
    
    public String getPros()
    {
        return getEntity().getPros();
    }
    
    public String getCons()
    {
        return getEntity().getCons();
    }
    
    public Boolean getAttending()
    {
        return getEntity().getAttending();
    }
    
    public void setName(String name)
    {
        getEntity().setName(name);
    }
    
    public void setVenue(String venue)
    {
        getEntity().setVenue(venue);
    }
    
    public void setWebsite(String website)
    {
        getEntity().setWebsite(website);
    }
    
    public void setFromDate(Calendar fromDate)
    {
        getEntity().setFromDate(fromDate);
    }
    
    public void setToDate(Calendar toDate)
    {
        getEntity().setToDate(toDate);
    }
    
    public void setLocation(String location)
    {
        getEntity().setLocation(location);
    }
    
    public void setState(State state)
    {
        getEntity().setState(state.getEntity());
    }
    
    public void setIndustry(Industry industry)
    {
        getEntity().setIndustry(industry.getEntity());
    }
    
    public void setPros(String pros)
    {
        getEntity().setPros(pros);
    }
    
    public void setCons(String cons)
    {
        getEntity().setCons(cons);
    }
    
    public void setResponsiblePeople(String responsiblePeople)
    {
        getEntity().setResponsiblePeople(responsiblePeople);
    }
    
    public void setAttending(Boolean attending)
    {
        getEntity().setAttending(attending);
    }
    
    public EventModel toModel()
    {
        EventModel model = new EventModel();
        
        model.setId(getId());
        model.setLocation(getLocation());
        model.setState(getState().toModel());
        model.setIndustry(getIndustry().toModel());
        model.setName(getName());
        model.setVenue(getVenue());
        model.setWebsite(getWebsite());
        model.setFromDate(getFromDate());
        model.setToDate(getToDate());
        model.setResponsiblePeople(getResponsiblePeople());
        model.setPros(getPros());
        model.setCons(getCons());
        model.setAttending(getAttending());
        model.setFromDateMillis(getFromDate().getTimeInMillis());
        model.setToDateMillis(getToDate().getTimeInMillis());
        
        return model;
    }
    
    public void modify(EventModel model)
    {
        model.validate();
        
        setName(model.getName());
        setVenue(model.getVenue());
        setWebsite(model.getWebsite());
        setFromDate(model.getFromDate());
        setToDate(model.getToDate());
        setLocation(model.getLocation());
        setState(getFactoryManager().getStateFactory().get(model.getState().getId()));
        setIndustry(getFactoryManager().getIndustryFactory().get(model.getIndustry().getId()));
        setPros(model.getPros());
        setCons(model.getCons());
        setResponsiblePeople(model.getResponsiblePeople());
    }
}
