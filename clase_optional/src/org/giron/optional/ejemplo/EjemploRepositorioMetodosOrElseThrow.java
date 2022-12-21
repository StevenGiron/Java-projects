package org.giron.optional.ejemplo;

import org.giron.optional.ejemplo.models.Computador;
import org.giron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.giron.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador porDefecto = new Computador("HP Omen", "LA0001");

        Computador pc =  repositorio.filtrar("asus rog").orElseThrow(IllegalStateException::new);
        System.out.println(pc);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);

    }
}
