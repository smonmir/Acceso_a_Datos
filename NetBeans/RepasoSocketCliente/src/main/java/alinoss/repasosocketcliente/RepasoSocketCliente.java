/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alinoss.repasosocketcliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author airam_fckw728
 */
public class RepasoSocketCliente {
    private static String mensajeEnviado;
    private static String mensajeRecibido;
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static final int port = 90;
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            socket = new Socket("localhost", port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread thread = new Thread(() -> {
                while (true) {
                    System.out.println("Ingrese un mensaje: ");
                    String mensajeEnviado = scanner.nextLine();
                    enviarMensaje(mensajeEnviado);
                }
            });
            thread.start();
            
            while ((mensajeRecibido = in.readLine()) != null) {
                System.out.println("Servidor: " + mensajeRecibido);
            }

            
        } catch (IOException ex) {
            Logger.getLogger(RepasoSocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }
}
