package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Uconnection {
    private static Connection con = null;

    // Singleton: conexión única
    public static Connection getConnection() {
        if (con == null) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://127.0.0.1:3306/empresa";
                String user = "admin";
                String password = "admin";

                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                System.out.println("¡Conexión creada exitosamente!");

                // Agregamos el shutdown hook para cerrar la conexión al salir
                Runtime.getRuntime().addShutdownHook(new MiShutdownHook());

            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Error al conectar a la base de datos:");
                e.printStackTrace();
            }
        }
        return con;
    }

    static class MiShutdownHook extends Thread{

        public void run(){
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                    System.out.println("¡Conexión cerrada automáticamente al finalizar!");
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión en shutdown hook:");
                e.printStackTrace();
            }
        }

    }
}
