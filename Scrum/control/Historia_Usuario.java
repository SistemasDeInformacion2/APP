package control;

public class Historia_Usuario
{
    int id_historia_usuario, id_product_owner, complejidad, importancia;
    String titulo, descripcion, condiciones_satisfaccion;
    
    public Historia_Usuario( int id_historia_usuario, int id_product_owner, int complejidad,
            int importancia, String titulo, String descripcion, String condiciones_satisfaccion )
    {
        this.id_historia_usuario      = id_historia_usuario;
        this.id_product_owner         = id_product_owner;
        this.complejidad              = complejidad;
        this.importancia              = importancia;
        this.titulo                   = titulo;
        this.descripcion              = descripcion;
        this.condiciones_satisfaccion = condiciones_satisfaccion;
    }
    
    public int getComplejidad()
    {
        return complejidad;
    }
    
    public int getImportancia()
    {
        return importancia;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public String getCondiciones()
    {
        return condiciones_satisfaccion;
    }
}
