package course.jse.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	
	public static Connection createConnection(String database) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		 String userName = DbAccessKeys.userName;
         String password = DbAccessKeys.password;
         String url;
         if (database == "demo") {
        	 url = DbAccessKeys.Demo_url;
         } else {
        	 url = DbAccessKeys.Sf_url;
         }
         
         Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
         System.out.println ("\n*-*-* connection opened *-*-*");
         return  DriverManager.getConnection (url, userName, password);
	}
	
	
	public static void closeConnection(Connection connection){
		
		 if (connection != null){
             try   {
            	 connection.close ();
                 System.out.println ("-*-*- connection closed -*-*- \n");
             }
             catch (Exception e) { 
            	e.printStackTrace();
            }
         }
	}
}
