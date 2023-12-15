import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Repaso {

	//Servidor
	
	
	//Main
	
	/*
	 *ServerSocket server = new ServerSocket(puerto);
	 *ArrayList<Socket> clientes = new ArrayLisz<Socket>()
	 * 
	 * while(true){
	 * 
	 * socket cliente = serversocket.acept();
	 * 
	 * HiloServidor hilo = new HiloServidor(cliente, clientes);
	 * 
	 * hilo.start();
	 * 
	 * }
	 */
	
	
	//HiloServidor
	/*
	 * private socket s;
	 * private DataInputStream in;
	 * private DataOutputStream out;
	 * private ArrayList<Socket> clientes
	 * 
	 * public HiloServidor(Socket s, arrayClientes){
	 * 	this.s = s;
	 * 	this.clientes = arrayClientes;
	 * in = new DataInputStream(s.getInputStream())
	 * out = new DataOutputStream(s.getOutpuStream())
	 * }
	 */
	
	/*
	 * public void run(){
	 * 
	 *  String mensaje
	 *  while(mensaje = in.ReadUTF() != null{
	 *  	enviarMensaje(mensaje)
	 *  }
	 * 
	 * }
	 * 
	 */
	
	 //Metodo
	/*
	 * public void enviarMensaje(String mensaje){
	 * 	for(Socket cliente: arrayClientes){
	 * 		cliente.out.wrireUTF(mensaje)
	 * 	}
	 * 
	 * }
	 * 
	 */
	
	
	
	//Cliente
	
	//Main
	
	/*
	 * Socket s = new Socket("localHost", puerto)
	 * 
	 * 	DataInputStream in = new DataInputStream(s.getInputStream())
	 *	DataOutputStream out = new DataOutputStream(s.getOutpuStream())
	 * 
	 * String mensaje;
	 *  while(mensaje = in.readUTF() != null){
	 *  	syso(mensaje)
	 *  }
	 * 
	 * Thread hilo = new Thread(()->{
	 * 
	 * 	while(true){
	 * 		String mensajeEnviar = scanner
	 * 		enviarMensaje(mensajeEnviar)
	 * 	}
	 * })
	 * 
	 */
	
	//Metodo
	
	/*
	 * public void enviarMensaje(String mensaje){
	 * 	out.writeUTF(mensaje);
	 * }
	 */
	
	
	
	
	
}
