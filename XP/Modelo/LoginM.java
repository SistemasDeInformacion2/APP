/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.PuenteDBLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import visual.Login;

/**
 *
 * @author alvaro
 */
public class LoginM {
    
    private String usuario;
    private String contrasena;
    private PuenteDBLogin conexion;
    
    public LoginM(){
        usuario = "";
        contrasena = "";
        
        try {
            conexion = new PuenteDBLogin();
        } catch (Exception ex) {
            Logger.getLogger(LoginM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LoginM(Login login){
        usuario = login.getTxtUsuario();
        contrasena = login.getTxtContrasena();
        
        try {
            conexion = new PuenteDBLogin();
        } catch (Exception ex) {
            Logger.getLogger(LoginM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean permitirIngreso(){
        return conexion.comprobarCuenta(usuario, contrasena);
    }
    
}
