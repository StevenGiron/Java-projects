package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miServicio")
@Primary
public class MiServicio implements IServicio{

    public String operacion(){
        return "Ejecutando algún proceso...";
    }
}
