package org.giron.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String username = "root";
    private static String password = "Sebastian99";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); //Conexiones abiertas iniciales
            pool.setMinIdle(3); //Mínimo de conexiones inactivas esperando por ser inicializadas
            pool.setMaxIdle(8);
            pool.setMaxTotal(8); //Maximo de conexiones entre activas e inactivas
        }
        return pool;
    }

    public static Connection getConection() throws SQLException {
        return getInstance().getConnection();
    }
}
