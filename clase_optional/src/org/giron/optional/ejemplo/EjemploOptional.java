package org.giron.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        String nombre = "Steven";
        Optional<String> opt = Optional.of(nombre);
        System.out.println(opt);
        System.out.println(opt.isPresent());
        if (opt.isPresent()) {
            System.out.println("Hola " + opt);
        }
        opt.ifPresent(valor -> System.out.println("Hola " + valor));

        System.out.println("");

        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println(opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        opt.ifPresentOrElse(h -> System.out.println("hola " + h), () -> System.out.println("Esta vacío"));

        System.out.println("");

        Optional<String> optEmpty = Optional.empty();
        System.out.println(optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
