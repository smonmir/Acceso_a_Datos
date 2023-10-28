import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(90);

		System.out.println("Iniciando conexion");
		
		while(true) {
			Socket cliente = server.accept();
			HiloServer hilo = new HiloServer(cliente);
			hilo.start();
		}
	}

}

