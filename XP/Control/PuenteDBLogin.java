package XP.Control;

import java.util.*;
import java.sql.*;

public class PuenteDBLogin extends PuenteDB
{
    public PuenteDBLogin() throws Exception{
        super();
    }
    
    public boolean comprobarCuenta( String username, String password )
    {
        boolean success = false;
        
        try
        {
            String query;
            query = "SELECT * FROM \"USER\" WHERE \"LOGIN\"=? and \"PASSWORD\"=? ;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1, username);
            sentencia.setString (2, password);  
            
            ResultSet respuesta = sentencia.executeQuery();
            
            if( respuesta.next() )
                success=true;
            sentencia.close();
            respuesta.close();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
        
        return success;
    }
    
    public ArrayList<String> adquirirPermisos(String no)
    {
        ArrayList<String> res=new ArrayList<String>();
        try{
            String query;
            query = "SELECT buscarIDUser(?);";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1,no);
            ResultSet respuesta=sentencia.executeQuery();
            respuesta.next();
            String[] st=respuesta.getString(1).split("[,{}()]+");
            int num=Integer.parseInt(st[1]);
            query = "select \"ID_VIEW\",\"STORAGE\" from (select \"VIEW_ID_VIEW\" from (select \"FUNCION_ID_FUN\" from (select \"ROL_ID_ROL\" from (select \"ID_USS\" from \"USER\" where \"ID_USS\"="+num+") uno, \"USS_ROL\" where uno.\"ID_USS\"=\"USS_ROL\".\"USER_ID_USS\") dos, \"ROL_FUNCION\" where dos.\"ROL_ID_ROL\"=\"ROL_FUNCION\".\"ROL_ID_ROL\") tres, \"FUN_VIEW\" where tres.\"FUNCION_ID_FUN\" = \"FUN_VIEW\" . \"FUNCION_ID_FUN\") cuatro,\"VIEW\" where cuatro. \"VIEW_ID_VIEW\" = \"VIEW\" . \"ID_VIEW\";";
            sentencia = connection.prepareStatement(query);
            respuesta=sentencia.executeQuery();
            while(respuesta.next()){
                res.add(respuesta.getString(2));
            }
            sentencia.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
        return res;
    }
    
    public void nuevaSession(String no)
    {
        try{
            String query;
            query = "SELECT buscarIDUser(?);";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString (1,no);
            ResultSet respuesta=sentencia.executeQuery();
            respuesta.next();
            String[] st=respuesta.getString(1).split("[,{}()]+");
            int num=Integer.parseInt(st[1]);
            query = "SELECT nuevasession("+num+");";
            sentencia = connection.prepareStatement(query);
            sentencia.executeQuery();
            sentencia.close();
            respuesta.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void logout()
    {
        try{
            String query;
            query = "SELECT logout();";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.executeQuery();
            sentencia.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
