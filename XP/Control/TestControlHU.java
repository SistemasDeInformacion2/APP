package Tests;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestControlHU
{
    public TestControlHU()
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
    public void testControlVisita(){
        ControlHU cs=new ControlHU();
        cs.visitar();
        assertEquals(cs.progreso(),1);
        cs.visitar();
        assertEquals(cs.progreso(),2);
        cs.visitar();
        assertEquals(cs.progreso(),2);
    }
    @Test
    public void testFullifiedBar(){
        ControlHU cs=new ControlHU();
        cs.visitar();
        assertEquals(cs.progreso(),1);
        cs.visitar();
        assertEquals(cs.progreso(),2);
        cs.visitar();
        assertEquals(cs.progreso(),2);
        assertFalse(cs.full());
        cs.visitar();
        assertTrue(cs.full());
        assertEquals(cs.progreso(),cs.expectedVisited());
    }
}
