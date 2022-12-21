package org.giron.optional.ejemplo;

import org.giron.optional.ejemplo.models.Computador;
import org.giron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.giron.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        /* Optional<Computador> pc = repositorio.filtrar("asus rog");

        if(pc.isPresent()){
            System.out.println(pc.get().toString());
        }else{
            System.out.println("No se encontró");
        }*/

        repositorio.filtrar("asus rog").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontró"));

    }
}
