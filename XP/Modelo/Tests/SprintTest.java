/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tests;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Modelo.*;

/**
 *
 * @author Jose
 */
public class SprintTest {
    
    public SprintTest() {
    }
    @Before
    public void setUp()
    {
    }    
    @Test
    public void testTiempoRestante(){        
        Sprint sprint=new Sprint();        
        sprint.setDiaInicio(1);
        sprint.setDiaFin(30);
        sprint.setMesInicio(1);
        sprint.setMesFin(8);        
        sprint.setAnhoInicio(2016);
        sprint.setAnhoFin(2016);              
        assertEquals(113,sprint.tiempoRestante()); 
    }
    @Test
    public void testTiempoRestante2(){        
        Sprint sprint=new Sprint();               
        sprint.finalizar();                    
        assertEquals(0,sprint.tiempoRestante()); 
    }
    @Test
    public void testSprintTerminado(){        
        Sprint sprint=new Sprint();         
        assertFalse(sprint.sprintTerminado());       
        sprint.finalizar();            
        assertTrue(sprint.sprintTerminado());
    }    
    @Test
    public void testHistoriasAsignadas(){   
        
        ArrayList<HistoriaUsuario> historias=new ArrayList<HistoriaUsuario>();
        HistoriaUsuario h1 = new HistoriaUsuario(); 
        historias.add(h1);
        HistoriaUsuario h2 = new HistoriaUsuario(); 
        historias.add(h2);
        HistoriaUsuario h3 = new HistoriaUsuario();
        historias.add(h3);
        HistoriaUsuario h4 = new HistoriaUsuario();
        historias.add(h4);        
        Sprint sprint=new Sprint(historias);  
        assertEquals(4,sprint.historiasAsignadas());
    }
    
    @Test
    public void testHistoriasCompletadas()
    {   
        ArrayList<HistoriaUsuario> historias=new ArrayList<HistoriaUsuario>();
        HistoriaUsuario h1 = new HistoriaUsuario(); 
        historias.add(h1);
        h1.finalizar();
        HistoriaUsuario h2 = new HistoriaUsuario(); 
        historias.add(h2);
        h2.finalizar();
        HistoriaUsuario h3 = new HistoriaUsuario();
        historias.add(h3);
        HistoriaUsuario h4 = new HistoriaUsuario();
        historias.add(h4);
                
        Sprint sprint=new Sprint(historias);  
        assertEquals(2,sprint.historiasCompletadas());
    }
    
    @Test
    public void testHistoriasFaltantes()
    {     
        ArrayList<HistoriaUsuario> historias=new ArrayList<HistoriaUsuario>(); 
        
        HistoriaUsuario h1 = new HistoriaUsuario();   
        historias.add(h1);
        h1.finalizar();
        HistoriaUsuario h2 = new HistoriaUsuario(); 
        historias.add(h2);
        HistoriaUsuario h3 = new HistoriaUsuario();     
        historias.add(h3);
        HistoriaUsuario h4 = new HistoriaUsuario();
        historias.add(h4);
               
        Sprint sprint=new Sprint(historias);  
        assertEquals(3,sprint.historiasFaltantes());
    }
    
    @After
    public void tearDown() {
    } 
}
