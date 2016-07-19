package Control;

import java.sql.*;
import java.util.*;

public class PuenteDBHU extends PuenteDB
{
    public PuenteDBHU()throws SQLException, ClassNotFoundException
    {
        super();
    }
    
    public void addHistoria( String nombre, String descripcion, int importancia )
    {
        try
        {            
            String query;
            query = "INSERT INTO \"HISTORIA DE USUARIO\" (\"DESCRIPCION\", \"NOMBRE\", \"IMPORTANCIA\", \"ESTADO HISTORIA DE USUARIO_ID_ESTADO\") VALUES (?,?,?,2);";
                
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1, descripcion );
            sentencia.setString (2, nombre );
            sentencia.setInt    (3, importancia );
                
            sentencia.execute();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
    
    public String getNombre( int id_hu )
    {
        String nombre = null;
        
        try
        {
            String query;
            query = "SELECT \"NOMBRE\" FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HU\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                nombre = result.getString( "NOMBRE" );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return nombre;
    }
    
    public String getDescripcion( int id_hu )
    {
        String descripcion=null;
        
        try
        {
            String query;
            query = "SELECT \"DESCRIPCION\" FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HU\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                descripcion = result.getString( "DESCRIPCION" );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return descripcion;
    }
    
    public int getImportancia( int id_hu )
    {
        int importancia = 0;
        
        try
        {
            String query;
            query = "SELECT \"IMPORTANCIA\" FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HU\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                importancia = result.getInt( "IMPORTANCIA" );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return importancia;
    }
   
    public boolean estaVistoPorUser( int user, int id_hu )
    {
        boolean visto = false;
        
        try
        {
            String query;
            query = "SELECT \"ID VISTO\" FROM \"VISTO\" WHERE \"ID_HU\"=? AND \"ID_USER\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            sentencia.setInt (2, user );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
                visto=true;
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return visto;
    }
    
    public void visitar( int user, int id_hu )
    {
        try
        {            
            if( !estaVistoPorUser(user, id_hu) )
            {
                String query;
                query = "INSERT INTO \"VISTO\" (\"ID_HU\", \"ID_USER\") VALUES (?,?);";
                
                PreparedStatement sentencia = connection.prepareStatement(query);
                sentencia.setInt (1, id_hu );
                sentencia.setInt (2, user );
                
                sentencia.execute();
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
    
    public boolean estaAprobadaPorUser( int user, int id_hu )
    {
        boolean aprobada = false;
        
        try
        {
            String query;
            query = "SELECT \"ID_APROBADO\" FROM \"APROBADO\" WHERE \"ID_HU\"=? AND \"ID_USER\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            sentencia.setInt (2, user );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
                aprobada=true;
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return aprobada;
    }
    
    public void aprobar( int user, int id_hu )
    {
        try
        {            
            if( !estaAprobadaPorUser(user, id_hu) )
            {
                String query;
                query = "INSERT INTO \"APROBADO\" (\"ID_HU\", \"ID_USER\") VALUES (?,?);";
                
                PreparedStatement sentencia = connection.prepareStatement(query);
                sentencia.setInt (1, id_hu );
                sentencia.setInt (2, user );
                
                sentencia.execute();
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
    
    public int cantidadUsuariosAprobaron( int id_hu )
    {
        int cantidad=0;
        
        try
        {
            String query;
            query = "SELECT COUNT(\"ID_APROBADO\") AS total FROM \"APROBADO\" WHERE \"ID_HU\"=?;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
                cantidad = result.getInt("total");
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return cantidad;
    }
    
    public int cantidadUsuariosTotales()
    {
        int cantidad=0;
        
        try
        {
            String query;
            query = "SELECT COUNT(\"ROL_ID_ROL\") AS total FROM \"USER\" WHERE \"ROL_ID_ROL\"=0;";
            
            Statement sentencia = connection.createStatement();
            ResultSet result = sentencia.executeQuery( query );
            
            if( result.next() )
                cantidad = result.getInt("total");
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return cantidad;
    }
    
    public boolean estaRechazada( int id_hu )
    {
        boolean rechazada=false;
        
        try
        {
            String query;
            query = "SELECT * FROM \"HISTORIA DE USUARIO\" WHERE \"ID_HU\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_hu );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                int estado = result.getInt("ESTADO HISTORIA DE USUARIO_ID_ESTADO");
                if( estado==1 )
                    rechazada=true;
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return rechazada;
    }
    
    public void rechazar( int id_hu, String descripcion )
    {
        try
        {
            if( !estaRechazada(id_hu) )
            {
                String query;
                query = "UPDATE \"HISTORIA DE USUARIO\" SET \"ESTADO HISTORIA DE USUARIO_ID_ESTADO\"=1,\"RAZON RECHAZO\"=? WHERE \"ID_HU\"=? ;";
                
                PreparedStatement sentencia = connection.prepareStatement(query);
                sentencia.setString (1, descripcion );
                sentencia.setInt (2, id_hu );
                sentencia.execute();
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
}
