package com.k.business;

import java.util.ArrayList;
import java.util.List;

import com.k.hibernate.UserEntity;
import com.k.hibernate.UserRoleEntity;

public class User extends DomainObject<Integer, UserEntity>
{
    User(UserEntity entity)
    {
        super(entity);
    }
    
    public String getName()
    {
        return getUsername();
    }
    
    public String getUsername()
    {
        return getEntity().getUsername();
    }
    
    public String getPassword()
    {
        return getEntity().getPassword();
    }
    
    public Boolean getEnabled()
    {
        return getEntity().getEnabled();
    }
    
    public List<String> getRoles()
    {
        List<String> roles = new ArrayList<String>();
        
        for (UserRoleEntity role : getEntity().getUserRoles())
            roles.add(role.getUserRole());
        
        return roles;
    }
}
