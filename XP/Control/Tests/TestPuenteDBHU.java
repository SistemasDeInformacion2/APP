package Control.Tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Control.*;

public class TestPuenteDBHU
{
    public TestPuenteDBHU()
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
    public void testVisitar()
    {
        PuenteDBHU pdb=new PuenteDBHU();
        assertTrue(pdb.visitar()); //En caso visite una persona diferente
        assertFalse(pdb.visitar()); //En caso la visita sea hecha por la misma persona que ya visito antes
    }
}
