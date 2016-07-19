package XP.Control;

import java.sql.*;
import java.util.*;
import XP.Modelo.*;

public class ObtenerHistorias extends PuenteDB
{
    public ObtenerHistorias()throws SQLException, ClassNotFoundException
    {
        super();
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
