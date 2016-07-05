package control;

import java.sql.*;
import java.util.*;

public class Gestionar_Cuentas
{
    private Connection connection;
    
    public Gestionar_Cuentas()
    {
        connection=new ConexionDB().conexion();
    }
    
    public boolean addCuenta( String username, String password, String password2 )
    {
        boolean success = false;
        
        if( password.equals(password2) )
        {
            try
            {
                String query;
                query = "INSERT INTO \"CUENTAS\" (\"USUARIO\", \"PASSWORD\") VALUES (?, ?);";
                PreparedStatement sentencia = connection.prepareStatement(query);
                sentencia.setString (1, username);
                sentencia.setString (2, password);  
                sentencia.execute();
                
                success=true;
                connection.close();
            }
            catch( Exception e )
            {
                System.out.println(e);
            }
        }
        
        return success;
    }
    
    public boolean comprobarCuenta( String username, String password )
    {
        boolean success = false;
        
        try
        {
            String query;
            query = "SELECT * FROM \"CUENTAS\" WHERE \"USUARIO\"=? and \"PASSWORD\"=? ;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1, username);
            sentencia.setString (2, password);  
            
            ResultSet respuesta = sentencia.executeQuery();
            
            if( respuesta.next() )
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
