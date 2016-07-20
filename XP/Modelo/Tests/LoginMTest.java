/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import visual.Login;
import visual.Principal;

/**
 *
 * @author alvaro
 */
public class LoginMTest {
    
    public LoginMTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of permitirIngreso method, of class LoginM.
     */
    @Test
    public void testPermitirIngreso() {
        LoginM log = new LoginM();
        assertFalse(log.permitirIngreso());
    }
    
    @Test
    public void testPermitirIngreso2() {
        Principal main = new Principal();
        Login login = new Login(main);
        JTextField txtUsuario = new JTextField("miguel6");
        login.setTxtUsuario(txtUsuario);
        JPasswordField txtContrasena = new JPasswordField("mmmm");
        login.setTxtContrasena(txtContrasena);
        LoginM log = new LoginM(login);
        assertTrue(log.permitirIngreso());
    }
    
    @Test
    public void testPermitirIngreso3() {
        Principal main = new Principal();
        Login login = new Login(main);
        JTextField txtUsuario = new JTextField("mig");
        login.setTxtUsuario(txtUsuario);
        JPasswordField txtContrasena = new JPasswordField("kaf");
        login.setTxtContrasena(txtContrasena);
        LoginM log = new LoginM(login);
        assertFalse(log.permitirIngreso());
    }
    @Test
    public void testPermitirIngreso4() {
        Principal main = new Principal();
        Login login = new Login(main);
        LoginM log = new LoginM(login);
        assertFalse(log.permitirIngreso());
    }
}
