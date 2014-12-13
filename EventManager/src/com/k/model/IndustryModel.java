package com.k.model;

import net.minidev.json.JSONObject;

import com.k.common.JSONModelable;

public class IndustryModel extends KModel<Integer> implements JSONModelable
{
    private Integer id;
    private String name;
    
    public IndustryModel()
    {        
    }

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
    
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        
        json.put("id", getId());
        json.put("name", getName());
        
        return json;
    }
}
