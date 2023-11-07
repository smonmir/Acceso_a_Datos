/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.piscina;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dam
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Piscina piscina;
    private JList<Double> lista;
    private double litrosPiscina;
    private Random random;
    
    public VentanaPrincipal() {
        initComponents();
        random = new Random();
        
        slider.setVisible(false);
        btnLlenar.setVisible(false);
        btnVaciar.setVisible(false);
        jTextArea1.setVisible(false);
        
        DefaultListModel<Double> model = new DefaultListModel<>();
        lista = new JList<>(model);

        for (double i = 1; i <= 2; i+=0.1) {
            double roundedValue = Math.round(i * 10.0) / 10.0;
            model.addElement(roundedValue);
        }
        
        jScrollPane1.setViewportView(lista);
        
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    litrosPiscina = lista.getSelectedValue();
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        slider = new javax.swing.JSlider();
        btnLlenar = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Capacidad de la piscina en metros cúbicos:");

        jButton1.setText("Probar piscina");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("");

        btnLlenar.setText("Llenar");
        btnLlenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarActionPerformed(evt);
            }
        });

        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLlenar)
                        .addGap(191, 191, 191)
                        .addComponent(btnVaciar)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(161, 161, 161)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLlenar)
                    .addComponent(btnVaciar))
                .addGap(18, 18, 18)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jTextArea1.setText("Piscina vacia: 0");
                
        int litrosMax = (int) (litrosPiscina*1000);
        
        piscina = new Piscina(litrosMax);
        
        slider.setMinimum(0); //Valor Mínimo
        slider.setMaximum(litrosMax); //Valor Máximo
        slider.setMajorTickSpacing(100); //Definir marcas mayores cada 100 unidades
        slider.setMinorTickSpacing(10); //Definir marcas menores cada 10 unidades
        slider.setValue(0); //Asignación del valor inicial
        slider.setPaintTicks(true); //Mostrar marcas mayores y menores
        slider.setPaintLabels(true); //Mostrar numeración de marcas mayores
        slider.setEnabled(true); //desactivar jSlider
        slider.setVisible(true);
        
        btnLlenar.setVisible(true);
        btnVaciar.setVisible(true);
        jTextArea1.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLlenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarActionPerformed
        
        int litros = random.nextInt(1000) + 1; 
        
        try {
            piscina.llenar(litros);
            jTextArea1.setText(jTextArea1.getText()+"\nLlenado..." + litros + " nivel="+piscina.getNivel()+"\n-----------------------------------------\n");
            slider.setValue(piscina.getNivel());
        } catch (IOException ex) {
            jTextArea1.setText(jTextArea1.getText()+"\nError: " + ex.getMessage()+"\n");
        }
        
    }//GEN-LAST:event_btnLlenarActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        
        int litros = random.nextInt(1000) + 1; 
        
        try {
            piscina.vaciar(litros);
            jTextArea1.setText(jTextArea1.getText()+"\nVaciado..." + litros + " nivel="+piscina.getNivel()+"\n-----------------------------------------\n");
            slider.setValue(piscina.getNivel());
        } catch (IOException ex) {
            jTextArea1.setText(jTextArea1.getText()+"\nError: " + ex.getMessage()+"\n");
        }
        
    }//GEN-LAST:event_btnVaciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLlenar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
