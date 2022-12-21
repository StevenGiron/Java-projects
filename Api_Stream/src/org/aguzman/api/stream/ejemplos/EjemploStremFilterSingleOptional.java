package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStremFilterSingleOptional {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(usuario -> usuario.getNombre().equals("Steven"));

        Optional<Usuario> usuario = nombres.findFirst();

        System.out.println(usuario.orElse(new Usuario("John", "Doe")).getNombre());
        System.out.println(usuario.orElseGet(() ->new Usuario("John", "Doe")).getNombre());

        if(usuario.isPresent()){
            System.out.println(usuario.get().getNombre());
        }else {
            System.out.println("No se encontró el objeto");
        }

        System.out.println(usuario.orElseThrow());

    }
}
