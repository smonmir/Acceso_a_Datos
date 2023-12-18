package DAOs;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BD1 {
 
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	static String bd="dbvehiculo";
	static String login="root";
	static String password="root";  
	static String url="jdbc:mysql://localhost:3306/"+bd;
	
	
	public static Connection enlace () {
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,login,password);
			if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
	    } catch (SQLException ex) {
	    	System.out.println("Excepicon en la conexión");
	    } catch (ClassNotFoundException ex) {
	    	System.out.println("No se encuentra la clase");
	    }
	    return conn;
	}
	    
	 
	 public static void cerrarSesion() {
	    try {
	        conn.close();
	    } catch (SQLException ex) {
	        Logger.getLogger(BD1.class.getName()).log(Level.SEVERE, null, ex);
	    }
	 }
	 
	 
	public static void main(String[] args) {
	    
	    conn=enlace();
	    cerrarSesion();
	    
	}
	
}
