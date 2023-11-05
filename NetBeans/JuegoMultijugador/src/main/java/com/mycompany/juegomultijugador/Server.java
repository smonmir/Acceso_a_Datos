/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegomultijugador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Server{
    
    private static ArrayList<Socket> clientes = new ArrayList<Socket>();
    private static ServerSocket server;
    
    
    public static ArrayList<Socket> getClientes(){
        return clientes;
    }
    
    public static void main(String args[]) {
        try {
            server = new ServerSocket(2000);

            System.out.println("Iniciando...");
            
            while(true){
                Socket cliente = server.accept();
                clientes.add(cliente);
                HiloServer hiloCliente = new HiloServer(cliente);
                hiloCliente.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
