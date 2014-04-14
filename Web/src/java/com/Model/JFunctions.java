package com.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chelsea
 */
public class JFunctions {
    
    private Connection connect = null;
    private Statement statement = null;
    public HttpSession session = null;
   
    private ResultSet resultSet = null;
    public int LoggedInID;
    public int userID;
    public String email;
    public String password;
    public String firstname;
    public String lastname;
    
    public void execute(String SQL) throws SQLException
    {
        try
        {
            // This will load the PostgreSQL driver, each DB has its own driver
            Class.forName("org.postgresql.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:postgresql://postgres.cise.ufl.edu/chelsea", "cmetcalf", “test”);
            statement = connect.createStatement();
            statement.executeUpdate(SQL);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Exception: " + e);
        }
    }
    
    public ResultSet select(String SQL) throws SQLException
    {
        ResultSet rs = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://postgres.cise.ufl.edu/chelsea", "cmetcalf", “test”);
            statement = connect.createStatement();
            rs = statement.executeQuery(SQL);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Exception: " + e);
        }
        return rs;
    }
}
