import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServidorChat extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static ServerSocket servidor;
	static final int PUERTO = 44444;// puerto por el que escucha
	static int CONEXIONES = 0; //cuenta las conexiones
	static int ACTUALES = 0; //n° de conexiones actuales activas
	static int MAXIMO=10; //máximo de conexiones permitidas
	static JTextField mensaje=new JTextField("");
	static JTextField mensaje2=new JTextField("");
	private JScrollPane scrollpanel;
	static JTextArea textarea;
	JButton salir = new JButton("Salir");
	static Socket tabla[]=new Socket[10];//almacena sockets de clientes
	
	public ServidorChat() {
		super(" VENTANA DEL SERVIDOR DE CHAT ");
		setLayout(null);
		mensaje.setBounds(10, 10, 400, 30);
		add(mensaje);mensaje.setEditable(false);
		mensaje2.setBounds(10, 348, 400, 30);add(mensaje2);
		mensaje2.setEditable(false);
		textarea = new JTextArea();
		scrollpanel = new JScrollPane(textarea);
		scrollpanel.setBounds(10, 50, 400, 300);add(scrollpanel);
		salir.setBounds(420, 10, 100, 30); add(salir) ;
		textarea.setEditable(false);
		salir.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salir) { // SE PULSA SALIR
			try {
				servidor.close(); // cierro
			} 
			catch (IOException el) {
				el.printStackTrace();
			}
			
			System.exit(0);//fin
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		servidor = new ServerSocket(PUERTO);//44444
		
		
		System.out.println("Servidor iniciado...");
		ServidorChat pantalla = new ServidorChat();
		pantalla.setBounds(0, 0, 540, 400);
		pantalla.setVisible(true);
		mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + 0);
		//SE ADMITEN HASTA 10 CONEXIONES
		while (CONEXIONES < MAXIMO) {
				Socket s = new Socket();
			try {
				s = servidor.accept();// esperando cliente
			} 
			catch (SocketException ns) {
				//sale por aqui si pulsamos botón Salir y
				//no se ejecuta todo el bucle
				break; //salir del bucle
			}
		
			tabla[CONEXIONES] = s; //almacenar socket
			CONEXIONES++;
			ACTUALES++;
			HiloServidor hilo = new HiloServidor(s);
			hilo.start(); //lanzar hilo
			
		}//fin while
		
		//Cuando finaliza bucle cerrar servidor si no se ha cerrado antes
		if (!servidor.isClosed()) {
			try {
				// sale cuando se llega al máximo de conexiones
				mensaje2.setForeground(Color.red);
				mensaje2.setText("MÁXIMO N° DE CONEXIONES ESTABLECIDAS: "+ CONEXIONES);

				servidor.close();
			} 
			catch (IOException el) {
				el.printStackTrace();

			}
			System.out.println("Servidor finalizado...");
		}
	}//main
	
	
}//Fin servidorChat
