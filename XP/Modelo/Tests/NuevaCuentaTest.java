/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import visual.CrearCuenta;

/**
 *
 * @author alvaro
 */
public class NuevaCuentaTest {
    
    public NuevaCuentaTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }  
    
    @Test
    public void testCamposRequeridos(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertEquals(8, nuevo.camposRequeridos());
    }
    
    @Test
    public void testCamposRequeridos2(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JTextField txtNombre = new JTextField("Lucas");
        cCuenta.setTxtNombre(txtNombre);
        JTextField txtApellido = new JTextField("Barrios");
        cCuenta.setTxtApellido(txtApellido);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertEquals(6, nuevo.camposRequeridos());
    }
    
    @Test
    public void testEstaDisponibleUsuario(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.estaDisponibleUsuario());
    }
    
    @Test
    public void testEstaDisponibleUsuario2(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JTextField txtUsuario = new JTextField("miguel");
        cCuenta.setTxtUsuario(txtUsuario);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.estaDisponibleUsuario());
    }
    
    @Test
    public void testEstaDisponibleUsuario3(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JTextField txtUsuario = new JTextField("miguel6");
        cCuenta.setTxtUsuario(txtUsuario);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.estaDisponibleUsuario());
    }
    
    @Test
    public void testConfirmarContrasena(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.confirmarContrasena());
    }
    
    @Test
    public void testConfirmarContrasena2(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JPasswordField txtContrasena = new JPasswordField("amaterasu");
        cCuenta.setTxtContrasena(txtContrasena);
        JPasswordField txtValContrasena = new JPasswordField("amaterasu");
        cCuenta.setTxtValContrasena(txtValContrasena);;
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.confirmarContrasena());
    }
    
    @Test
    public void testConfirmarContrasena3(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JPasswordField txtContrasena = new JPasswordField("amatera");
        cCuenta.setTxtContrasena(txtContrasena);
        JPasswordField txtValContrasena = new JPasswordField("amaterasu");
        cCuenta.setTxtValContrasena(txtValContrasena);;
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.confirmarContrasena());
    }
    
    @Test
    public void testEsValidaFechaNacimiento(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.esValidaFechaNacimiento());
    }
    
    @Test
    public void testEsValidaFechaNacimiento2(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JComboBox<String> boxAno = new JComboBox<>(new String []{"2016"});
        JComboBox<String> boxMes = new JComboBox<>(new String []{"2"});
        JComboBox<String> boxDia = new JComboBox<>(new String []{"32"});
        cCuenta.setBoxAno(boxAno);
        cCuenta.setBoxMes(boxMes);
        cCuenta.setBoxDia(boxDia);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.esValidaFechaNacimiento());
    }
    
    @Test
    public void testEsValidaFechaNacimiento3(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JComboBox<String> boxAno = new JComboBox<>(new String []{"2016"});
        JComboBox<String> boxMes = new JComboBox<>(new String []{"2"});
        JComboBox<String> boxDia = new JComboBox<>(new String []{"10"});
        cCuenta.setBoxAno(boxAno);
        cCuenta.setBoxMes(boxMes);
        cCuenta.setBoxDia(boxDia);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.esValidaFechaNacimiento());
    }
    
    @Test
    public void testEstaRegistrado(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.estaRegistrado());
    }
    
    @Test
    public void testEstaRegistrado2(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JTextField txtNombre = new JTextField("Lucas");
        cCuenta.setTxtNombre(txtNombre);
        JTextField txtApellido = new JTextField("Barrios");
        cCuenta.setTxtApellido(txtApellido);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertFalse(nuevo.estaRegistrado());
    }
    
    @Test
    public void testEstaRegistrado3(){
        CrearCuenta cCuenta = new CrearCuenta(null);
        JTextField txtNombre = new JTextField("Miguel");
        cCuenta.setTxtNombre(txtNombre);
        JTextField txtApellido = new JTextField("Catari");
        cCuenta.setTxtApellido(txtApellido);
        NuevaCuenta nuevo = new NuevaCuenta(cCuenta);
        assertTrue(nuevo.estaRegistrado());
    }
}
