package com.k.hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity extends KEntity<Integer> implements Comparable<UserEntity>
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "enabled")
    private Boolean enabled;
    
    @OneToMany(mappedBy = "user")
    private Set<UserRoleEntity> userRoles;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    public Set<UserRoleEntity> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoleEntity> userRoles)
    {
        this.userRoles = userRoles;
    }

    public int compareTo(UserEntity other)
    {
        return getId().compareTo(other.getId());
    }        
}
