package Controller;




import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAOs.DAOUsuario;
import DAOs.DAOVehiculoImpl;
import Recursos.Usuario;
import Recursos.Vehiculo;
import Vista.PanelCRUD;





public class ControllerCRUD
{
	
	
	public static void cargarTabla( JTable tablaVehiculos)
	{ //DefaultTableModel modeloDeDatosTabla = (DefaultTableModel) tablaVehiculos.getModel();
		List<Vehiculo> lstVehiculos = DAOVehiculoImpl.getInstance().getVehiculos();
		
		DefaultTableModel modelo=new DefaultTableModel();
	 
	 
	 modelo.addColumn("Marca");

	 modelo.addColumn("Modelo");

	 modelo.addColumn("Matricula");
	 
	 modelo.addColumn("idusuario");

	
    
   
	 Object[] registroLeido = new Object [4];
	 
	 for(Vehiculo vehiculo:lstVehiculos)

	 {	 
			registroLeido[0]= vehiculo.getMarca();

			registroLeido[1]= vehiculo.getModelo();

			registroLeido[2]= vehiculo.getMatricula();
	 
			registroLeido[3]= vehiculo.getIdUsuario();


		 modelo.addRow(registroLeido);

	 }
	 
	 tablaVehiculos.setModel(modelo);
	}
	
	
	public static boolean insertarVehiculo( PanelCRUD frmVehiculo, JTable tablaVehiculos)
	{ boolean insertado=false;
	Vehiculo vehiculo=new Vehiculo();
	 
	 
	 vehiculo.setMarca(frmVehiculo.getTxtMarca().getText());

	 vehiculo.setModelo(frmVehiculo.getTxtModelo().getText());

	 vehiculo.setMatricula(frmVehiculo.getTxtMatricula().getText());
	 
	 vehiculo.setIdUsuario(Integer.parseInt(frmVehiculo.getTxtIdUsuario().getText()));
	 
	 
	 
		if (DAOVehiculoImpl.getInstance().insertarVehiculo(vehiculo)!=0)
		{insertado=true;
		cargarTabla( tablaVehiculos);
		}
     return insertado;		
	}
	
	public static boolean insertarUsuario(String nombre, String apellido) {
		
		boolean insertado = false;
		
		Usuario usuario = new Usuario(nombre, apellido);
		
		if(DAOUsuario.getInstance().insertarUsuario(usuario)!=0) {
			insertado=true;
		}
		
		
		
		return insertado;
		
	}
	
	public static List<Usuario> obtenerUsuarios() {
		
		List<Usuario> usuarios = DAOUsuario.getInstance().getUsuarios();
		
		
		return usuarios;
		
	}
	
	

}
