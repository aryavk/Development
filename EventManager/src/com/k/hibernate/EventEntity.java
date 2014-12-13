package com.k.hibernate;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class EventEntity extends KEntity<Integer> implements Comparable<EventEntity>
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "industry_id", referencedColumnName = "id")
    private IndustryEntity industry;
    
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private StateEntity state;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "venue")
    private String venue;
    
    @Column(name = "website")
    private String website;
    
    @Column(name = "from_date")
    private Calendar fromDate;
    
    @Column(name = "to_date")
    private Calendar toDate;
    
    @Column(name = "responsible_people")
    private String responsiblePeople;
    
    @Column(name = "pros")
    private String pros;
    
    @Column(name = "cons")
    private String cons;
    
    @Column(name = "attending")
    private Boolean attending;
    
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

    public IndustryEntity getIndustry()
    {
        return industry;
    }

    public void setIndustry(IndustryEntity industry)
    {
        this.industry = industry;
    }
    
    public StateEntity getState()
    {
        return state;
    }

    public void setState(StateEntity state)
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

    @Override
    public int compareTo(EventEntity o)
    {
        return getId().compareTo(o.getId());
    }
}
