package DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Recursos.Vehiculo;




public class DAOVehiculoImpl implements IDAOVehiculo {
	
	private List<Vehiculo> falsaBD;
	private static IDAOVehiculo dao=null; 
	private static Connection connection;

	private DAOVehiculoImpl() {
		super();
		/*
		this.falsaBD = new ArrayList<Vehiculo>();
		falsaBD.add(new Vehiculo("Renault","Zoe","2345FDF"));
		falsaBD.add(new Vehiculo("Renault","Fluence","0000FTL"));
		falsaBD.add(new Vehiculo("Tesla","3","2422FHT"));
		falsaBD.add(new Vehiculo("Tesla","X","1221FDF"));
		*/
		connection = BD1.enlace();
	}

	@Override
	public int insertarVehiculo(Vehiculo vehiculo) {
		String sqlQuery = "INSERT INTO vehiculos (marca, modelo, matricula) VALUES (?, ?, ?)";
		
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setString(3, vehiculo.getMatricula());

            if (statement.executeUpdate() > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
	}

	

	@Override
	public int eliminarVehiculo(String matricula) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarVehiculos(List<Vehiculo> lstVehiculos) {
		
		return 0;
	}

	@Override
	public Vehiculo getVehiculo(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> getVehiculos(){
		
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        try {
            String sql = "SELECT marca, modelo, matricula FROM vehiculos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String matricula = resultSet.getString("matricula");

                Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula);
                listaVehiculos.add(vehiculo);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listaVehiculos;
	}

	
	public static IDAOVehiculo getInstance() {
	  if (dao== null) dao =new DAOVehiculoImpl();
	  
		return dao;
	}

	@Override
	public int eliminarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
