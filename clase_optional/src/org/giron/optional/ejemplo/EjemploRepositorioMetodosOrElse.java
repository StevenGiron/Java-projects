package org.giron.optional.ejemplo;

import org.giron.optional.ejemplo.models.Computador;
import org.giron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.giron.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        Computador porDefecto = new Computador("HP Ome", "LA0001");

        //orElse siempre llama el valor por defecto sin importar si existe el objeto que se está buscando
        Computador pc =  repositorio.filtrar("asus rog").orElse(valorDefecto());

        System.out.println(pc);

        //orElseGet nunca llama el valor por defecto si existe el objeto que se está buscando (más óptimo)
        pc = repositorio.filtrar("MacBook Pro").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println(pc);
    }
    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP Ome", "LA0001");
    }
}
