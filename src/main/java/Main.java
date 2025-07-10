import controlador.DepartamentoDAO;
import modelo.DepartamentosDTO;
import modelo.Uconnection;

import java.sql.Connection;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        DepartamentoDAO departamentos = new DepartamentoDAO();
        Collection<DepartamentosDTO> coleccion = departamentos.obtenerDepartamentos();
        for(DepartamentosDTO dep : coleccion){
            System.out.println(dep);
        }
    }
}
