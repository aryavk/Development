package com.k.model;

import java.util.Calendar;

import net.minidev.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.k.common.JSONModelable;
import com.k.common.Utilities;

public class EventModel extends KModel<Integer> implements JSONModelable
{
    private Integer id;
    private String name;
    private IndustryModel industry;
    private StateModel state;
    private String location;
    private String venue;
    private String website;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy", timezone = "Australia/NSW")
    private Calendar fromDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy", timezone = "Australia/NSW")
    private Calendar toDate;    
    private String responsiblePeople;
    private String pros;
    private String cons;  
    private Boolean attending;    
    private long fromDateMillis;
    private long toDateMillis;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public IndustryModel getIndustry()
    {
        return industry;
    }

    public void setIndustry(IndustryModel industry)
    {
        this.industry = industry;
    }

    public StateModel getState()
    {
        return state;
    }

    public void setState(StateModel state)
    {
        this.state = state;
    }

    public String getLocation()
    {
        return location;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public String getVenue()
    {
        return venue;
    }
    
    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    
    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Calendar getFromDate()
    {
        return fromDate;
    }
    
    public void setFromDate(Calendar fromDate)
    {
        this.fromDate = fromDate;
    }
    
    public Calendar getToDate()
    {
        return toDate;
    }
    
    public void setToDate(Calendar toDate)
    {
        this.toDate = toDate;
    }        
    
    public String getResponsiblePeople()
    {
        return responsiblePeople;
    }

    public void setResponsiblePeople(String responsiblePeople)
    {
        this.responsiblePeople = responsiblePeople;
    }

    public String getPros()
    {
        return pros;
    }

    public void setPros(String pros)
    {
        this.pros = pros;
    }

    public String getCons()
    {
        return cons;
    }

    public void setCons(String cons)
    {
        this.cons = cons;
    }    

    public Boolean getAttending()
    {
        return attending;
    }

    public void setAttending(Boolean attending)
    {
        this.attending = attending;
    }
    
    public long getFromDateMillis()
    {
        return fromDateMillis;
    }

    public void setFromDateMillis(long fromDateMillis)
    {
        this.fromDateMillis = fromDateMillis;
    }

    public long getToDateMillis()
    {
        return toDateMillis;
    }

    public void setToDateMillis(long toDateMillis)
    {
        this.toDateMillis = toDateMillis;
    }

    public void validate()
    {
        if (getName() == null || getName().isEmpty())
            throw new IllegalArgumentException("Name must be provided");
        
        if (getIndustry() == null)
            throw new IllegalArgumentException("Industry must be provided");
        
        if (getState() == null)
            throw new IllegalArgumentException("State must be provided");
        
        if (getFromDate() == null)
            throw new IllegalArgumentException("Must specify the date the event starts");
        
        if (getToDate() == null)
            throw new IllegalArgumentException("Must specify the date the event finishes");
        
        if (getFromDate().after(getToDate()))
            throw new IllegalArgumentException("Start date must be before end date");
    }

    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        
        json.put("id", getId());
        json.put("name", getName());
        json.put("industry", getIndustry().toJson());
        json.put("location", getLocation());
        json.put("state", getState().toJson());
        json.put("venue", getVenue());
        json.put("website", getWebsite());
        json.put("fromDate", Utilities.calendarToString(getFromDate()));
        json.put("toDate", Utilities.calendarToString(getToDate()));
        json.put("pros", getPros());
        json.put("cons", getCons());
        json.put("attending", getAttending());
        json.put("fromDateMillis", getFromDate().getTimeInMillis());
        json.put("toDateMillis", getToDate().getTimeInMillis());
        
        return json;
    }
}
