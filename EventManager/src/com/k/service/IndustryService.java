package com.k.service;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k.business.FactoryManager;
import com.k.business.Industry;
import com.k.model.IndustryModel;

@Service
public class IndustryService
{
    @Autowired    
    private FactoryManager factoryManager;
    
    @Transactional(readOnly = true)
    public SortedSet<IndustryModel> getIndustries()
    {
        SortedSet<IndustryModel> result = new TreeSet<IndustryModel>();
        
        for (Industry entity : factoryManager.getIndustryFactory().getSet())
        {
            result.add(entity.toModel());            
        }
        
        return result;
    }
    
    @Transactional
    public IndustryModel create(IndustryModel model)
    {
        return factoryManager.getIndustryFactory().create(model).toModel();
    }
}
