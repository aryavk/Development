package com.k.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class LoginController
{
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, 
            HttpServletRequest request,
            Model model) 
    {
        if (logout != null) 
        {
            model.addAttribute("error", error);
        }
        
        if (logout != null) 
        {
            model.addAttribute("msg", "You've been logged out successfully.");
        }        

        return "login";
    }
    
    @RequestMapping(value = "/loginError.action", method = RequestMethod.GET)
    public String accessDenied(Model model) 
    {
        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) 
        {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addAttribute("username", userDetail.getUsername());
        }
        
        return "loginError";
    }
}
