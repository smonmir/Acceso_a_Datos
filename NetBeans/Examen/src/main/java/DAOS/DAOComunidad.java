/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import POJO.Comunidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam
 */
public class DAOComunidad {
    
    private static DAOComunidad dao = null;
    private static Connection connection;
    
    	
    private DAOComunidad() {
        connection = Conexion.enlace();
    }
    
    
    public List<Comunidad> getComunidades(){
        List<Comunidad> listaComunidades = new ArrayList<>();

        try {
            String sql = "SELECT idcomunidad, nombre FROM comunidad";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idComunidad = resultSet.getInt("idcomunidad");
                String nombre = resultSet.getString("nombre");

                Comunidad comunidad = new Comunidad(nombre);
                comunidad.setCodigo(idComunidad);
                listaComunidades.add(comunidad);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listaComunidades;

    }
    
    
    public int eliminarComunidad(int idComunidad){
        String sqlQuery = "DELETE FROM comunidad WHERE idcomunidad = ?";

        try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, idComunidad);

            if (statement.executeUpdate() > 0) {
                System.out.println("Comunidad eliminado exitosamente.");
                return 1;
            }
        }
        catch(SQLException e) {
                e.printStackTrace();
        }
        return 0;
    }
    
    
    public static DAOComunidad getInstance(){
        if(dao == null){
            return dao = new DAOComunidad();
        }
        return dao;
    }
    
}
