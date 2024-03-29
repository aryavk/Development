package com.k.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class StateEntity extends KEntity<Byte> implements Comparable<StateEntity>
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Byte id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
        public Byte getId()
    {
        return id;
    }

    public void setId(Byte id)
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int compareTo(StateEntity o)
    {
        return getId().compareTo(o.getId());
    }        
}
