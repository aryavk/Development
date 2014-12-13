package com.k.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="industry")
public class IndustryEntity extends KEntity<Integer> implements Comparable<IndustryEntity>
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "name")
    private String name;

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
    
    @Override
    public int compareTo(IndustryEntity o)
    {
        return getId().compareTo(o.getId());
    }
}
