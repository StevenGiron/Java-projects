package org.aguzman.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStremReduceInt {
    public static void main(String[] args) {
        Stream<Integer> numeros = Stream
                .of(3, 4, 6, 10);

        //int resultado = numeros.reduce(0, (a, b) -> a + b);
        int resultado = numeros.reduce(0, Integer::sum);
        System.out.println(resultado);

    }
}
