package Scrum.control;

import java.sql.*;

public class ConexionDB
{
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5433/DBSis";
    private String username = "postgres";
    private String pass = "123db";
    protected Connection connection;
    
    public ConexionDB()
    {
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, pass);
        }
        catch( Exception sqle )
        {
            System.out.println(sqle);
        }
    }
    
    public Connection conexion()
    {
        return connection;
    }
}
