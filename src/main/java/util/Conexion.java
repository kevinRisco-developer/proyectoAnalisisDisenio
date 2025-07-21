package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    public static Connection getConexion() throws Exception {
        Properties props = new Properties();
        InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config/conexion.properties");

        if (input == null) {
            throw new RuntimeException("No se encontró el archivo conexion.properties");
        }
        props.load(input);

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);

    }
}
