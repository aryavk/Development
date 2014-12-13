package com.k.common;

import com.k.model.KModel;

public interface Modelable
{
    public KModel<?> toModel();    
}
