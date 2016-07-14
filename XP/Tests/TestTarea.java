

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTarea
{
    public TestTarea()
    {
    }
    @Before
    public void setUp()
    {
    }
    @After
    public void tearDown()
    {
    }
    @Test
    public void testSetGetDescripcion(){
        Tarea t=new Tarea();
        t.setDescripcion("some");
        assertEquals(t.getDescripcion(),"some");
        t.setDescripcion("algo");
        assertEquals(t.getDescripcion(),"algo");
    }
}
