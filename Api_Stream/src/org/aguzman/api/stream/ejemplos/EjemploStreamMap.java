package org.aguzman.api.stream.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {
        Stream<String> nombres = Stream
                .of("Pato", "Paco", "Pepa", "Pepe")

                //Se usa solo para inspeccionar la data
                .peek(System.out::println)

                //Se usa para modificar los datos del flujo
                .map(String::toUpperCase);

        //Transformar el flujo a una lista
        //List<String> lista = nombres.collect(Collectors.toList());
        //lista.forEach(System.out::println);

        nombres.forEach(System.out::println);
    }
}
