/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.dao;

import za.ac.cput.connection.DatabaseConnection;
import za.ac.cput.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rodrigue Ndzana
 */
public class UserDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    ResultSet result;

    public UserDAO() {
        this.connection = DatabaseConnection.derbyConnection();
    }
 
    // This add the user after sign up
    public boolean addUser(User user) {
        int ok = 0;
        String addingQuery = "INSERT INTO SignUp(FullName, UserName, password, ConfirmPassword)"
                + "VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(addingQuery);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getConfirmPassword());
            ok = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);

        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println("Error "+ e);
                    }
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }
        }
        return ok == 1;
    }
    // validate userName on both sigup and loginPage***************************************
    public boolean validateUserId(String userName) {
        boolean isUserNameExist = false;
        String userValidQuery = "SELECT * SignUp FROM  WHERE userName = ?";
        try {
            preparedStatement = connection.prepareStatement(userValidQuery);
            preparedStatement.setString(1, userName);
            result = preparedStatement.executeQuery();
            isUserNameExist = result.next();
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
            ex.printStackTrace();
    } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception" + ex);
            }
        }
        return isUserNameExist;
      }
    
    //**************  getting the user from the database****************
    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String getAllUsersSQL = "SELECT * FROM SignUp";
        try {
            preparedStatement = connection.prepareStatement(getAllUsersSQL);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                userList.add(new User(result.getString("user_id"), result.getString("full_name"), result.getString("password"), result.getString("inactive")));
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    connection.close();
                    result.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }
        }
        return userList;
    }
    //********************************************************

    /*
    public boolean updateUser(User user) {
        String updateUserSQL = "UPDATE user_login SET full_name = ?, password = ?, inactive = ? WHERE user_id = ?";
        int response = 0;
        try {
            preparedStatement = this.connection.prepareStatement(updateUserSQL);
           
           
           
            

            response = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }
        }
        return response == 1;
    } /
*/
}
