package XP.Control;
 
import java.util.Arrays;
import java.sql.*;
import java.util.*;

public class PuenteDB 
{
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5433/SIS2";
    private String username = "postgres";
    private String pass = "123db";
    protected Connection connection;
    
    public PuenteDB()throws SQLException, ClassNotFoundException
    {
        Class.forName(driver);
            connection = DriverManager
            .getConnection(url,
            username, pass);
    }
}
