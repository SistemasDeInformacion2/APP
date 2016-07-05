package control;

import java.sql.*;
import java.util.*;

public class Gestionar_Trabajador
{
    private Connection connection;
    
    public Gestionar_Trabajador()
    {
        connection=new ConexionDB().conexion();
    }
    
    public boolean addTrabajador( String nombre, String apellido, int rol )
    {
        boolean success = false;
        
        try
        {
            String query;
            query = "INSERT INTO \"TRABAJADOR\" (\"ROL_ID_ROL\", \"NOMBRE\", \"APELLIDO\") VALUES (?, ?, ?);";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt    (1, rol);
            sentencia.setString (2, nombre);
            sentencia.setString (3, apellido);
            sentencia.execute();
            
            success=true;
            connection.close();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
        
        return success;
    }
}
