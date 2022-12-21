package org.aguzman.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStremDistinct {
    public static void main(String[] args) {
        Stream<String> nombres = Stream
                .of("Steven Giron", "Juan Jaramillo", "Sebastian Giron", "Juan Jaramillo", "Sebastian Giron")
                .distinct();
        nombres.forEach(System.out::println);

    }
}
