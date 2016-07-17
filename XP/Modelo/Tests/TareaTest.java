/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tests;

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
public class TareaTest {
    
    public TareaTest() {
    }        
    @Before
    public void setUp()
    {
    }
    @Test
    public void testDescripcionTarea(){
        Tarea tarea=new Tarea();
        tarea.setDescripcion("Prueba de Tarea");
        assertEquals(tarea.getDescripcion(),"Prueba de Tarea");
    }
    @Test
    public void testImportancia(){
        Tarea tarea=new Tarea();        
        tarea.setImportancia(5);
        assertEquals(5,tarea.getImportancia());
    }
    @Test
    public void testTareaAsignada(){ 
        Tarea tarea=new Tarea(); 
        assertFalse(tarea.estaAsignada());        
        tarea.asignar();
        assertTrue(tarea.estaAsignada());
    }
    @Test
    public void testTareaFinalizada(){        
        Tarea tarea=new Tarea();         
        assertFalse(tarea.estaFinalizada());       
        tarea.finalizar();            
        assertTrue(tarea.estaFinalizada());
    }
    @Test
    public void testTareaRechazada(){
        Tarea tarea=new Tarea();         
        assertFalse(tarea.estaRechazada());        
        tarea.rechazar();        
        assertTrue(tarea.estaRechazada());
    }
    @Test
    public void testHistoriaAprobada(){
        Tarea tarea=new Tarea();         
        assertFalse(tarea.estaAprobada());        
        tarea.aprobar();        
        assertTrue(tarea.estaAprobada());
    }    
    @After
    public void tearDown() {
    } 
    
}
