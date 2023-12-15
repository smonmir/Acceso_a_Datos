import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServer extends Thread {

	private PrintWriter salida;
	private BufferedReader entrada;
    private Socket cliente;
 
    public HiloServer(Socket socket) {
        this.cliente = socket;
    }
    
    public void run() {
    	
        try {
        	entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salida = new PrintWriter(cliente.getOutputStream(), true);

            String cadena = entrada.readLine();
            
            System.out.println(cadena);
            
            if (cadena != null && cadena.startsWith("GET ")) {
                
            	String[] requestParts = cadena.split(" ");
                
            	String direccionArchivo = requestParts[1].substring(1);// Elimina el primer carácter: /
            	
            	File archivo = new File(direccionArchivo); // src/index.html (Hay que crear el archivo html)
                
            	if (archivo.exists() && archivo.isFile()) {
                    
                    salida.println("HTTP/1.1 200 OK");
                    salida.println("Content-Type: text/html");
                    salida.println();

                    BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
                    
                    String linea;
                    
                    while ((linea = bufferedReader.readLine()) != null) {
                        salida.println(linea);
                    }
                    
                    bufferedReader.close();
                    
                } 
                else {
                    salida.println("HTTP/1.1 404 Not Found");
                    salida.println("Content-Type: text/html");
                    salida.println();
                    salida.println("404 - File Not Found");
                }
                
            }
			
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
