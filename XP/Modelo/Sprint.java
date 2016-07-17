package Modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Sprint 
{
    private int diaInicio = 0;
    private int mesInicio = 0;
    private int anhoInicio = 0;
    private int diaFin = 0;
    private int mesFin = 0;
    private int anhoFin = 0;
    private ArrayList<HistoriaUsuario> historiasAsignadas;
    private boolean finalizado;

    public Sprint(ArrayList<HistoriaUsuario> historias) 
    {
        historiasAsignadas = new ArrayList<HistoriaUsuario>();
        historiasAsignadas = historias;
    }

    public Sprint() 
    {
        historiasAsignadas = new ArrayList<HistoriaUsuario>();
    }

    public int historiasCompletadas() 
    {
        int completadas = 0;
        int cantidad_tareas = historiasAsignadas.size();

        for (int i = 0; i < cantidad_tareas; i++) 
        {
            if ( historiasAsignadas.get(i).estaFinalizada() ) 
            {
                completadas++;
            }
        }

        return completadas;
    }

    public int historiasAsignadas() 
    {
        int asignadas = historiasAsignadas.size();
        return asignadas;
    }

    public int tiempoRestante() 
    {
        if (anhoFin == LocalDateTime.now().getYear()) {
            if (mesFin == LocalDateTime.now().getMonthValue()) {
                if (diaFin == LocalDateTime.now().getDayOfMonth()) {

                    finalizado = true;
                }
            }
        }

        int mmdd = 0;
        if (!finalizado) {
            mmdd = (mesFin - LocalDateTime.now().getMonthValue()) * 100;
            if (diaFin < LocalDateTime.now().getDayOfMonth()) {
                mmdd += 31 - LocalDateTime.now().getDayOfMonth() + diaFin;
                System.out.println(LocalDateTime.now().getMonthValue());
            } else {

                mmdd += (diaFin - LocalDateTime.now().getDayOfMonth());

            }

        }

        return mmdd;

    }

    public boolean sprintTerminado() {

        return finalizado;

    }

    public void setDiaInicio(int dia) {
        diaInicio = dia;
    }

    public void setDiaFin(int dia) {
        diaFin = dia;
    }

    public void setMesInicio(int mes) {
        mesInicio = mes;
    }

    public void setAnhoInicio(int anho) {
        anhoInicio = anho;
    }

    public void setMesFin(int mes) {
        mesFin = mes;
    }

    public void setAnhoFin(int anho) {
        anhoFin = anho;
    }

    public void finalizar() {
        finalizado = true;
    }

    public int historiasFaltantes() 
    {
        int faltantes = 0;
        for (int i = 0; i < historiasAsignadas.size(); i++) 
        {
            if ( !historiasAsignadas.get(i).estaFinalizada() ) 
            {
                faltantes++;
            }
        }
        
        return faltantes;
    }

}
