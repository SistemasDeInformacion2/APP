package control;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Gestionar_TareasTest
{
    public Gestionar_TareasTest()
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
    public void addTarea()
    {
        control.Gestionar_Tareas gestiona1 = new control.Gestionar_Tareas();
        assertEquals(true, gestiona1.subir_Tareas(1, 1, "hola", 2));
    }
}

