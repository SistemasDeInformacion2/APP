/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XP.Control;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class PuenteDBNuevaCuenta extends PuenteDB{
    
    public PuenteDBNuevaCuenta() throws Exception{
        super();
    }
    
    public boolean estaRegistrado(String nombre, String apellido){
        boolean registrado = false;
        String consulta = "SELECT \"NOMBRE\", \"APELLIDO PATERNO\" FROM \"PERSONA\" WHERE \"NOMBRE\"='"+nombre+"' AND  \"APELLIDO PATERNO\"='"+apellido+"'";
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            if(rs.next()){
                registrado = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return registrado;
    }
    
    public boolean estaDisponibleUser(String usuario){
        boolean disponible = true;
        String consulta = "SELECT \"LOGIN\" FROM \"USER\" WHERE \"LOGIN\"='" + usuario + "'";
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            if(rs.next()){
                disponible = false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return disponible;
    }

    public void registrarUser(String login, String password){
        String queryU = "INSERT INTO \"USER\"(\"LOGIN\", \"PASSWORD\") VALUES ('"+login+"','"+password+"')";
        
        try{
            Statement stU = connection.createStatement();
            stU.executeUpdate(queryU);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void registrarPersona(String nombres, String apellidos, String fechaNacimiento, String correo, String celular){
        String queryP = "INSERT INTO \"PERSONA\"(\"USER_ID_USS\",\"NOMBRE\", \"APELLIDO PATERNO\","+
                                                    "\"APELLIDO MATERNO\",\"CORREO\",\"NUMERO\") " +
                            "VALUES ((SELECT MAX(\"ID_USS\") FROM \"USER\"),'"+nombres+"','"+
                                        apellidos+"','"+fechaNacimiento+"','"+correo+"','"+celular+"')";
                
        try{
            Statement stP = connection.createStatement();
            stP.executeUpdate(queryP);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cerrar(){
        try {
                connection.close();
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public boolean addRolUser( int rol )
    {
        boolean success = false;
        
        try
        {
            String query;
            query = "INSERT INTO \"USS ROL\" (\"USER_ID_USS\", \"ROL_ID_ROL\") VALUES ( (SELECT MAX(\"ID_USS\") FROM \"USER\") , ?);";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt (1, rol);
            sentencia.execute();
            
            success=true;
            sentencia.close();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
        
        return success;
    }
}
