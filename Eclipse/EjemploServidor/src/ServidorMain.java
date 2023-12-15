import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorMain<T> {

	
	public static void main(String[] args) throws IOException {
		
		int puerto = 12345;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("iniciando servidor");
		
		ArrayList<Socket> arraySocket = new ArrayList<Socket>();
		
		while(true) {
			
			Socket socket = new Socket();
			
			socket = servidor.accept();
			
			System.out.println("cliente aceptado");
			
			//Version para que cada cliente tenga referenciado al resto de clientes
			arraySocket.add(socket);
			HiloServidor hilo = new HiloServidor(socket, arraySocket);
			
			//Version si no quiero que cada cliente sepa lo que hacen los demas clientes
			/*
			arraySocket.add(socket);
			HiloServidor hilo = new HiloServidor(socket);
			*/
			
			hilo.start(); //lanzar hilo
			
			System.out.println("Cliente en nuevo hilo");
		}

	}

	
}
