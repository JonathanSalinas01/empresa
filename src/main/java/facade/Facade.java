package facade;

import controlador.DepartamentoDAO;
import controlador.EmpleadosDAO;
import modelo.DepartamentosDTO;
import modelo.EmpleadosDTO;

import java.util.Collection;
import java.util.Vector;

public class Facade {
    public Collection<EmpleadosDTO> obtenerEmpleados( int departamento){
        EmpleadosDAO empleados = new EmpleadosDAO();
        return empleados.empleadosPorDepartamento(departamento);
    }

    public Collection<DepartamentosDTO> obtenerDepartamentos(){
        DepartamentoDAO departamentos = new DepartamentoDAO();
        return departamentos.obtenerDepartamentos();
    }
}
