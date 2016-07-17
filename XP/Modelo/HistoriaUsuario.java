package Modelo;

import java.util.ArrayList;
import Control.*;

public class HistoriaUsuario 
{
    private String descripcion;
    private ArrayList<Tarea> tareas_asociadas;
    private int importancia;
    private boolean asignada=false;
    private boolean finalizada=false;
    private boolean rechazada=false;
    private ControlHU controlHU;
    
    public HistoriaUsuario()
    {
        tareas_asociadas = new ArrayList<Tarea>();
        controlHU = new ControlHU();
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
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
        this.importancia+=importancia;
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
    
    public void rechazarHistoria( String descripcion )
    {
        controlHU.rechazar( descripcion );
        rechazada=true;
    }
    
    public boolean estaRechazada()
    {
        return rechazada;
    }
    
    public boolean estaAprobada()
    {
        return controlHU.estaAprobada();
    }
    
    public void aprobar()
    {
        controlHU.aprobar();
    }
    
    public void finalizar()
    {
        for( int i=0; i<tareas_asociadas.size(); i++ )
        {
            tareas_asociadas.get(i).finalizar();
        }
        
        finalizada=true;
    }
}
