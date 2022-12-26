package org.giron.java.jdbc;

import org.giron.java.jdbc.models.Categoria;
import org.giron.java.jdbc.models.Producto;
import org.giron.java.jdbc.repositorio.ProductoRepositorio;
import org.giron.java.jdbc.repositorio.Repositorio;
import org.giron.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorio();

            System.out.println("=========== LISTAR ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== OBTENER POR ID ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== INSERTAR NUEVO PRODUCTO ===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragon Mecánico");
            producto.setPrecio(1000);
            producto.setFechaRegistro(new Date());

            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");

            repositorio.listar().forEach(System.out::println);
    }
}
