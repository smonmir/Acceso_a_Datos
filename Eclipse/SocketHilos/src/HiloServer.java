import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloServer extends Thread{
	
	private BufferedReader entrada;
	
	public HiloServer(Socket cliente) throws IOException {
		entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
	}
	
	public void run() {
		
		try {
			String peticion = entrada.readLine();
			System.out.println("Peticon: "+peticion.toString());
			
			if (peticion.startsWith("GET")) {
			
                String peticionDividido = peticion.split(" ")[1];
                System.out.println("Archivo: "+peticionDividido.toString());
				File archivo = new File(peticionDividido);
				
				System.out.println("Archivo: "+archivo.toString());
				if (archivo.exists()){
					System.out.println("Si");
				}
				else {
					System.out.println("No");
				}
				
			}
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}

}
