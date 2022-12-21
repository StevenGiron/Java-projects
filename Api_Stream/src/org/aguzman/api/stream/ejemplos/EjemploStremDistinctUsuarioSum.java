package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStremDistinctUsuarioSum {
    public static void main(String[] args) {
        IntStream largoNombres = Stream
                .of("Steven Giron", "Steven Giron", "Steven Giron", "Sebastian Giron ", "Juan Jaramillo", "Steven Arcila")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Suma = " + stats.getSum());
        System.out.println("Mínimo = " + stats.getMin());
    }
}
