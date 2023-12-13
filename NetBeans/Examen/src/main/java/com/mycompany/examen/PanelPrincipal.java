/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.examen;

import POJO.Comunidad;
import POJO.Vivienda;
import Servicio.Servicio;
import java.awt.Component;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author dam
 */
public class PanelPrincipal extends javax.swing.JPanel {

    private JFrame frame;
    private Servicio servicio;
 
    public PanelPrincipal(JFrame frame) {
        initComponents();
        
        this.frame = frame;
        servicio = Servicio.getInstance();
        
        cargarTablaComunidad();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComunidad = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableViviendas = new javax.swing.JTable();
        btnAnadir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnComprobarMoroso = new javax.swing.JButton();

        jTableComunidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jTableComunidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComunidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableComunidad);

        jTableViviendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Piso", "Letra", "Propietario", "Tarifa", "Moroso"
            }
        ));
        jScrollPane2.setViewportView(jTableViviendas);

        btnAnadir.setText("Añadir ");
        btnAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnadirMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnComprobarMoroso.setText("Comprobar Morosos");
        btnComprobarMoroso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprobarMorosoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAnadir, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(btnModificar))
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnComprobarMoroso)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(btnActualizar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAnadir)
                        .addGap(39, 39, 39)
                        .addComponent(btnEliminar)
                        .addGap(39, 39, 39)
                        .addComponent(btnModificar)))
                .addGap(26, 26, 26)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprobarMoroso))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnadirMouseClicked

            PanelAnadir panelAnadir = new PanelAnadir(frame);

            frame.getContentPane().remove(this);
            frame.getContentPane().add(panelAnadir);
            frame.validate();
            frame.repaint();

        
    }//GEN-LAST:event_btnAnadirMouseClicked

    private void jTableComunidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComunidadMouseClicked
        
        int codigoComunidad = comunidadSeleccionada();
        
         
         
        List<Vivienda> listaViviendas = servicio.getViviendas(codigoComunidad);
       
   
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Piso");
        modelo.addColumn("Letra");
        modelo.addColumn("Propietario");
        modelo.addColumn("Tarifa");
        modelo.addColumn("Moroso");
        //modelo.addColumn("Moroso");
        
        Object[] registroLeido = new Object [6];
	 
	 for(Vivienda vivienda:listaViviendas){	
             
            registroLeido[0]= vivienda.getCodigo();
            registroLeido[1]= vivienda.getPiso();
            registroLeido[2]= vivienda.getLetra();
            registroLeido[3]= vivienda.getPropietario();
            registroLeido[4]= vivienda.getTarifa();
            registroLeido[5]= vivienda.isMoroso();

            modelo.addRow(registroLeido);
        }
	 
	 jTableViviendas.setModel(modelo);
        
    }//GEN-LAST:event_jTableComunidadMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        
        cargarTablaComunidad();
        
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        
        int codigoComunidad = comunidadSeleccionada();

        if(codigoComunidad == 0){
            System.out.println("Debe seleccionar una comunidad");
        }
        else{
            System.out.println("Tambien se eliminaran sus viviendas corresponientes");
            servicio.eliminarComunidad(codigoComunidad);
            cargarTablaComunidad();
        }
        
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnComprobarMorosoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprobarMorosoMouseClicked
        int codigoComunidad = comunidadSeleccionada();
    
        if(codigoComunidad == 0){
            System.out.println("Debe seleccionar una comunidad");
        }
        else{
            if(servicio.comprobarMorosos(codigoComunidad)){
                System.out.println("Existen morosos");
            }
            else{
                System.out.println("No existen morosos");
            }
            cargarTablaComunidad();
        }
        
    }//GEN-LAST:event_btnComprobarMorosoMouseClicked

    
    public void cargarTablaComunidad(){
        
        List<Comunidad> listaComunidades = servicio.getComunidades();
        
        DefaultTableModel modelo=new DefaultTableModel();
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        
        Object[] registroLeido = new Object [2];
	 
	 for(Comunidad comunidad:listaComunidades){	
             
            registroLeido[0]= comunidad.getCodigo();

            registroLeido[1]= comunidad.getNombre();


            modelo.addRow(registroLeido);
        }
	 
	 jTableComunidad.setModel(modelo);
    }

    public int comunidadSeleccionada(){
        int codigoComunidad = 0;
        try{
            int row = jTableComunidad.getSelectedRow();
            int col = jTableComunidad.getSelectedColumn();
            
            Object celda = jTableComunidad.getValueAt(row, col);
            
            codigoComunidad = (int) celda;
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        return codigoComunidad;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnComprobarMoroso;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableComunidad;
    private javax.swing.JTable jTableViviendas;
    // End of variables declaration//GEN-END:variables
}
