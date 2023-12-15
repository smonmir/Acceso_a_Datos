import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	
	public static void main(String[] args) throws IOException {
		
		final int MAXIMO_CONEXIONES = 2;
		final int PUERTO = 4000;
		int conectados = 0;
		ArrayList<Socket> clientes = new ArrayList<Socket>();
		
		DataOutputStream salida;
		String mensajeBienvenida = "Bienvenido";
		
		ServerSocket socketServer = new ServerSocket(5000);
		
		System.out.println("Servidor iniciado en el puerto: "+PUERTO);
		
		Socket socket;
		
		while(conectados < MAXIMO_CONEXIONES) {
			
			socket = socketServer.accept();
			
			HiloServer hilo = new HiloServer(socket, clientes);
			hilo.start();
			
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF(mensajeBienvenida);
			
			clientes.add(socket);
			conectados++;
			
			System.out.println("cliente conectado");
		}

	}

}
