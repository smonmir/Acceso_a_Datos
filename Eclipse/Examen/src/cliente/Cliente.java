package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private static DataOutputStream salida;
	private static DataInputStream entrada;
	private static Socket socket;
	
	public static void main(String[] args) throws IOException{
		
		final int PUERTO = 4000;
		
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("localhost", PUERTO);
			entrada = new DataInputStream(socket.getInputStream());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

		Thread thread = new Thread(() ->{
			System.out.println("Introduce un mensaje: ");
			String mensaje = sc.nextLine();
			if(mensaje.equals("*")) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				enviarMensaje(mensaje);
			}
		});
		
		String mensajeRecibido = "";
		while((mensajeRecibido = entrada.readUTF()) != null) {
			System.out.println(mensajeRecibido);
		}
		
	}
	
	
	public static void enviarMensaje(String mensaje) {
		try {
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF(mensaje);				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}






