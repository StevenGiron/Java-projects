package org.giron.java.jdbc;

import org.giron.java.jdbc.modelo.Categoria;
import org.giron.java.jdbc.modelo.Producto;
import org.giron.java.jdbc.servicio.CatalogoServicio;
import org.giron.java.jdbc.servicio.Servicio;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("============= listar =============");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");

        Producto producto = new Producto();
        producto.setNombre("Lámpara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con éxito: " + producto.getId());
        servicio.listar().forEach(System.out::println);

    }
}
