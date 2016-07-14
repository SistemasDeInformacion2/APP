

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PuenteDBHU
{
    public PuenteDBHU()
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
    public void testVisitar(){
        PuenteDB pdb=new PuenteDBHU();
        assertTrue(pdb.visitar()); //En caso visite una persona difere
        assertFalse(pdb.visitar()); //En caso la visita sea hecha por la misma persona que ya visito antes
        
    }
}
