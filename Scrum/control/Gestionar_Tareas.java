package control;

import java.sql.*;
import java.util.*;

public class Gestionar_Tareas
{   
    private Connection connection;
    
    public Gestionar_Tareas()
    {
        connection=new ConexionDB().conexion();
    }
    
    public boolean subir_Tareas( int id_historia_usuario, int id_product_owner, String descripcion, int complejidad )
    {
        boolean success=false;
        
        try
        {           
            String query;
            
            query = "INSERT INTO \"TAREA\" (\"HISTORIA DE USUARIO_ID_HIUS\",\"HISTORIA DE USUARIO_PRODUCT OWNER_ID_PO\",\"DESCRIPCION\",\"COMPLEJIDAD\") VALUES(?, ?, ?, ?);";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt    (1, id_historia_usuario);
            sentencia.setInt    (2, id_product_owner);
            sentencia.setString (3, descripcion);
            sentencia.setInt    (4, complejidad);
        
            sentencia.execute();
            
            success=true;
            connection.close();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return success;
    }
    
    public List getTareas()
    {
        List<Tarea> listaDeTareas = new LinkedList<Tarea>();
        
        try
        {           
            String query;
            
            query = "SELECT * FROM \"TAREA\";";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result=sentencia.executeQuery();
            
            while( result.next() )
            {
                int id_historia_usuario = result.getInt("HISTORIA DE USUARIO_ID_HIUS");
                int id_product_owner    = result.getInt("HISTORIA DE USUARIO_PRODUCT OWNER_ID_PO");
                int complejidad         = result.getInt("COMPLEJIDAD");
                String descripcion      = result.getString("DESCRIPCION");
                
                Tarea tarea = new Tarea( id_historia_usuario, id_product_owner, complejidad, descripcion );
                listaDeTareas.add(tarea);
            }
            
            connection.close();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return listaDeTareas;
    }
    
    public List getTareas( int id_historia_usuario )
    {
        List<Tarea> listaDeTareas = new LinkedList<Tarea>();
        
        try
        {           
            String query;
            
            query = "SELECT * FROM \"TAREA\" WHERE \"HISTORIA DE USUARIO_ID_HIUS\"=?;";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_historia_usuario);
        
            ResultSet result=sentencia.executeQuery();
            
            while( result.next() )
            {
                int id_product_owner = result.getInt("HISTORIA DE USUARIO_PRODUCT OWNER_ID_PO");
                int complejidad      = result.getInt("COMPLEJIDAD");
                String descripcion   = result.getString("DESCRIPCION");
                
                Tarea tarea = new Tarea( id_historia_usuario, id_product_owner, complejidad, descripcion );
                listaDeTareas.add(tarea);
            }
            
            connection.close();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return listaDeTareas;
    }
}

