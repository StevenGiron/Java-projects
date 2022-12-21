package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStremFilterEmpty {
    public static void main(String[] args) {
        long cantidad = Stream
                .of("Steven Giron", "Sebastian Giron", "Juan Jaramillo", "")
                .filter(String::isEmpty)
                .count();
        System.out.println(cantidad);
    }
}
