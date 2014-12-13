package com.k.business;

import java.util.SortedSet;

import com.k.model.IndustryModel;

public interface IndustryFactory
{
    public SortedSet<Industry> getSet();
    public Industry get(Integer id);
    public Industry getByName(String name);
    public Industry create(IndustryModel model);
}
