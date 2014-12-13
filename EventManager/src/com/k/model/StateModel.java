package com.k.model;

import net.minidev.json.JSONObject;

import com.k.common.JSONModelable;

public class StateModel extends KModel<Byte> implements JSONModelable
{
    private Byte id;
    private String name;
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
        
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        
        json.put("id", getId());
        json.put("name", getDescription());
        json.put("abbr", getName());
        
        return json;
    }
}
