/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import POJO.Comunidad;
import POJO.Vivienda;
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
public class DAOVivienda {
    
    private static DAOVivienda dao = null;
    private static Connection connection;
    
    	
    private DAOVivienda() {
        connection = Conexion.enlace();
    }
    
    public int anadir(Vivienda vivienda){
        
        String sqlQuery = "INSERT INTO vivienda (piso, letra, tarifa, propietario, codigo_comunidad, moroso) VALUES (?, ?, ?, ?, ?, ?)";
		
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1, vivienda.getPiso());
                statement.setString(2, vivienda.getLetra());
                statement.setInt(3, vivienda.getTarifa());
                statement.setString(4, vivienda.getPropietario());
                statement.setInt(5, vivienda.getCodigoComunidad());
                statement.setBoolean(6, vivienda.isMoroso());
                
                if (statement.executeUpdate() > 0) {
                    return 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return 0;
        
    }
    
    public List<Vivienda> getViviendas(int codigoComunidad){
        List<Vivienda> listaViviendas = new ArrayList<>();

        try {
            String sql = "SELECT idvivienda, piso, letra, tarifa, propietario, codigo_comunidad, moroso FROM vivienda WHERE codigo_comunidad = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, codigoComunidad);
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idVivienda = resultSet.getInt("idvivienda");
                int piso = resultSet.getInt("piso");
                String letra = resultSet.getString("letra");
                int tarifa = resultSet.getInt("tarifa");
                String nombrePropietario = resultSet.getString("propietario");
                int codigo = resultSet.getInt("codigo_comunidad");
                boolean esMoroso = resultSet.getBoolean("moroso");

                Vivienda vivienda = new Vivienda(piso, letra, nombrePropietario, tarifa, codigo, esMoroso);
                vivienda.setCodigo(idVivienda);
                listaViviendas.add(vivienda);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener las viviendas: "+e.getMessage());
        }

        return listaViviendas;
    }
    
    public int eliminarViviendas(int idComunidad){
        String sqlQuery = "DELETE FROM vivienda WHERE codigo_comunidad = ?";

        try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, idComunidad);

            if (statement.executeUpdate() > 0) {
                System.out.println("Viviendas eliminadas exitosamente.");
                return 1;
            }
        }
        catch(SQLException e) {
                e.printStackTrace();
        }
        return 0;
    }
    
    
    public static DAOVivienda getInstance(){
        if(dao == null){
            return dao = new DAOVivienda();
        }
        return dao;
    }
    
    
}
