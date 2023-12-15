/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alinoss.repasosocketsserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author airam_fckw728
 */
public class RepasoSocketsServer {
    
    public static void main(String[] args) {
        int puerto = 90;
        List<HiloServidor> clientes = new ArrayList<>();
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor en el puerto 90");
            
            while(true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");
                
                HiloServidor hiloServidor = new HiloServidor(clienteSocket, clientes);
                clientes.add(hiloServidor);
                hiloServidor.start();
            }
        } catch (Exception e) {
        }
    }
}
