package XP.Control;

import java.sql.SQLException;
import java.util.*;
public class ConexionDB {
    private static PuenteDBLogin login;
    private static PuenteDBHU    historias;
    
    public static PuenteDBLogin pedirPuenteLogin() throws Exception{
        
        if(login==null)
        {
            login=new PuenteDBLogin();
        }
        
        return login;
    }
    
    public static PuenteDBHU pedirPuenteHistorias() throws Exception{
        
        if( historias==null )
        {
            historias=new PuenteDBHU();
        }
        
        return historias;
    }
}
