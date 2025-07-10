package controlador;

import modelo.EmpleadosDTO;
import modelo.Uconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

public class EmpleadosDAO {
    public Collection<EmpleadosDTO> empleadosPorDepartamento(int departamento) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = Uconnection.getConnection();
            String sql = "SELECT id_empleados, nombre, fecha_contratacion FROM empleados WHERE id_departamentos = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, departamento);
            rs = pst.executeQuery();

            Vector<EmpleadosDTO> empleados = new Vector<>();

            while (rs.next()) {
                EmpleadosDTO empleado = new EmpleadosDTO();
                empleado.setId(rs.getInt("id_empleados"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setFechaContratacion(rs.getString("fecha_contratacion"));
                empleados.add(empleado);
            }

            return empleados;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener empleados por departamento", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                // No cerramos `conn` porque se maneja con shutdown hook
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al cerrar recursos", e);
            }
        }
    }
}
