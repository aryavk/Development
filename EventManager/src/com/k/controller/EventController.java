package com.k.controller;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.k.model.EventModel;
import com.k.service.EventService;

@RestController
public class EventController
{
    @Autowired
    private EventService eventService;
    
    @RequestMapping(value = "/eventCreate.action", method = RequestMethod.POST)
    private @ResponseBody Integer eventCreate(@RequestBody EventModel model)
    {
        EventModel result = eventService.create(model);
        
        return result.getId();
    }
    
    @RequestMapping(value = "/eventModify.action", method = RequestMethod.POST)
    private @ResponseBody Integer eventModify(@RequestBody EventModel model)
    {
        EventModel result = eventService.modify(model.getId(), model);
        
        return result.getId();
    }
    
    @RequestMapping(value = "/eventAttend.action", method = RequestMethod.POST)
    private @ResponseBody String eventAttend(@RequestParam Integer id)
    {
        eventService.attend(id);
        
        return "success";
    }
    
    @RequestMapping(value = "/eventDelete.action", method = RequestMethod.DELETE)
    private @ResponseBody String eventDelete(@RequestParam Integer id)
    {
        eventService.delete(id);
        
        return "success";
    }
    
    @RequestMapping(value = "/eventNotAttend.action", method = RequestMethod.POST)
    private @ResponseBody String eventNotAttend(@RequestParam Integer id)
    {
        eventService.notAttend(id);
        
        return "success";
    }
    
    @RequestMapping(value = "/eventRead.action", method = RequestMethod.GET)
    private @ResponseBody EventModel eventRead(@RequestParam Integer id)
    {
        return eventService.get(id);
    }
    
    @RequestMapping(value = "/eventList.action", method = RequestMethod.GET)
    private @ResponseBody SortedSet<EventModel> eventList(@RequestParam(required = false) Byte stateId,
                                                          @RequestParam(required = false) Integer industryId)
    {
        return eventService.getEvents(stateId, industryId);
    }
}
