package XP.Modelo;

import java.util.ArrayList;
import XP.Control.*;

public class HistoriaUsuario 
{
    private String descripcion, nombre;
    private ArrayList<Tarea> tareas_asociadas;
    private int importancia;
    private int id_hu;
    private boolean asignada=false;
    private boolean aprobada=false;
    private boolean finalizada=false;
    private boolean rechazada=false;
    
    public HistoriaUsuario()
    {
        id_hu=-1;
        tareas_asociadas = new ArrayList<Tarea>();
    }
    
    public HistoriaUsuario( String nombre, String descripcion, int importancia )
    {
        id_hu=-1;
        tareas_asociadas = new ArrayList<Tarea>();
        setDescripcion( descripcion );
        setImportancia( importancia );
        setNombre( nombre );
    }
    
    public HistoriaUsuario( String nombre, String descripcion, int importancia, int id_hu )
    {
        this.id_hu=id_hu;
        tareas_asociadas = new ArrayList<Tarea>();
        setDescripcion( descripcion );
        setImportancia( importancia );
        setNombre( nombre );
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion( String descripcion )
    {
        if( !descripcion.equals("") && !descripcion.chars().allMatch( Character::isDigit ) )
            this.descripcion=descripcion;
    }
    
    public void asociarTarea(Tarea t)
    {
        tareas_asociadas.add(t);
    }
    
    public int cantidadTareas()
    {
        int cantidad=tareas_asociadas.size();
        
        return cantidad;
    }
    
    public void setImportancia (int importancia)
    {
        this.importancia=importancia;
    }
    
    public int getImportancia()
    {
        return importancia;
    }
    
    public boolean estaAsignada()
    {
        return asignada;
    }
    
    public void asignar()
    {
        asignada=true;
    }
    
    public void finalizarTarea(int pocision_tarea)
    {
        tareas_asociadas.get(pocision_tarea).finalizar();
    }
    
    public void finalizarTarea( String nombre_Tarea )
    {
        boolean aux_tarea_encontrada=false;
        
        for( int i=0; i<tareas_asociadas.size() && !aux_tarea_encontrada; i++ )
        {
            if( tareas_asociadas.get(i).getDescripcion().equals( nombre_Tarea ) )
            {
                tareas_asociadas.get(i).finalizar();
                aux_tarea_encontrada=true;
            }
        }
        
        if( progreso()==tareas_asociadas.size() )
            finalizada=true;
    } 
    
    public int progreso()
    {
        int progreso=0;
        
        for( int i=0; i<tareas_asociadas.size(); i++ )
        {
            if( tareas_asociadas.get(i).esta_finalizada() )
                progreso++;
        }
        
        return progreso;
    }
    
    public boolean estaFinalizada()
    {
        return finalizada;
    }
    
    public void rechazarHistoria()
    {
        rechazada=true;
    }
    
    public void rechazarHistoria( String descripcion )
    {
        ControlHU controlHU = new ControlHU(this);
        controlHU.rechazar( descripcion );
        
        rechazada=true;
    }
    
    public boolean estaRechazada()
    {
        return rechazada;
    }
    
    public boolean estaAprobada()
    {
        return aprobada;
    }
    
    public void aprobar()
    {
        aprobada=true;
    }
    
    public void finalizar()
    {
        for( int i=0; i<tareas_asociadas.size(); i++ )
        {
            tareas_asociadas.get(i).finalizar();
        }
        
        finalizada=true;
    }
    
    public void setNombre( String nombre )
    {
        if( !nombre.equals("") && !nombre.chars().allMatch( Character::isDigit ) )
            this.nombre=nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getId()
    {
        return id_hu;
    }
}
