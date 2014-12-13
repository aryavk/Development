package com.k.customEditorTypes;

import java.beans.PropertyEditorSupport;

import com.k.model.IndustryModel;

public class IndustryModelEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        IndustryModel value = (IndustryModel) getValue();
        
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
            IndustryModel model = new IndustryModel();
            model.setId(Integer.parseInt(text));
            setValue(model);
        }
        else
            setValue(null);
    }
}
