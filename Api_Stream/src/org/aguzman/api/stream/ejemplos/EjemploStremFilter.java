package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStremFilter {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(usuario -> usuario.getNombre().equals("Steven"));
        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
    }
}
