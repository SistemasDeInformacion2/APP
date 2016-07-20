package XP.Visual;

import XP.Modelo.*;
import XP.Control.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HistoriaUsuarioInterfaz extends javax.swing.JFrame {

    private HistoriaUsuario hu;
    private int value, aumento_value;
    private PuenteDBHU gesHis;
    private Sesion sesion;
    
    public HistoriaUsuarioInterfaz( HistoriaUsuario hu, Sesion sesion )  
    {        
        try
        {
            gesHis=ConexionDB.pedirPuenteHistorias();
        }
        catch( Exception e )
        {
            System.out.println( e );
        }
        
        gesHis.visitar( sesion.getIdUser(), hu.getId() );
        
        this.sesion=sesion;
        this.hu=hu;
        
        value = gesHis.cantidadUsuariosAprobaron( hu.getId() )*( 100/gesHis.cantidadUsuariosTotales() );
        aumento_value = 100/gesHis.cantidadUsuariosTotales();
        
        initComponents();         
        setVisible(true);
    }
                           
    private void initComponents() 
    {
        label_descripcion = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        label_importancia = new javax.swing.JLabel();
        importancia = new javax.swing.JLabel();
        boton_aceptado = new javax.swing.JButton();
        boton_rechazado = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        label_estado = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        barraProgreso =  new javax.swing.JProgressBar(JProgressBar.VERTICAL);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarea");
        
        descripcion.setText(hu.getDescripcion());
        importancia.setText(Integer.toString(hu.getImportancia()));
        
        label_descripcion.setText("Descripcion:");

        label_importancia.setText("Importancia:");

        boton_aceptado.setText("Estoy de acuerdo!");
        boton_aceptado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptadoActionPerformed(evt);
            }
        });

        boton_rechazado.setText("No estoy de acuerdo...");
        boton_rechazado.addActionListener
        (
            new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    boton_rechazadoActionPerformed(evt);
                }
            }
        );

        boton_salir.setText("Salir");
        boton_salir.addActionListener
        (
            new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    boton_salirActionPerformed(evt);
                }
            }
        );

        label_estado.setText("Estado:");

        barraProgreso.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
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
                            .addComponent(label_descripcion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_importancia))
                            .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importancia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_estado)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_aceptado)
                    .addComponent(boton_rechazado)
                    .addComponent(boton_salir))
                .addGap(20, 20, 20))
        );
        
        pack();
        
        barraProgreso.setValue(value);        
        barraProgreso.setStringPainted(true);
        barraProgreso.setBackground(Color.WHITE);
        
        if( !hu.estaRechazada() )
            barraProgreso.setForeground(Color.YELLOW); 
        else
            barraProgreso.setForeground(Color.RED);
    }                     

    private void boton_aceptadoActionPerformed(java.awt.event.ActionEvent evt) 
    {          
        if( gesHis.aprobar( sesion.getIdUser(), hu.getId() ) )
        {
            value+=aumento_value;  
            
            if(value>60)
                barraProgreso.setForeground(Color.GREEN);
                
            barraProgreso.setValue(value); 
        }
    }                                              

    private void boton_rechazadoActionPerformed(java.awt.event.ActionEvent evt) 
    { 
        gesHis.rechazar( hu.getId() , "No me gusta" );
        
        barraProgreso.setForeground(Color.RED);
    }                                               

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        dispose();       
    }   

    // Variables declaration - do not modify                     
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton boton_aceptado;
    private javax.swing.JButton boton_rechazado;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel importancia;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_importancia;
    // End of variables declaration                   
}
