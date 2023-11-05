/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegomultijugador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class HiloServer extends Thread{
    
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int posicionX  = 10;
    private int posicionY;
    private int idCliente;
    private static int sumaPos = 10;
    private static int sumaId = 1;
    
    public HiloServer(Socket cliente) throws IOException{
        this.cliente = cliente;
        this.idCliente = sumaId;
        this.posicionY = sumaPos;
        sumaPos += 40;
        sumaId ++;
        
        entrada = new DataInputStream(cliente.getInputStream());
        salida = new DataOutputStream(cliente.getOutputStream());
    }
    
    
    public void run(){

        while(true){
            try {
                posicionX = entrada.readInt();
                posicionY = entrada.readInt();
                idCliente = entrada.readInt();
                
                enviarDatos(posicionX, posicionY, idCliente);
                
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    public void enviarDatos(int x, int y, int id) throws IOException {
        for (int i = 0; i < Server.getClientes().size(); i++) {
            Socket s1 = Server.getClientes().get(i);
                try {
                    salida = new DataOutputStream(s1.getOutputStream());
                    salida.writeInt(x);
                    salida.writeInt(y);
                    salida.writeInt(id);
                } catch (IOException ex) {
                    Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    
}
