/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class PuenteDBNuevaCuenta extends PuenteDB{
    
    public PuenteDBNuevaCuenta() throws Exception{
        super();
    }
    
    public boolean estaDisponibleUser(String usuario){
        boolean disponible = false;
        String consulta = "SELECT \"LOGIN\" FROM \"USER\" WHERE \"LOGIN\"='" + usuario + "'";
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            if(rs.next()){
                disponible = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return disponible;
    }

    public void registrarUser(String login, String password){
        String query = "INSERT INTO \"USER\"(\"LOGIN\", \"PASSWORD\") VALUES ('"+login+"','"+password+"')";
        
        try{
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void registrarPersona(String nombres, String apellidos, String fechaNacimiento, String correo, String celular){
        String consulta = "SELECT MAX(\"ID_USS\") FROM \"USER\"";
                
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            if(rs.next()){
                String query = "INSERT INTO \"PERSONA\"(\"USER_ID_USS\", \"NOMBRES\", \"APELLIDOS\", \"FECHA_NAC\",\"CORREO\","
                + "\"CELULAR\") VALUES ('"+rs.getRowId(0).toString()+"','"+nombres+"','"+apellidos+"','"+fechaNacimiento
                +"','"+correo+"','"+celular+"')";
                
                st.executeUpdate(query);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
