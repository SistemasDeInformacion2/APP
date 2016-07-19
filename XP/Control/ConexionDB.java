package XP.Control;

import java.sql.SQLException;
import java.util.*;
public class ConexionDB {
    private static PuenteDBLogin login;
    
    public static PuenteDBLogin pedirPuenteLogin() throws Exception{
        
        if(login==null){
            login=new PuenteDBLogin();
        }
        return login;
            
    }
}
