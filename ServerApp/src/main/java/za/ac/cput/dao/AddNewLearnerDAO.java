   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.ac.cput.connection.DatabaseConnection;
import za.ac.cput.domain.Learner;

/**
 *
 * @author Rodrigue Ndzana
 */
public class AddNewLearnerDAO {
private Connection connection = null;
    private PreparedStatement preparedStatement;
    ResultSet result;
    int ok;

    public AddNewLearnerDAO() {
        this.connection = DatabaseConnection.derbyConnection();
    }
    public boolean addLearner(Learner learner){
       
        ok=0;
        String addBookQuery = "INSERT INTO Learner (StudentNumber, StudentName, LearnerGrade, FieldStudy, phoneNumber,AlternativeNumber, Age,Address)" + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(addBookQuery);
            preparedStatement.setString(1,learner.getStudentNumber());
            preparedStatement.setString(2, learner.getStudentName());
            preparedStatement.setString(3, learner.getLearnerGrade());
            preparedStatement.setString(4, learner.getFieldStudy()); 
            preparedStatement.setInt(5, learner.getPhoneNumber()); 
            preparedStatement.setInt(6, learner.getAlternativeNumber()); 
            preparedStatement.setInt(7, learner.getAge()); 
            preparedStatement.setString(8, learner.getAddress()); 
            
            ok = preparedStatement.executeUpdate();
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
        return ok == 1;
    }
        
    public boolean validateStudentNumber(String studentNumber) {
        boolean unique = true;
        String validatCustomerIdSQL = "SELECT * FROM Learner WHERE StudentNumber = ?";
        try {
            preparedStatement = connection .prepareStatement(validatCustomerIdSQL);
            preparedStatement.setString(1, studentNumber);
            result = preparedStatement.executeQuery();
            while(result.next()){
                unique = false;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
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
        return unique;
    }
}
