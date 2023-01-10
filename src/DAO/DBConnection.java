package DAO;

import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";


    private static final String myURL ="jdbc:mysql://wgudb.ucertify.com:3306/WG06YG0";
    private static final String username = "test";
    // create our mysql database connection
    private static String myDriver = "com.mysql.cj.jdbc.Driver";
    // com.mysql.cj.jdbc.Driver
//com.mysql.jdbc.Driver
    public static void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }




    public static Connection startConnection() throws SQLException {
        try{
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myURL,username,username);

        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){

        }
    }
}
