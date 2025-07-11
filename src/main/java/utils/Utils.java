package utils;

import modelo.DepartamentosDTO;
import modelo.EmpleadosDTO;

import java.util.Collection;

public class Utils {
    public static void mostrarDepartamentos(Collection<DepartamentosDTO> departamentos) {
        System.out.println("Departamentos:");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-20s |\n", "ID", "Nombre", "Ubicación");
        System.out.println("-------------------------------------------------------------");

        for (DepartamentosDTO departamento : departamentos) {
            System.out.printf("| %-5d | %-20s | %-20s |\n",
                    departamento.getId(),
                    departamento.getNombre(),
                    departamento.getUbicacion());
        }

        System.out.println("-------------------------------------------------------------");
    }

    public static void mostrarEmpleados(Collection<EmpleadosDTO> empleados, int numDepartamento) {
        System.out.println("Empleados del departamento nº: " + numDepartamento);
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-20s | %-20s |\n", "Nombre", "Fecha Contratación");
        System.out.println("-------------------------------------------------------------");

        for (EmpleadosDTO empleado : empleados) {
            System.out.printf("| %-20s | %-20s |\n",
                    empleado.getNombre(),
                    empleado.getFechaContratacion());
        }

        System.out.println("-------------------------------------------------------------");
    }

}
