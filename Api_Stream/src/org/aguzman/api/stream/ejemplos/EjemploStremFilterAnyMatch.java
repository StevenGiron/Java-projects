package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStremFilterAnyMatch {
    public static void main(String[] args) {
        Boolean existe = Stream
                .of("Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .anyMatch(u -> u.getId().equals(1));
        System.out.println(existe);
    }
}
