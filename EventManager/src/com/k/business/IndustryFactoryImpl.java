package com.k.business;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k.hibernate.IndustryEntity;
import com.k.model.IndustryModel;

@Component("industryFactoryImpl")
public class IndustryFactoryImpl implements IndustryFactory
{
    @Autowired
    private SessionFactory sessionFactory;
    
    public SortedSet<Industry> getSet()
    {
        SortedSet<Industry> result = new TreeSet<Industry>();
        
        @SuppressWarnings("unchecked")
        List<IndustryEntity> list = sessionFactory.getCurrentSession().createCriteria(IndustryEntity.class).list();
        
        for (IndustryEntity entity : list)
            result.add(get(entity.getId()));
        
        return result;
    }
    
    public Industry get(Integer id)
    {
        IndustryEntity entity = (IndustryEntity) sessionFactory.getCurrentSession().get(IndustryEntity.class, id);
        
        return new Industry(entity);
    }
    
    public Industry getByName(String name)
    {
        @SuppressWarnings("unchecked")
        List<IndustryEntity> entities = (List<IndustryEntity>) sessionFactory.getCurrentSession().createCriteria(IndustryEntity.class)
                .add(Restrictions.eq("name", name))
                .list();
        
        if (entities.size() ==  1)
            return new Industry(entities.get(0));
        else
            return null;
    }
    
    public Industry create(IndustryModel model)
    {
        if (getByName(model.getName()) != null)
            throw new IllegalArgumentException("Industry for name already exists: " + model.getName());
        
        IndustryEntity entity = new IndustryEntity();
        
        entity.setName(model.getName());
        
        sessionFactory.getCurrentSession().save(entity);
        
        return new Industry(entity);
    }
}
