package control;

import java.sql.*;
import java.util.*;

public class Gestionar_Proyectos
{
    private Connection connection;
    
    public Gestionar_Proyectos()
    {
        connection=new ConexionDB().conexion();
    }
    
    public boolean addProyecto( String nombre, String descripcion )
    {
        boolean success = false;
        
        try
        {
            String query;
            query = "INSERT INTO \"PROYECTO\" (\"DESCRIPCION\",\"NOMBRE\") VALUES(?, ?);";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString    (1, descripcion);
            sentencia.setString    (2, nombre);
            
            sentencia.execute();
            success = true;
            connection.close();
        }
        catch ( Exception e )
        {
            System.out.println(e);
        }
        
        return success;
    }
    
    public List<Proyecto> getProyectos()
    {
        List<Proyecto> listaDeProyectos = new LinkedList<Proyecto>();
        
        try
        {           
            String query;
            query = "SELECT * FROM \"PROYECTO\";";
        
            PreparedStatement sentencia = connection.prepareStatement(query);       
            ResultSet result=sentencia.executeQuery();
            
            while( result.next() )
            {                
                int idProyecto      = result.getInt("ID_PROY");
                String descripcion  = result.getString("DESCRIPCION");
                String nombre       = result.getString("NOMBRE");
                
                Proyecto proyecto   = new Proyecto( nombre, descripcion, idProyecto );
                    
                listaDeProyectos.add( proyecto );
                //close();
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return listaDeProyectos;
    }
}
