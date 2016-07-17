package Modelo.Tests;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Modelo.*;

public class TestHistoriaUsuario
{
    public TestHistoriaUsuario()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void testDescripcion()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        hu.setDescripcion("Una prueba de historia de usuario");
        assertEquals(hu.getDescripcion(),"Una prueba de historia de usuario");
    }
    
    @Test
    public void testDescripcion2()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        hu.setDescripcion("123");
        assertNull(hu.getDescripcion());
    }
    
    @Test
    public void testDescripcion3()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        hu.setDescripcion("");
        assertNull(hu.getDescripcion());
    }
    
    @Test
    public void testAsociarTarea()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        assertEquals(0,hu.cantidadTareas());
        
        hu.asociarTarea(new Tarea("algo"));
        assertEquals(1,hu.cantidadTareas());
        
        hu.asociarTarea(new Tarea("otro"));
        assertEquals(2,hu.cantidadTareas());
    }
    
    @Test
    public void testSetImportancia()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        hu.setImportancia(3);
        assertEquals(3,hu.getImportancia());
        
        hu.setImportancia(-3);
        assertEquals(0,hu.getImportancia());
    }
    
    @Test
    public void testAsignarHistoria()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        assertFalse(hu.estaAsignada());
        
        hu.asignar();
        assertTrue(hu.estaAsignada());
    }
    
    @Test
    public void testProgreso()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        assertEquals(0,hu.progreso());
        
        hu.asociarTarea(new Tarea("prueba"));
        hu.asociarTarea(new Tarea("otro"));
        hu.asociarTarea(new Tarea("prueba2"));
        hu.asociarTarea(new Tarea("prueba3"));
        
        hu.finalizarTarea("otro");
        
        assertEquals(1,hu.pogreso());
        
        hu.finalizarTarea("otro");
        
        assertEquals(1,hu.progreso());
        
        hu.finalizarTarea("prueba");
        assertEquals(2,hu.progreso());
    }
    
    @Test
    public void testHistoriaFinalizada()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        hu.asociarTarea(new Tarea("prueba2"));
        hu.asociarTarea(new Tarea("prueba3"));
        hu.asociarTarea(new Tarea("prueba4"));
        hu.asociarTarea(new Tarea("prueba5"));
        
        assertFalse(hu.estaFinalizada());
        
        hu.finalizarTarea("prueba2");
        
        assertFalse(hu.estaFinalizada());
        
        hu.finalizarTarea("prueba3");
        
        assertFalse(hu.estaFinalizada());
        
        hu.finalizarTarea("prueba4");
        hu.finalizarTarea("prueba5");
        
        assertTrue(hu.estaFinalizada());
    }
    
    @Test
    public void testHistoriaRechazada()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        assertFalse(hu.estaRechazada());
        
        hu.rechazarHistoria("DESCRIPCION");
        
        assertTrue(hu.estaRechazada());
    }
    
    @Test
    public void testHistoriaAprobada()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        assertFalse(hu.estaAprobada());
        
        hu.aprobar();
        
        assertTrue(hu.estaAprobada());
    }
    
    @Test
    public void testHistoriaAprobada2()
    {
        HistoriaUsuario hu=new HistoriaUsuario();
        
        assertFalse(hu.estaAprobada());
        
        hu.rechazarHistoria("DESCRIPCION");
        
        assertFalse(hu.estaAprobada());
        
        hu.aprobar();
        
        assertFalse(hu.estaAprobada());
    }
}
