/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegomultijugador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author santi
 */
public class Cliente extends Thread{
        
    private Socket cliente;
    private BufferedReader entrada;
    private PrintWriter salida;
    private int posicion, puntuacion;
    
    private MiVentana miVentana;
    private JPanel panel;
    
    public Cliente(Socket cliente){
        this.cliente = cliente;
        this.posicion = 0;
        this.puntuacion = 0;
        
        this.miVentana = new MiVentana();
        this.panel = new JPanel();
        this.panel.setBackground(Color.red);
        this.miVentana.getContentPane().add(panel);
        this.panel.setBounds(0, 0, 400, 300);
        this.miVentana.setVisible(true);
    }

    
    @Override
    public void run(){

        try {
            salida = new PrintWriter(cliente.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                
            
            String linea = "";
            while ((linea = entrada.readLine()) != null) {


            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    
}
