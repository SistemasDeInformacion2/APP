package control;

import java.sql.*;
import java.util.*;

public class GestionarSprint
{
    private Connection connection;
    
    public GestionarSprint ()
    {
        connection=new ConexionDB().conexion();
    }
    
    public boolean addSprint( String dia1, String mes1, String anho1, String dia2, String mes2, String anho2, int po, int team, int planning )
    {
        boolean res=false;
        planning=team=po=1;
        
        java.sql.Date date1 = new java.sql.Date(Integer.parseInt(anho1),Integer.parseInt(mesConversion(mes1)),Integer.parseInt(dia1));
        java.sql.Date date2 = new java.sql.Date(Integer.parseInt(anho2),Integer.parseInt(mesConversion(mes2)),Integer.parseInt(dia2));
        
        try
        {           
            String query;
            query = "INSERT INTO \"SPRINT\" (\"PLANNING_MIEMBRO EQUIPO_ID_EQ\", \"PLANNING_PRODUCT OWNER_ID_PO\", \"PLANNING_ID_P\", \"FECHAINI\", \"FECHAFIN\") VALUES (?,?,?,?,?);";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt  ( 1, team );
            sentencia.setInt  ( 2, po );
            sentencia.setInt  ( 3, planning );
            sentencia.setDate ( 4, date1 );
            sentencia.setDate ( 5, date2 );
            
            sentencia.execute();
            
            connection.close();
            res=true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return res;
        
    }
    
    private String mesConversion(String m)
    {
        String res1="1";
        
        if (m.equals("Enero")) res1="1";
        if (m.equals("Febrero")) res1="2";
        if (m.equals("Marzo")) res1="3";
        if (m.equals("Abril")) res1="4";
        if (m.equals("Mayo")) res1="5";
        if (m.equals("Junio")) res1="6";
        if (m.equals("Julio")) res1="7";
        if (m.equals("Agosto")) res1="8";
        if (m.equals("Septiembre")) res1="9";
        if (m.equals("Octubre")) res1="10";
        if (m.equals("Noviembre")) res1="11";
        if (m.equals("Diciembre")) res1="12";
        
        return res1;
    }
}