package Control;
 
import java.util.Arrays;
import java.sql.*;
import java.util.*;

public class PuenteDB 
{
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://10.0.0.27:5432/DBSis";
    private String username = "postgres";
    private String pass = "admin";
    protected Connection connection;
    
    public PuenteDB()throws SQLException, ClassNotFoundException
    {
        Class.forName(driver);
            connection = DriverManager
            .getConnection(url,
            username, pass);
    }
}