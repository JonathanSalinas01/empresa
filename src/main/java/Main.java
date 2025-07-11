import controlador.DepartamentoDAO;
import facade.Facade;
import modelo.DepartamentosDTO;
import modelo.Uconnection;
import utils.Utils;

import java.sql.Connection;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();
        Utils.mostrarDepartamentos(facade.obtenerDepartamentos());
        System.out.println("Ingrese un numero de departamento:");
        int departamento = sc.nextInt();
        Utils.mostrarEmpleados(facade.obtenerEmpleados(departamento), departamento);
        sc.close();
    }
}

