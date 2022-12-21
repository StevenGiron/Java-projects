package org.aguzman.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa");
        nombres.forEach(System.out::println);

        System.out.println("");

        String[] arr = {"Pato", "Paco", "Pepa"};
        Stream<String> nombres2 = Arrays.stream(arr);
        nombres2.forEach(System.out::println);

        System.out.println("");

        Stream<String> nombres3 = Stream.<String>builder()
                .add("Pato")
                .add("Paco")
                .add("Pepe")
                .build();
        nombres3.forEach(System.out::println);

        System.out.println("");

        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");

        Stream<String > nombres4 = lista.stream();
        nombres4.forEach(System.out::println);

    }
}
