package org.giron.java.jdbc;

import org.giron.java.jdbc.models.Producto;
import org.giron.java.jdbc.repositorio.ProductoRepositorio;
import org.giron.java.jdbc.repositorio.Repositorio;
import org.giron.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCDelete {
    public static void main(String[] args) {

        //Auto Close
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorio();

            System.out.println("=========== LISTAR ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== OBTENER POR ID ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== ELIMINAR PRODUCTO ===========");
            repositorio.eliminar(4);
            System.out.println("Producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
