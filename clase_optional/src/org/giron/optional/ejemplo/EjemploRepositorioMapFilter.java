package org.giron.optional.ejemplo;

import org.giron.optional.ejemplo.models.Computador;
import org.giron.optional.ejemplo.models.Fabricante;
import org.giron.optional.ejemplo.models.Procesador;
import org.giron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.giron.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Fabricante fabricante = repositorio.filtrar("asus rog")
                .map(Computador::getProcesador)//Primero obtengo el procesador
                .map(Procesador::getFabricante)//Del procesador obtengo el fabricante
                .filter(f -> f.getNombre().equalsIgnoreCase("intel"))
                .orElseThrow();
        System.out.println("fabricante = " + fabricante.getNombre());

    }

}
