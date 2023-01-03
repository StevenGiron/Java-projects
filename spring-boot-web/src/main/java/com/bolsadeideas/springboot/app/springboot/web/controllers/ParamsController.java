package com.bolsadeideas.springboot.app.springboot.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "Valor por defecto") String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String params(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("resultado2",
                "El saludo enviado es: " + saludo + " y el número es: " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-httpservlet")
    public String params(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado2",
                "El saludo enviado es: " + saludo + " y el número es: " + numero);
        return "params/ver";
    }
}
