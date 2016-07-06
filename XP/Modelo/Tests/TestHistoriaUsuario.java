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
}
