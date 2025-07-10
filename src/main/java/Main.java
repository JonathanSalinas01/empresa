import modelo.Uconnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = Uconnection.getConnection();
        if(conn != null){
            System.out.println("conexion establecida!");
        }else{
            System.out.println("Hubo un error al conectar a la base datos");
        }
    }
}
