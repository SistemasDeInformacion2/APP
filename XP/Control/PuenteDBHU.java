package XP.Control;

import java.sql.*;
import java.util.*;

import XP.Modelo.HistoriaUsuario;

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
    
    public void addHistoria( HistoriaUsuario historia_usuario )
    {
        String nombre = historia_usuario.getNombre();
        String descripcion = historia_usuario.getDescripcion();
        int importancia = historia_usuario.getImportancia();
        
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
            query = "SELECT * FROM \"HISTORIA VISTA\" WHERE \"HISTORIA DE USUARIO_ID_HU\"=? AND \"USER_ID_USS\"=? ;";
            
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
                query = "INSERT INTO \"HISTORIA VISTA\" (\"HISTORIA DE USUARIO_ID_HU\", \"USER_ID_USS\") VALUES (?,?);";
                
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
            query = "SELECT * FROM \"HISTORIA APROBADA\" WHERE \"HISTORIA DE USUARIO_ID_HU\"=? AND \"USER_ID_USS\"=? ;";
            
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
                query = "INSERT INTO \"HISTORIA APROBADA\" (\"HISTORIA DE USUARIO_ID_HU\", \"USER_ID_USS\") VALUES (?,?);";
                
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
            query = "SELECT COUNT(\"HISTORIA DE USUARIO_ID_HU\") AS total FROM \"HISTORIA APROBADA\" WHERE \"HISTORIA DE USUARIO_ID_HU\"=?;";
            
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
            query = "SELECT COUNT(\"ROL_ID_ROL\") AS total FROM \"USS ROL\" WHERE \"ROL_ID_ROL\"=0 OR \"ROL_ID_ROL\"=2 ;";
            
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
    
    public ArrayList<ControlHU> getLista()
    {
        ArrayList<ControlHU> lista = new ArrayList<ControlHU>();
        
        try
        {
            String query;
            query = "SELECT * FROM \"HISTORIA DE USUARIO\";";
            
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result = sentencia.executeQuery();
            
            while( result.next() )
            {
                int id = result.getInt( "ID_HU" );
                
                ControlHU aux = new ControlHU( id );
                
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
