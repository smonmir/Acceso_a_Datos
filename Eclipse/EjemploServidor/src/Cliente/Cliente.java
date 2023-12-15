package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente implements Runnable{
	
	Socket socket = null;
	DataInputStream fentrada; //para leer mensajes de todos
	DataOutputStream fsalida;

	
	public Cliente(Socket socket) throws IOException {
		this.socket = socket;
		
		fentrada = new DataInputStream(socket.getInputStream());
		fsalida = new DataOutputStream(socket.getOutputStream());
	}
	
	public void run() {
		
		while(true) {
			
			try {
				String texto = fentrada.readUTF();
				fsalida.writeUTF(texto);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}


	
	public static void main(String[] args) throws UnknownHostException, IOException {

		int puerto = 12345;
		
		Socket s = new Socket("localhost",puerto);
		
		Cliente cliente = new Cliente(s);
		
		new Thread(cliente).start();
		
		
	}

}
