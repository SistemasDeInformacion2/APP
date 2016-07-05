package control;

public class Tarea
{
    private int id_product_owner, id_historia_usuario, complejidad;
    private String descripcion;
    
    public Tarea( int id_historia_usuario, int id_product_owner, int complejidad, String descripcion )
    {
        this.id_historia_usuario=id_historia_usuario;
        this.id_product_owner=id_product_owner;
        this.complejidad=complejidad;
        this.descripcion=descripcion;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public int getComplejidad()
    {
        return complejidad;
    }
}
