/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XP.Modelo;

import control.PuenteDBNuevaCuenta;
import control.ValidarCrearCuenta;
import java.util.logging.Level;
import java.util.logging.Logger;
import visual.CrearCuenta;

/**
 *
 * @author alvaro
 */
public class NuevaCuenta {
    
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correo;
    private String celular;
    private String usuario;
    private String contrasena;
    private String confirmarContrasena;
    
    private ValidarCrearCuenta valCuenta;
    private PuenteDBNuevaCuenta cuentaDB;
    
    public NuevaCuenta(){
        try {
            nombres = "";
            apellidos = "";
            fechaNacimiento = "";
            correo = "";
            celular = "";
            usuario = "";
            contrasena = "";
            confirmarContrasena = "";
            valCuenta = new ValidarCrearCuenta(null);
            cuentaDB = new PuenteDBNuevaCuenta();
        } catch (Exception ex) {
            Logger.getLogger(NuevaCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public NuevaCuenta(CrearCuenta cCuenta){
        try {
            nombres = cCuenta.getTxtNombre();
            apellidos = cCuenta.getTxtApellido();
            fechaNacimiento = cCuenta.getFechaNacimiento();
            correo = cCuenta.getTxtCorreo();
            celular = cCuenta.getTxtCelular();
            usuario = cCuenta.getTxtUsuario();
            contrasena = cCuenta.getTxtContrasena();
            confirmarContrasena = cCuenta.getTxtValContrasena();
            valCuenta = new ValidarCrearCuenta(cCuenta);
            cuentaDB = new PuenteDBNuevaCuenta();
        } catch (Exception ex) {
            Logger.getLogger(NuevaCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int camposRequeridos(){
        return valCuenta.getCamposRequeridos();
    }
    
    public boolean estaDisponibleUsuario(){
        return cuentaDB.estaDisponibleUser(usuario);
    }
    
    public boolean confirmarContrasena(){
        return contrasena.equals(confirmarContrasena);
    }
    
    public boolean esValidaFechaNacimiento(){
        return valCuenta.esFechaValida(fechaNacimiento);
    }
    
    public boolean estaRegistrado(){
        return cuentaDB.estaRegistrado(nombres, apellidos);
    }
    
}
