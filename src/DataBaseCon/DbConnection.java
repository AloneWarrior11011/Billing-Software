
package DataBaseCon;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection
{
       static  Connection con;
     static  public Connection getConnection() 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","root");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
        
    }
    
}
