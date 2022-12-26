package org.giron.java.jdbc;

import org.giron.java.jdbc.models.Categoria;
import org.giron.java.jdbc.models.Producto;
import org.giron.java.jdbc.repositorio.ProductoRepositorio;
import org.giron.java.jdbc.repositorio.Repositorio;
import org.giron.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {

        //Auto Close
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorio();

            System.out.println("=========== LISTAR ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== OBTENER POR ID ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== ACTUALIZAR PRODUCTO ===========");
            Producto producto = new Producto();
            producto.setId(6L);
            producto.setNombre("Teclado Mecánico");
            producto.setPrecio(600);

            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
