package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Steven", "Girón"));
        usuarios.add(new Usuario("Steven", "Arcila"));
        usuarios.add(new Usuario("Sebastian", "Girón"));
        usuarios.add(new Usuario("Juan", "Jaramillo"));
        usuarios.add(new Usuario("Diego", "Marin"));

        Stream<String> nombres =  usuarios.stream()
                .map(usuario -> usuario.getNombre().toUpperCase()
                .concat(" ")
                .concat(usuario.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if (nombre.contains("Steven".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);
        System.out.println(nombres.count());
    }
}
