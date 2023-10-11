package com.infinite.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOut {
	@RequestMapping(value="/logout",method=RequestMethod.POST)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "index1";
    }

}
