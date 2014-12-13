package com.k.business;

import com.k.common.Modelable;
import com.k.hibernate.IndustryEntity;
import com.k.model.IndustryModel;

public class Industry extends DomainObject<Integer, IndustryEntity> implements Modelable
{
    Industry(IndustryEntity entity)
    {
        super(entity);
    }
    
    public String getName()
    {
        return getEntity().getName();
    }
    
    public IndustryModel toModel()
    {
        IndustryModel model = new IndustryModel();
        
        model.setId(getId());
        model.setName(getName());
        
        return model;
    }
}
