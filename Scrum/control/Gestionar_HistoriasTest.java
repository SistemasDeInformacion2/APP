package control;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Gestionar_HistoriasTest
{
    public Gestionar_HistoriasTest()
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
    public void pruebaAdd()
    {
        Gestionar_Historias gestiona1 = new Gestionar_Historias();
        gestiona1.addHistoria("asdf", "asdf", "asdf", 5, 5, 1);
    }
    
    @Test
    public void pruebaEdit()
    {
        Gestionar_Historias gestiona1 = new Gestionar_Historias();
        gestiona1.editHistoria(5, "hola", "hola", "qwerqw", 2, 2, 1);
    }
    
    @Test
    public void pruebaDelete()
    {
        Gestionar_Historias gestiona1 = new Gestionar_Historias();
        gestiona1.delHistoria(5);
    }
}

