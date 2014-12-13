package com.k.business;

import com.k.common.Modelable;
import com.k.hibernate.StateEntity;
import com.k.model.StateModel;

public class State extends DomainObject<Byte, StateEntity> implements Modelable
{
    State(StateEntity e)
    {
        super(e);
    }
    
    public String getName()
    {
        return getEntity().getName();
    }
    
    public String getDescription()
    {
        return getEntity().getDescription();
    }
    
    public StateModel toModel()
    {
        StateModel model = new StateModel();
        
        model.setId(getId());
        model.setDescription(getDescription());
        model.setName(getName());
        
        return model;
    }
}
