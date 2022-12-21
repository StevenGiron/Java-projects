package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStremDistinctUsuario {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("Steven Giron", "Steven Giron", "Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();
        nombres.forEach(System.out::println);
    }
}
