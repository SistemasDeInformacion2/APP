/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xp;

/**
 *
 * @author USER
 */
public class Tarea {
    
    private String tarea;
    private boolean finalizada=false;
    
    
    public Tarea (String tarea){
        
        this.tarea=tarea;
        
    }
    
    public void finalizada(){
        finalizada=true;
    }
    public boolean esta_finalizada(){
        return finalizada;
    }
}