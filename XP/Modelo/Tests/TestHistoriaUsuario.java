package Tests;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestHistoriaUsuario
{
    private HistoriaUsuario hu;
    public TestHistoriaUsuario()
    {
    }
    @Before
    public void setUp()
    {
        hu=new HistoriaUsuario();
    }
    @Test
    public void testDescripcion(){
        hu.setDescripcion("Una prueba de historia de usuario");
        assertEquals(hu.getDescripcion(),"Una prueba de historia de usuario");
    }
    @Test
    public void testDescripcion2(){
        hu.setDescripcion("123");
        assertNull(hu.getDescripcion());
    }
    @Test
    public void testDescripcion3(){
        hu.setDescripcion("");
        assertNull(hu.getDescripcion());
    }
    @Test
    public void testAsociarTarea(){
        assertEquals(0,hu.cantidadTareas());
        
        hu.asociarTarea(new Tarea("algo",12,2));
        assertEquals(1,hu.cantidadTareas());
        
        hu.asociarTarea(new Tarea("otro",23,3));
        assertEquals(2,hu.cantidadTareas());
    }
    @Test
    public void testQuitarTarea(){
        assertEquals(2,hu.cantidadTareas());
        
        hu.quitarTarea(1);
        assertEquals(1,hu.cantidadTareas());
        
        hu.quitarTarea(2);
        assertEquals(0,hu.cantidadTareas());
        
        hu.quitarTarea(4);
        assertEquals(0,hu.cantidadTareas());
    }
    @Test
    public void testSetImportancia(){
        hu.setImportancia(3);
        assertEquals(3,hu.getImportancia());
        
        hu.setImportancia(-3);
        assertEquals(0,hu.getImportancia());
    }
}
