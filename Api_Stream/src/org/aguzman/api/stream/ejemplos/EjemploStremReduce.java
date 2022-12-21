package org.aguzman.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStremReduce {
    public static void main(String[] args) {
        Stream<String> nombres = Stream
                .of("Steven Giron", "Juan Jaramillo", "Sebastian Giron", "Juan Jaramillo", "Sebastian Giron")
                .distinct();
        String resultado = nombres.reduce("Resultado", (a, b) -> a + ", " + b);
        System.out.println(resultado);

    }
}
