package com.k.customEditorTypes;

import java.beans.PropertyEditorSupport;

import com.k.model.StateModel;

public class StateModelEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        StateModel value = (StateModel) getValue();
        
        if (value != null)
            return value.getId().toString();
        else
            return "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        if (text != null && !text.equals("0"))
        {
            StateModel model = new StateModel();
            model.setId(Byte.parseByte(text));
            setValue(model);
        }
        else
            setValue(null);
    }    
}
