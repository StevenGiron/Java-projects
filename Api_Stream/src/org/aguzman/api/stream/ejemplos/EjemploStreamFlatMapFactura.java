package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Factura;
import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Steven", "Giron");
        Usuario u2 = new Usuario("Sebastian", "Giron");

        u1.addFactura(new Factura("Compras tecnologicas"));
        u1.addFactura(new Factura("Compras muebles"));

        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("Notebook"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);

        //Imprimir facturas con for anidado
        /*for(Usuario u: usuarios){
            for(Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }*/

        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(": Cliente - ")
                .concat(f.getUsuario().toString())));

    }
}
