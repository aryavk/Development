package com.k.controller;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.k.customEditorTypes.CalendarEditor;
import com.k.customEditorTypes.StateModelEditor;
import com.k.customEditorTypes.IndustryModelEditor;
import com.k.model.ErrorMessage;
import com.k.model.StateModel;
import com.k.model.IndustryModel;

@ControllerAdvice
public class GlobalBindingInitializer
{
    @InitBinder
    public void binder(WebDataBinder binder) 
    {
        binder.registerCustomEditor(Calendar.class, new CalendarEditor());
        binder.registerCustomEditor(StateModel.class, new StateModelEditor());
        binder.registerCustomEditor(IndustryModel.class, new IndustryModelEditor());
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessage handleError(IllegalArgumentException e) 
    {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getClass().getSimpleName(), e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    public @ResponseBody ErrorMessage handleError(Exception e) 
    {
        String message = e.getMessage();
        if (message == null || message.length() == 0)
            message = "An error has occured. Please contact system administrator";
        return new ErrorMessage(HttpStatus.I_AM_A_TEAPOT.value(), e.getClass().getSimpleName(), message);
    }
}
