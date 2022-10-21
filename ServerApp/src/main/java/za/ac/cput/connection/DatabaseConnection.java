/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// this method set up a connection and it will be call in the Database package 
public class DatabaseConnection {
    public static Connection derbyConnection(){
        String url = "jdbc:derby://localhost:1527/libraryDb";
        String userName = "administrator";
        String password = "password";
        Connection libraryDbConnectivity = null;
        try {
            libraryDbConnectivity = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            System.out.print("Connection Error");
        }
        return libraryDbConnectivity;
    }
}
