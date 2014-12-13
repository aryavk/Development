package com.k.business;

import java.util.SortedSet;

public interface UserFactory
{
    public User get(Integer id);
    public User getByUsername(String username);
    public SortedSet<User> getSet();
}
