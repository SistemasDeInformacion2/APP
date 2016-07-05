package GUI;

import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import control.*;

public class CrearCuenta extends javax.swing.JFrame 
{
    public CrearCuenta() 
    {
        initComponents(); 
        this.setTitle("Crear Cuenta");
        this.setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        campoPassword     = new javax.swing.JPasswordField();
        crearCuentaButton = new javax.swing.JButton();
        campoUsuario      = new javax.swing.JTextField();
        usernameLabel     = new javax.swing.JLabel();
        passLabel         = new javax.swing.JLabel();
        confPassLabel     = new javax.swing.JLabel();
        nombreLabel       = new javax.swing.JLabel();
        apellidoLabel     = new javax.swing.JLabel();
        campoNombre       = new javax.swing.JTextField();
        campoApellido     = new javax.swing.JTextField();
        jPasswordField2   = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        confPassLabel.setText("Confirmar contraseña");
        nombreLabel.setText("Nombre:");
        apellidoLabel.setText("Apellido:");
        crearCuentaButton.setText("Crear Cuenta");
        usernameLabel.setText("Usuario:");
        passLabel.setText("Password:");
        confPassLabel.setText("Confirmar Password");
        crearCuentaButton.setText("Registrar");
        
        crearCuentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(campoUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoLabel)
                            .addComponent(nombreLabel)
                            .addComponent(confPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(campoApellido)
                            .addComponent(jPasswordField2))))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(crearCuentaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confPassLabel)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(crearCuentaButton)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }

    private void crearCuentaButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        String username  = campoUsuario.getText();
        String password  = new String( campoPassword.getPassword() );
        String password2 = new String(jPasswordField2.getPassword());
        String nombre    = campoNombre.getText();
        String apellido  = campoApellido.getText();
        
        Gestionar_Cuentas gestionCuenta = new Gestionar_Cuentas();
        
        if( gestionCuenta.addCuenta( username, password, password2 ) )
        {
            Gestionar_Trabajador gestionTrabajador = new Gestionar_Trabajador();
            
            if( !gestionTrabajador.addTrabajador( nombre, apellido, 2 ) )
                JOptionPane.showMessageDialog(null, "No se pudo registrar el trabajador");
            else
            {
                JOptionPane.showMessageDialog(null, "Se registró con éxito");
                this.dispose();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearCuentaButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel confPassLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoApellido;
    // End of variables declaration//GEN-END:variables
}
