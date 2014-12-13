package com.k.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This controller is responsible for returning the views used by the application
 * All the data that comes from the server comes from REST based JSON calls
 * @author arya
 */
@Controller
public class ViewController
{
    @RequestMapping(value = "/eventCreate.action", method = RequestMethod.GET)
    private String eventCreate(Model model)
    {
        return "events/eventCreate";
    }
    
    @RequestMapping(value = "/eventModify.action", method = RequestMethod.GET)
    private String eventModify(@RequestParam Integer id, Model model)
    {
        return "events/eventModify";
    }
    
    @RequestMapping(value = "/eventCalendar.action", method = RequestMethod.GET)
    private String eventCalendar(Model model)
    {
        return "events/eventCalendar";
    }
    
    @RequestMapping(value = "/industryCreate.action", method = RequestMethod.GET)
    private String industryCreate(Model model)
    {
        return "industries/industryCreate";
    }
    
    @RequestMapping(value = "/industries.action", method = RequestMethod.GET)
    private String industryList(Model model)
    {
        return "industries/industryList";
    }
    
    @RequestMapping(value = "/events.action", method = RequestMethod.GET)
    private String eventList(@RequestParam(required = false) Byte stateId, Model model)
    {
        return "events/eventList";
    }
}
