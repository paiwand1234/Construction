package com.mvcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



// MAKE LINKS TO THE VIEWS USING THIS CLASS
@Controller
public class Views {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello");
    }
    @RequestMapping("/hi")
    public ModelAndView hi() {
        return new ModelAndView("hello");
    }

}
