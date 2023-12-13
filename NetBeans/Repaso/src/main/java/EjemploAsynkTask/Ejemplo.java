/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploAsynkTask;

/**
 *
 * @author dam
 */
public class Ejemplo {
    
/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsyncTaskExample extends JFrame {
    private JButton startButton;
    private JTextArea resultTextArea;

    public AsyncTaskExample() {
        setTitle("AsyncTask Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        startButton = new JButton("Start AsyncTask");
        resultTextArea = new JTextArea();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón, se inicia la tarea asíncrona
                performAsyncTask();
            }
        });

        // Agregar componentes al diseño
        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(resultTextArea);
        add(panel);

        setVisible(true);
    }

    private void performAsyncTask() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Tarea que se ejecutará en segundo plano
                for (int i = 0; i < 10; i++) {
                    // Simula una tarea que toma tiempo
                    Thread.sleep(1000);
                    // Publica el progreso o resultados parciales
                    publish("Progreso: " + i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                // Actualiza la interfaz de usuario con resultados parciales
                for (String chunk : chunks) {
                    resultTextArea.append(chunk + "\n");
                }
            }

            @Override
            protected void done() {
                // Se ejecuta cuando doInBackground ha terminado
                resultTextArea.append("Tarea completada.\n");
            }
        };

        // Inicia la tarea asíncrona
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AsyncTaskExample();
            }
        });
    }
}
*/
    
}
