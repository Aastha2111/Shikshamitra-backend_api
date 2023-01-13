package com.ncuindia.peermentoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping()
    @ResponseBody
    public String homePage(){
        return "<h1><center>Welcome to Peer Mentoring API.</center></h1>";
    }
}