package com.bolsadeideas.springboot.app.springboot.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        //return "redirect:/app/index";
        return "forward:/app/index"; //Sin realizar nuevamente las peticiones http, la mejor opcion para paginas home
    }
}
