package com.yubraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yubraj on 6/28/16.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

}
