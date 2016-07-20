/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import visual.CrearCuenta;

/**
 *
 * @author alvaro
 */
public class ValidarCrearCuenta {
    
    private CrearCuenta nuevaCuenta;
    private int camposRequeridos;
    private PuenteDBNuevaCuenta conx;
    
    public ValidarCrearCuenta(CrearCuenta nueva){
        try {
            nuevaCuenta = nueva;
            camposRequeridos = 0;
            conx = new PuenteDBNuevaCuenta();
            validarNombre();
            validarApellido();
            validarFechaNacimiento();
            validarCorreo();
            validarCelular();
            validarUsuario();
            validarContrasena();
            validarConfContrasena();
        } catch (Exception ex) {
            Logger.getLogger(ValidarCrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarNombre(){
        if(nuevaCuenta.getTxtNombre().equals("")){
            nuevaCuenta.setValNombre("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^[A-Za-z][A-Za-z ]+$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtNombre());
            if(mat.find()){
                nuevaCuenta.setValNombre("");
                personaRegistrada();
            }else{
                nuevaCuenta.setValNombre("Caracteres Invalidos");
                camposRequeridos++;
            }
        }
    }
    
    public void validarApellido(){
        if(nuevaCuenta.getTxtApellido().equals("")){
            nuevaCuenta.setValApellido("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^[A-Za-z][A-Za-z ]+$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtApellido());
            if(mat.find()){
                nuevaCuenta.setValApellido("");
                personaRegistrada();
            }else{
                nuevaCuenta.setValApellido("Caracteres Invalidos");
                camposRequeridos++;
            }
        }
    }
    
    public void personaRegistrada(){
        if(conx.estaRegistrado(nuevaCuenta.getTxtNombre(), nuevaCuenta.getTxtApellido())){
            nuevaCuenta.setValNombre("Nombre Registrado");
            nuevaCuenta.setValApellido("Apellido Registrado");
            camposRequeridos++;
            camposRequeridos++;
        }else{
            nuevaCuenta.setValUsuario("");
        }
    }
    
    public void validarFechaNacimiento(){
        if(esFechaValida(nuevaCuenta.getFechaNacimiento())){
            nuevaCuenta.setValFechaNacimiento("");
        }else{
            nuevaCuenta.setValFechaNacimiento("Fecha invalida");
            camposRequeridos++;
        }
    }
    
    public boolean esFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public void validarCorreo(){
        if(nuevaCuenta.getTxtCorreo().equals("")){
            nuevaCuenta.setValCorreo("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtCorreo());
            if(mat.find()){
                nuevaCuenta.setValCorreo("");
            }else{
                nuevaCuenta.setValCorreo("Correo invalido");
                camposRequeridos++;
            }
        }
    }
    
    public void validarCelular(){
        if(nuevaCuenta.getTxtCelular().equals("")){
            nuevaCuenta.setValCelular("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^[0-9]{8,11}$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtCelular());
            if(mat.find()){
                nuevaCuenta.setValCelular("");
            }else{
                nuevaCuenta.setValCelular("Número de 8 digitos");
                camposRequeridos++;
            }
        }
    }
    
    public void validarUsuario(){
        if(nuevaCuenta.getTxtUsuario().equals("")){
            nuevaCuenta.setValUsuario("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^[\\w-_]+$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtUsuario());
            if(mat.find()){
                nuevaCuenta.setValUsuario("");
                usuarioDisponible();
            }else{
                nuevaCuenta.setValUsuario("Caracteres invalidos");
                camposRequeridos++;
            }
        }
    }
    
    public void usuarioDisponible(){
        if(conx.estaDisponibleUser(nuevaCuenta.getTxtUsuario())){
            nuevaCuenta.setValUsuario("");
        }else{
            nuevaCuenta.setValUsuario("Usuario Registrado");
            camposRequeridos++;
        }
    }
    
    public void validarContrasena(){
        if(nuevaCuenta.getTxtContrasena().equals("")){
            nuevaCuenta.setValContrasena("Obligatorio");
            camposRequeridos++;
        }else{
            Pattern pat = Pattern.compile("^.*$");
            Matcher mat = pat.matcher(nuevaCuenta.getTxtContrasena());
            if(mat.find()){
                nuevaCuenta.setValContrasena("");
            }else{
                nuevaCuenta.setValContrasena("Caracteres invalidos");
                camposRequeridos++;
            }
        }
    }
    
    public void validarConfContrasena(){
        if(nuevaCuenta.getTxtValContrasena().equals("")){
            nuevaCuenta.setValConfContrasena("Obligatorio");
            camposRequeridos++;
        }else if(nuevaCuenta.getTxtValContrasena().equals(nuevaCuenta.getTxtContrasena())){
            nuevaCuenta.setValConfContrasena("");
        }else{
            nuevaCuenta.setValConfContrasena("Contraseña Incorrecta");
            camposRequeridos++;
        }
    }
    
    public int getCamposRequeridos(){
        return camposRequeridos;
    }
}
