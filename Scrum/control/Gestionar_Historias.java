package control;

import java.sql.*;
import java.util.*;

public class Gestionar_Historias
{
    private Connection connection;
    
    public Gestionar_Historias()
    {
        connection=new ConexionDB().conexion();
    }

    public boolean addHistoria( String titulo, String descripcion, String condiciones_satisfaccion, int complejidad, int importancia, int id_product_owner )
    {
        boolean success=false;
        
        try
        {           
            String query;
            query = "INSERT INTO \"HISTORIA DE USUARIO\" (\"PRODUCT OWNER_ID_PO\",\"COMPLEJIDAD\",\"IMPORTANCIA\",\"TITULO\",\"DESCRIPCION\",\"CONDICIONES DE SATISFACCION\") VALUES(?, ?, ?, ?, ?, ?);";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt    (1, id_product_owner);
            sentencia.setInt    (2, complejidad);
            sentencia.setInt    (3, importancia);
            sentencia.setString (4, titulo);
            sentencia.setString (5, descripcion);
            sentencia.setString (6, condiciones_satisfaccion);
        
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
    
    public boolean editHistoria( int id_historia_usuario, String titulo, String descripcion, String condiciones_satisfaccion, int complejidad, int importancia, int id_product_owner )
    {
        boolean success=false;
        
        try
        {            
            String query;
            query = "UPDATE \"HISTORIA DE USUARIO\" SET \"PRODUCT OWNER_ID_PO\"=?,\"COMPLEJIDAD\"=?,\"IMPORTANCIA\"=?,\"TITULO\"=?,\"DESCRIPCION\"=?,\"CONDICIONES DE SATISFACCION\"=? WHERE \"ID_HIUS\"=? ;";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt    (1, id_product_owner);
            sentencia.setInt    (2, complejidad);
            sentencia.setInt    (3, importancia);
            sentencia.setString (4, titulo);
            sentencia.setString (5, descripcion);
            sentencia.setString (6, condiciones_satisfaccion);
            sentencia.setInt    (7, id_historia_usuario);
            
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
    
    public boolean delHistoria( int id_historia_usuario )
    {
        boolean success=false;
        
        try
        {
            String query;
            query = "DELETE FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HIUS\"=? ;";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_historia_usuario);
            
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
    
    public Historia_Usuario getHistoria( int id_historia_usuario )
    {
        Historia_Usuario historia = null;
        
        try
        {           
            String query;
            query = "SELECT * FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HIUS\"=? ;";
        
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_historia_usuario);
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {                
                int id_product_owner            = result.getInt("PRODUCT OWNER_ID_PO");
                int complejidad                 = result.getInt("COMPLEJIDAD");
                int importancia                 = result.getInt("IMPORTANCIA");
                String titulo                   = result.getString("TITULO");
                String descripcion              = result.getString("DESCRIPCION");
                String condiciones_satisfaccion = result.getString("CONDICIONES DE SATISFACCION");
                
                historia = new Historia_Usuario( 
                    id_historia_usuario, 
                    id_product_owner,
                    complejidad, 
                    importancia,
                    titulo,
                    descripcion,
                    condiciones_satisfaccion );
            }
            
            //close();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return historia;
    }
    
    public List<Historia_Usuario> getHistorias()
    {
        List<Historia_Usuario> listaDeTareas = new LinkedList<Historia_Usuario>();
        
        try
        {           
            String query;
            query = "SELECT * FROM \"HISTORIA DE USUARIO\" ORDER BY \"IMPORTANCIA\" DESC;";
        
            PreparedStatement sentencia = connection.prepareStatement(query);       
            ResultSet result=sentencia.executeQuery();
            
            while( result.next() )
            {                
                int id_historia_usuario         = result.getInt("ID_HIUS");
                int id_product_owner            = result.getInt("PRODUCT OWNER_ID_PO");
                int complejidad                 = result.getInt("COMPLEJIDAD");
                int importancia                 = result.getInt("IMPORTANCIA");
                String titulo                   = result.getString("TITULO");
                String descripcion              = result.getString("DESCRIPCION");
                String condiciones_satisfaccion = result.getString("CONDICIONES DE SATISFACCION");
                
                Historia_Usuario historia = new Historia_Usuario( 
                    id_historia_usuario, 
                    id_product_owner,
                    complejidad, 
                    importancia,
                    titulo,
                    descripcion,
                    condiciones_satisfaccion );
                    
                listaDeTareas.add(historia);
                //close();
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return listaDeTareas;
    }
    
    public void close()
    {
        try
        {
            connection.close();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
}
