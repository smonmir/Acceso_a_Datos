import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Test {

	public static void main(String[] arg) throws IOException {
		//CLIENTE
		String Host = "localhost";
		int Puerto = 6000;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO___");
		Socket cliente = new Socket(Host, Puerto);
		// CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		// ENVIO UN SALUDO AL SERVIDOR
		flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" +flujoEntrada.readUTF());
		// CERRAR STREAMS Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}
}