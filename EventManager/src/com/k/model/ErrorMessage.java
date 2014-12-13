package com.k.model;

public class ErrorMessage
{
    private Integer status;
    private String title;
    private String error;
    
    public ErrorMessage()
    {        
    }
    
    public ErrorMessage(Integer status, String title, String error)
    {
        this.status = status;
        this.title = title;
        this.error = error;
    }
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getError()
    {
        return error;
    }
    
    public void setError(String error)
    {
        this.error = error;
    }
}
