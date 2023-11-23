package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Recursos.Usuario;
import Recursos.Vehiculo;

public class DAOUsuario {
	
	
	private static DAOUsuario dao=null; 
	private static Connection connection;
	
	
	private DAOUsuario() {
		connection = BD1.enlace();
	}
	
	public int insertarUsuario(Usuario usuario) {
		String sqlQuery = "INSERT INTO usuarios (nombre, apellido) VALUES (?, ?)";
		
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());

            if (statement.executeUpdate() > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
	}
	
	
	public List<Usuario> getUsuarios(){
		
        List<Usuario> listaUsuarios = new ArrayList<>();

        try {
            String sql = "SELECT idUsuario, nombre, apellido FROM usuarios";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	int id = resultSet.getInt("idusuario");
            	String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");

                Usuario usuario = new Usuario(nombre, apellido);
                usuario.setId(id);
                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listaUsuarios;
        
	}
	
	public static DAOUsuario getInstance() {
		if(dao==null) {
			return dao = new DAOUsuario();
		}
		
		return dao;
	}

}
