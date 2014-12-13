package com.k.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k.business.FactoryManager;

@Service("kUserDetailsService")
public class KUserDetailsService implements UserDetailsService
{
    @Autowired    
    private FactoryManager factoryManager;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {
        com.k.business.User user = factoryManager.getUserFactory().getByUsername(username);
        
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
 
        return buildUserForAuthentication(user, authorities);
    }
    
    private User buildUserForAuthentication(com.k.business.User user, List<GrantedAuthority> authorities) 
    {
        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
    }
     
    private List<GrantedAuthority> buildUserAuthority(List<String> userRoles) 
    { 
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
        // Build user's authorities
        for (String userRole : userRoles) 
        {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }
 
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
 
        return result;
    }
}
