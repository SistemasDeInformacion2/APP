package Modelo;

public class Tarea 
{
    private String tarea;
    private boolean finalizada;
    
    public Tarea (String tarea)
    {
        this.tarea=tarea;
        finalizada=false;
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
