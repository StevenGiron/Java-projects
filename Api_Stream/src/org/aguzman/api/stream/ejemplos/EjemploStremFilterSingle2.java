package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStremFilterSingle2 {
    public static void main(String[] args) {
        Usuario usuario = Stream
                .of("Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                //.peek(System.out::println)
                .filter(u -> u.getId().equals(2))
                .findFirst().orElseGet(()-> new Usuario("John", "Doe"));
        System.out.println(usuario);
    }
}
