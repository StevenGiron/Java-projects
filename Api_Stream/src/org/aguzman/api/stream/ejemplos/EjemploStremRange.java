package org.aguzman.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStremRange {
    public static void main(String[] args) {
        IntStream numeros = IntStream
                .range(1, 10)
                .peek(System.out::println);

        //int resultado = numeros.reduce(0, Integer::sum);
        //int resultado = numeros.sum();
        //System.out.println("Suma = " + resultado);

        System.out.println("");

        IntSummaryStatistics stats = numeros.summaryStatistics();
        System.out.println("Maximo = " + stats.getMax());
        System.out.println("Minimo = " + stats.getMin());
        System.out.println("Suma = " + stats.getSum());
        System.out.println("Promedio = " + stats.getAverage());
    }
}
