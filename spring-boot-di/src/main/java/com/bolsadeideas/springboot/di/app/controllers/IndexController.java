package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //Inyectar como atributo
    @Autowired
    @Qualifier("miServicioComplejo")
    private IServicio servicio;

    @GetMapping({"/", "", "/index"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

    //Inyectar con setter
    /*@Autowired
    public void setServicio(IServicio servicio) {
        this.servicio = servicio;
    }*/
}

