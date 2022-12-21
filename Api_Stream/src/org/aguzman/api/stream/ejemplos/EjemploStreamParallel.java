package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Steven", "Girón"));
        usuarios.add(new Usuario("Steven", "Arcila"));
        usuarios.add(new Usuario("Sebastian", "Girón"));
        usuarios.add(new Usuario("Juan", "Jaramillo"));
        usuarios.add(new Usuario("Diego", "Marin"));

        long t1 = System.currentTimeMillis();
        String nombres =  usuarios.stream()
                .parallel() //Los procesos se llevan a cabo en threads distintos
                .map(usuario -> usuario.toString().toUpperCase())
                .peek(n -> {
                    System.out.println("Nombre Thread " + Thread.currentThread() + " - " + n);
                })
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (nombre.contains("Steven".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2-t1) + " milisegundos");
        System.out.println("");
        System.out.println(nombres);
    }
}
