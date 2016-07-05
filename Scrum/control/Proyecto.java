package control;

public class Proyecto
{
    private String nombre, descripcion;
    private int idProyecto;
    
    public Proyecto( String nombre, String descripcion, int idProyecto )
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idProyecto = idProyecto;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public int getIdProyecto()
    {
        return idProyecto;
    }
}
