package XP.Control;

import java.sql.*;
import java.util.*;
import XP.Modelo.*;

public class PuenteProyecto extends PuenteDB
{
    public PuenteProyecto()throws SQLException, ClassNotFoundException
    {
        super();
    }
    
    public String getDescripcion( int id_proyecto )
    {
        String descripcion = null;
        
        try
        {
            String query;
            query = "SELECT \"DESCRIPCION\" FROM \"PROYECTO\" WHERE \"ID_PROYECTO\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_proyecto );
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
    
    public String getTitulo( int id_proyecto )
    {
        String titulo = null;
        
        try
        {
            String query;
            query = "SELECT \"TITULO\" FROM \"PROYECTO\" WHERE \"ID_PROYECTO\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_proyecto );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                titulo = result.getString( "TITULO" );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return titulo;
    }
    
    public void addProyecto( String descripcion, String titulo )
    {
        try
        {            
            String query;
            query = "INSERT INTO \"PROYECTO\" (\"DESCRIPCION\", \"TITULO\") VALUES (?,?);";
                
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1, titulo );
            sentencia.setString (2, descripcion );
                
            sentencia.execute();
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
    
    public Sprint getProyecto( int id_proyecto )
    {
        Sprint p = null;
        String descripcion;
        String titulo;
        
        try
        {
            String query;
            query = "SELECT * FROM \"PROYECTO\" WHERE \"ID_PROYECTO\"=? ;";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, id_proyecto );
            ResultSet result = sentencia.executeQuery();
            
            if( result.next() )
            {
                descripcion = result.getString( "DESCRIPCION" );
                titulo = result.getString( "TITULO" );
                
                p = new Sprint( titulo, descripcion, id_proyecto );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return p;
    }
    
    public ArrayList<Sprint> getLista()
    {
        ArrayList<Sprint> lista = new ArrayList<Sprint>();
        
        try
        {
            String query;
            query = "SELECT * FROM \"PROYECTO\";";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result = sentencia.executeQuery();
            
            while( result.next() )
            {
                String titulo = result.getString( "TITULO" );
                String descripcion = result.getString( "DESCRIPCION" );
                int id = result.getInt( "ID_PROYECTO" );
                
                Sprint aux = new Sprint( titulo, descripcion, id );
                
                lista.add( aux );
            }
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
        
        return lista;
    }
}
