package controlador;

import modelo.DepartamentosDTO;
import modelo.Uconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

public class DepartamentoDAO {
    public Collection<DepartamentosDTO> obtenerDepartamentos(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            conn = Uconnection.getConnection();
            String sql = "SELECT id_departamentos, nombre_departamento, ubicacion FROM departamentos";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Vector<DepartamentosDTO> departamentos = new Vector<>();
            DepartamentosDTO departamento = null;
            while (resultSet.next()){
                departamento = new DepartamentosDTO();
                departamento.setId(resultSet.getInt("id_departamentos"));
                departamento.setNombre(resultSet.getString("nombre_departamento"));
                departamento.setUbicacion(resultSet.getString("ubicacion"));
                departamentos.add(departamento);
            }
            return departamentos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
