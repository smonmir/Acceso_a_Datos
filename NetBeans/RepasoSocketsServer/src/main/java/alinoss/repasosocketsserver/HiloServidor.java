/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alinoss.repasosocketsserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author airam_fckw728
 */
public class HiloServidor extends Thread {
    private Socket clienteSocket;
    private List<HiloServidor> clientes;
    private PrintWriter out;

    public HiloServidor(Socket clienteSocket, List<HiloServidor> clientes) {
        this.clienteSocket = clienteSocket;
        this.clientes = clientes;
    }

    @Override
    public void run() {
        try (
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()))
        ) {
            this.out = out;

            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println(mensaje);
                enviarMensaje(mensaje);
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void enviarMensaje(String mensaje) {
        for (HiloServidor cliente : clientes) {
            cliente.out.println(mensaje);
        }
    }
}
