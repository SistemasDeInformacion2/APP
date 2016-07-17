package Control;
 
import java.util.Arrays;
import java.sql.*;
import java.util.*;
public class PuenteDB {
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5433/TBD";
    private String username = "user";
    private String pass = "clave";
    protected Connection connection;
    
    public PuenteDB()throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
            connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5433/TDB",
            "postgres", "123db");
    }
}
