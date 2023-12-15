import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor extends Thread{

	DataInputStream fentrada;
	DataOutputStream fsalida;
	
	Socket socket = null;
	
	ArrayList<Socket> arraySocket;
	
	public HiloServidor(Socket socket, ArrayList<Socket> array) {
		this.socket = socket;
		this.arraySocket = array;
	}
	
	
	public void run() {
		
		while(true) {
			try {
				fentrada = new DataInputStream(socket.getInputStream());
				fsalida = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				String cadena = fentrada.readUTF();//lee lo que el cliente escribe
				
				//cuando un cliente finaliza envia un *
				if (cadena.trim().equals("*")) {
		
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace ();
				
			}
			
			try {
				
				String texto = "";
				fsalida.writeUTF(texto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	
	
	
}
