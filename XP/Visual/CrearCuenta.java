/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XP.Visual;

import XP.Control.PuenteDBNuevaCuenta;
import XP.Control.ValidarCrearCuenta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class CrearCuenta extends javax.swing.JFrame {

    /**
     * Creates new form CrearCuenta
     */
    public CrearCuenta() {
        initComponents();
        this.setTitle("Nueva cuenta");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        try {
            conexion = new PuenteDBNuevaCuenta();
        } catch (Exception ex) {
            Logger.getLogger(CrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxDia = new javax.swing.JComboBox<>();
        lblFechaNacimiento = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox<>();
        boxAno = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        txtValContrasena = new javax.swing.JPasswordField();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblValContrasena = new javax.swing.JLabel();
        botOk = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        valNombre = new javax.swing.JLabel();
        valApellido = new javax.swing.JLabel();
        valCorreo = new javax.swing.JLabel();
        valCelular = new javax.swing.JLabel();
        valUsuario = new javax.swing.JLabel();
        valContrasena = new javax.swing.JLabel();
        valConfContrasena = new javax.swing.JLabel();
        valFechaNacimiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellidos:");

        boxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Dia","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));

        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Mes","1","2","3","4","5","6","7","8","9","10","11","12"}));

        boxAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Año","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979",
            "1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
            "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
            "2000","2001","2002"}));

lblCorreo.setText("Correo electrónico:");

lblCelular.setText("Celular:");

lblUsuario.setText("Usuario:");

lblContrasena.setText("Contraseña:");

lblValContrasena.setText("Confirmar Contraseña:");

botOk.setText("OK");
botOk.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        botOkActionPerformed(evt);
    }
    });

    btCancelar.setText("Cancelar");
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btCancelarActionPerformed(evt);
        }
    });

    valNombre.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valApellido.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valCorreo.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valCelular.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valUsuario.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valContrasena.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valConfContrasena.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    valFechaNacimiento.setFont(new java.awt.Font("Droid Sans", 0, 10)); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(lblCorreo)
                        .addComponent(lblFechaNacimiento)
                        .addComponent(lblCelular)
                        .addComponent(lblUsuario)
                        .addComponent(lblContrasena)
                        .addComponent(lblValContrasena))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(txtCorreo)
                        .addComponent(txtUsuario)
                        .addComponent(txtContrasena)
                        .addComponent(txtValContrasena))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valCorreo)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(valApellido))
                                .addComponent(valCelular)
                                .addComponent(valUsuario)
                                .addComponent(valContrasena)
                                .addComponent(valConfContrasena))
                            .addGap(0, 54, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(valFechaNacimiento)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(botOk, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btCancelar))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombre)
                        .addComponent(lblApellido))
                    .addGap(79, 79, 79)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addComponent(txtNombre))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(valNombre))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblApellido)
                .addComponent(valApellido))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valFechaNacimiento))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCorreo)
                .addComponent(valCorreo))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel3))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCelular)
                        .addComponent(valCelular))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblUsuario)
                .addComponent(valUsuario))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblContrasena)
                        .addComponent(valContrasena))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblValContrasena)
                        .addComponent(valConfContrasena))
                    .addGap(28, 84, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCancelar)
                        .addComponent(botOk))
                    .addContainerGap())))
    );

    pack();
    }// </editor-fold>                        

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
        new Principal();
    }                                          

    private void botOkActionPerformed(java.awt.event.ActionEvent evt) {                                      
        validarCuenta = new ValidarCrearCuenta(this);
        if(validarCuenta.getCamposRequeridos()==0){
            conexion.registrarUser(getTxtUsuario(),getTxtContrasena());
            conexion.registrarPersona(getTxtNombre(),getTxtApellido(),getFechaNacimiento(),getTxtCorreo(),getTxtCelular());
            JOptionPane.showMessageDialog(null, "Sus datos se han guardado satisfactoriamente","Registro Completado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new Principal();
        }
    }                                     
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton botOk;
    private javax.swing.JComboBox<String> boxAno;
    private javax.swing.JComboBox<String> boxDia;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JButton btCancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValContrasena;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtValContrasena;
    private javax.swing.JLabel valApellido;
    private javax.swing.JLabel valCelular;
    private javax.swing.JLabel valConfContrasena;
    private javax.swing.JLabel valContrasena;
    private javax.swing.JLabel valCorreo;
    private javax.swing.JLabel valFechaNacimiento;
    private javax.swing.JLabel valNombre;
    private javax.swing.JLabel valUsuario;
    // End of variables declaration                   
    private Principal principal;
    private ValidarCrearCuenta validarCuenta;
    private PuenteDBNuevaCuenta conexion;
    
    public String getTxtApellido() {
        return txtApellido.getText();
    }

    public String getTxtCelular() {
        return txtCelular.getText();
    }

    public String getTxtContrasena() {
        return new String(txtContrasena.getPassword());
    }

    public String getTxtCorreo() {
        return txtCorreo.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

    public String getTxtValContrasena() {
        return new String(txtValContrasena.getPassword());
    }
    
    public String getFechaNacimiento(){
        String ano = (String) boxAno.getSelectedItem();
        String mes = (String) boxMes.getSelectedItem();
        String dia = (String) boxDia.getSelectedItem();
        return ano+"-"+mes+"-"+dia;
    }

    public void setValApellido(String mensaje) {
        valApellido.setText(mensaje);
    }

    public void setValCelular(String mensaje) {
        valCelular.setText(mensaje);
    }

    public void setValConfContrasena(String mensaje) {
        valConfContrasena.setText(mensaje);
    }

    public void setValContrasena(String mensaje) {
        valContrasena.setText(mensaje);
    }

    public void setValCorreo(String mensaje) {
        valCorreo.setText(mensaje);
    }

    public void setValNombre(String mensaje) {
        valNombre.setText(mensaje);
    }

    public void setValUsuario(String mensaje) {
        valUsuario.setText(mensaje);
    }
    
    public void setValFechaNacimiento(String mensaje) {
        valFechaNacimiento.setText(mensaje);
    }
}
