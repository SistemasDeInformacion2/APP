package Modelo;

public class Tarea 
{
    private String tarea;
    private boolean finalizada;
    
    public Tarea (String tarea)
    {
        
    }
    
    public Tarea ()
    {
        
    }
    
    public void finalizada()
    {
        finalizada=true;
    }
    
    public boolean esta_finalizada()
    {
        return finalizada;
    }
}
