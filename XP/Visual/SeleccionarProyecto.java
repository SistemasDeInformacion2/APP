package XP.Visual;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.*;
import XP.Control.*;
import XP.Modelo.*;

/**
 *
 * @author alvaro
 */
public class SeleccionarProyecto extends javax.swing.JFrame 
{
    private PuenteProyecto puenteProyecto;
    private ArrayList<Sprint> listaProyectos;
    private Sesion sesion;
    
    public SeleccionarProyecto( Sesion sesion ) 
    {
        this.sesion = sesion;
        
        try
        {
            puenteProyecto = new PuenteProyecto();
            listaProyectos = puenteProyecto.getLista();
        }
        catch( Exception e )
        {
            
        }
        
        initComponents();
        cerrar();
        this.setTitle("Proyecto");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() 
    {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        botAceptar = new javax.swing.JButton();
        botNuevoProyecto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleccionar proyecto:");
        
        auxComboBox = new javax.swing.DefaultComboBoxModel<>();        
        
        
        for( int i=0; i<listaProyectos.size(); i++ )
            auxComboBox.addElement( listaProyectos.get(i) );
        
        jComboBox1.setModel(auxComboBox);

        botAceptar.setText("Aceptar");
        botAceptar.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAceptarActionPerformed( evt );
            }
        });

        botNuevoProyecto.setText("Nuevo Proyecto");
        botNuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNuevoProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(botAceptar)
                                .addGap(34, 34, 34)
                                .addComponent(botNuevoProyecto))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botAceptar)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botNuevoProyecto)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void botNuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new CrearProyecto(this, sesion );
    }

    private void botAceptarActionPerformed(java.awt.event.ActionEvent evt) 
    {
        Sprint aux = (Sprint)auxComboBox.getSelectedItem();
        new HomeGUI( aux.getId(), sesion );
    }
    
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void confirmarSalida(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar la aplicación?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAceptar;
    private javax.swing.JButton botNuevoProyecto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private DefaultComboBoxModel auxComboBox;
    // End of variables declaration//GEN-END:variables
}
