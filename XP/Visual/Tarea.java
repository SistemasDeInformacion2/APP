/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author USER
 */
public class Tarea extends javax.swing.JFrame {

    /**
     * Creates new form Tarea
     */
    private Modelo.Tarea tarea;
    
    public Tarea(Modelo.Tarea tarea) {
        this.tarea=tarea;
        initComponents();
        drawTermometro(termometros.getGraphics());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_descripcion = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        label_importancia = new javax.swing.JLabel();
        importancia = new javax.swing.JLabel();
        boton_aceptado = new javax.swing.JButton();
        boton_rechazado = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        label_estado = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        termometros = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea");

        label_descripcion.setText("Descripcion:");
        label_descripcion.setDoubleBuffered(true);

        descripcion.setDoubleBuffered(true);

        label_importancia.setText("Importancia:");
        label_importancia.setDoubleBuffered(true);

        importancia.setDoubleBuffered(true);

        boton_aceptado.setText("Estoy de acuerdo!");
        boton_aceptado.setDoubleBuffered(true);
        boton_aceptado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptadoActionPerformed(evt);
            }
        });

        boton_rechazado.setText("No estoy de acuerdo...");
        boton_rechazado.setDoubleBuffered(true);

        boton_salir.setText("Salir");
        boton_salir.setDoubleBuffered(true);
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        label_estado.setText("Estado:");
        label_estado.setDoubleBuffered(true);

        estado.setDoubleBuffered(true);

        javax.swing.GroupLayout termometrosLayout = new javax.swing.GroupLayout(termometros);
        termometros.setLayout(termometrosLayout);
        termometrosLayout.setHorizontalGroup(
            termometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        termometrosLayout.setVerticalGroup(
            termometrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(termometros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_importancia)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_descripcion)
                            .addComponent(label_estado))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(importancia, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_aceptado)
                        .addGap(28, 28, 28)
                        .addComponent(boton_rechazado)
                        .addGap(31, 31, 31)
                        .addComponent(boton_salir)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_descripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(label_importancia))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importancia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_estado)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_aceptado)
                    .addComponent(boton_rechazado)
                    .addComponent(boton_salir))
                .addGap(20, 20, 20))
            .addComponent(termometros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_aceptadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptadoActionPerformed
            tarea.aprobar();
    }//GEN-LAST:event_boton_aceptadoActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        dispose();       
    }//GEN-LAST:event_boton_salirActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    
    public void drawTermometro(Graphics g){
        g.drawRect(48, 50, 25, 250);
        g.drawOval(35, 280, 50, 50);
        g.drawRect(108, 50, 25, 250);
        g.drawOval(95, 280, 50, 50);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptado;
    private javax.swing.JButton boton_rechazado;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel importancia;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_importancia;
    private java.awt.Panel termometros;
    // End of variables declaration//GEN-END:variables
}