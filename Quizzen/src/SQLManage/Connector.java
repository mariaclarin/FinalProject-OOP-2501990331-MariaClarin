//importing necessary library and package
package SQLManage;
import java.sql.*;

//creating a new class Connector that will act as a connector between the mysql database and quizzen java interface
public class Connector {
    
    //private default constructor
    private Connector() {
    }
    
    //getCon() functions work to connect the database and the file
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             //this is my local host sql syntax/query
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzen", "root", "098761");
            return con;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
