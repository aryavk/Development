package com.k.controller;

import java.util.SortedSet;
import java.util.TreeSet;

import net.minidev.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.k.model.KModel;
import com.k.common.JSONModelable;
import com.k.service.CommonService;

@Controller
public class CommonController
{
    @Autowired
    private CommonService commonService;
    
    @RequestMapping("/getStates.action")
    private @ResponseBody String getStates(Model model)
    {
        return constructJsonSet(commonService.getStates()).toString();
    }
    
    @RequestMapping("/getIndustries.action")
    private @ResponseBody String getIndustries(Model model)
    {
        return constructJsonSet(commonService.getIndustries()).toString();
    }
    
    private JSONArray constructJsonSet(SortedSet<? extends KModel<?>> models)
    {
        JSONArray json = new JSONArray();
        
        SortedSet<KModel<?>> sortedModels = new TreeSet<KModel<?>>(KModel.getDisplayComparator());
        
        sortedModels.addAll(models);
        
        for (KModel<?> model : sortedModels)
        {
            json.add(((JSONModelable) model).toJson());
        }
        
        return json;
    }
}
