/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Tarea {

    private String descripcion;
    private boolean finalizada = false;
    private boolean asignada = false;
    private boolean aprobada = false;
    private boolean rechazada = false;
    private int importancia = 0;

    public Tarea(String descripcion) {

        this.descripcion = descripcion;

    }

    public Tarea() {

    }

    public boolean aprobada() {

        return aprobada;

    }

    public void finalizar() {
        finalizada = true;
    }

    public boolean esta_finalizada() {
        return finalizada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String prueba_de_Tarea) {
        descripcion = prueba_de_Tarea;
    }

    public void setImportancia(int importancia) {

        this.importancia = importancia;

    }

    public int getImportancia() {

        return importancia;

    }

    public boolean estaAsignada() {
        return asignada;
    }

    public void asignar() {

        asignada = true;

    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    public boolean estaRechazada() {

        return rechazada;

    }

    public void rechazar() {

        rechazada = true;

    }

    public boolean estaAprobada() {
        return aprobada;
    }

    public void aprobar() {

        aprobada = true;
    }

}
