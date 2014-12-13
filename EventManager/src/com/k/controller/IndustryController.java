package com.k.controller;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.k.model.IndustryModel;
import com.k.service.IndustryService;

@RestController
public class IndustryController
{
    @Autowired
    private IndustryService industryService;
    
    @RequestMapping(value = "/industryCreate.action", method = RequestMethod.POST, consumes ="application/json")
    private @ResponseBody Integer industryCreate(@RequestBody IndustryModel model)
    {
        IndustryModel result = industryService.create(model);
        
        return result.getId();
    }
    
    @RequestMapping(value = "/industryList.action", method = RequestMethod.GET)
    private @ResponseBody SortedSet<IndustryModel> industryListTest()
    {
        return industryService.getIndustries();
    }
}
