package com.k.business;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k.hibernate.UserEntity;

@Component("userFactoryImpl")
public class UserFactoryImpl implements UserFactory
{
    @Autowired
    private SessionFactory sessionFactory;
    
    public User get(Integer id)
    {
        UserEntity entity = (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
        
        return new User(entity);
    }
    
    public User getByUsername(String username)
    {
        @SuppressWarnings("unchecked")
        List<UserEntity> entities = (List<UserEntity>) sessionFactory.getCurrentSession().createCriteria(UserEntity.class)
                .add(Restrictions.eqOrIsNull("username", username))
                .list();
        
        if (entities.size() == 0)
            throw new IllegalArgumentException("No user found for username: " + username);
        else
            return new User(entities.get(0));
    }
    
    public SortedSet<User> getSet()
    {
        SortedSet<User> result = new TreeSet<User>();
        
        @SuppressWarnings("unchecked")
        List<UserEntity> list = sessionFactory.getCurrentSession().createCriteria(UserEntity.class).list();
        
        for (UserEntity entity : list)
            result.add(get(entity.getId()));
        
        return result;
    }
}
