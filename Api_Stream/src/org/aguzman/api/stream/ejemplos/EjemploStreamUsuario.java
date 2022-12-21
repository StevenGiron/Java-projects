package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamUsuario {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("Steven Giron", "Sebastian Arcila", "Juan Jaramillo", "Diego Marin")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });
        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
    }
}
