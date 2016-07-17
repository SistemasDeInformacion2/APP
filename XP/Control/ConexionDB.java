package Control;


 

import java.sql.SQLException;


public class ConexionDB {
    
    private static PuenteDB connection;
    
    public static PuenteDB conexion() throws SQLException, ClassNotFoundException{
        
        if(connection==null){
            connection=new PuenteDB();
        }
        return connection;
            
    }
}
