package com.bolsadeideas.springboot.app.springboot.web.controllers;

import com.bolsadeideas.springboot.app.springboot.web.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app") //ruta de primer nivel y comun para todos los metodos
public class IndexController {
    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    //@GetMapping(value = "/index") //solo un valor para la ruta

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({"/index", "/", "", "/home"}) //para dar mas de una ruta
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Steven");
        usuario.setApellido("Girón");
        usuario.setEmail(usuario.getNombre() + "." + usuario.getApellido() + "@gmail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping(value = "/listar")
    public String listar(Model model){
        /*List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Sebastian", "Giron", "sebastian@gmail.com"));
        usuarios.add(new Usuario("Juan", "Jaramillo", "juan@gmail.com"));
        usuarios.add(new Usuario("Diego", "Marin", "diego@gmail.com"));
         */
        model.addAttribute("titulo", textoListar);
        //model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    @ModelAttribute("usuarios") //Permite que todos los handlers o métodos tengan acceso a estos datos
    public List<Usuario> pasarUsuariosALaVista(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Sebastian", "Giron", "sebastian@gmail.com"),
                new Usuario("Juan", "Jaramillo", "juan@gmail.com"),
                new Usuario("Diego", "Marin", "diego@gmail.com"));
        return usuarios;
    }
}
