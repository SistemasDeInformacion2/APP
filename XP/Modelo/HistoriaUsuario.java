/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class HistoriaUsuario {
    
    private String descripcion=null;
    private ArrayList<Tarea> tareas_asociadas=new ArrayList();
    private int importancia;
    private boolean asignada=false;
    private boolean finalizada=false;
    public HistoriaUsuario(){
        
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        
        this.descripcion=descripcion;
        
    }
    
    public void asociarTarea(Tarea t){
        
        tareas_asociadas.add(t);
        
    }
    
    public int cantidadTareas(){
        
        int cantidad=tareas_asociadas.size();
        
        return cantidad;
    }
    
    public void setImportancia (int importancia){
        this.importancia+=importancia;
    }
    
    public int getImportancia(){
        
        return importancia;
        
    }
    
    public boolean estaAsignada(){
        return asignada;
    }
    
    public void asignar(){
        
        asignada=true;
        
    }
    
    public void finalizarTarea(int pocision_tarea){
        
        tareas_asociadas.get(pocision_tarea).finalizada();
        
    }
    
    public boolean estaFinalizada(){
        
        int finalizadas=0;
        for(int i=0;i<tareas_asociadas.size();i++){
            
            if(tareas_asociadas.get(i).esta_finalizada()){
                finalizadas++;
            }
            
        }
        
        if(finalizadas==tareas_asociadas.size()){
            finalizada=true;
        }
        return finalizada;
    }
    
}
