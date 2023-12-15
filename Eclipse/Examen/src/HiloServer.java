import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServer extends Thread{

	
	Socket cliente;
	DataInputStream entrada;
	DataOutputStream salida;
	ArrayList<Socket> clientes;
	
	public HiloServer(Socket socket, ArrayList<Socket> clientes) throws IOException {
		this.cliente = socket;
		this.clientes = clientes;
	}
	
	public void run() {
		try {
			entrada = new DataInputStream(cliente.getInputStream());
			
			//Recibe y manda el mensaje a todos los clientes
			String mensajeRecibido = "";
			while((mensajeRecibido = entrada.readUTF()) != null) {
				enviarMensaje(mensajeRecibido);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Enviar mensaje a todos lo clientes
	public void enviarMensaje(String mensaje) throws IOException {
		for(Socket cliente: clientes) {
			salida = new DataOutputStream(cliente.getOutputStream());
			salida.writeUTF(mensaje);
		}
		
	}
}
