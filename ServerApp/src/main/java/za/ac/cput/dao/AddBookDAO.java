/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.dao;

import za.ac.cput.connection.DatabaseConnection;
import za.ac.cput.domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AddBookDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    ResultSet result;
    int ok;

    public AddBookDAO() {
        this.connection = DatabaseConnection.derbyConnection();
    }

    public boolean addBook(Book book) {

        ok = 0;
        String addBookQuery = "INSERT INTO Book(Isbn, BookName, BookType, BookAuthor, AuthorId, ShelfNumber, bookPage,CostOfBook,AvailableForLoan)"+"VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(addBookQuery);
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getBookType());
            preparedStatement.setString(4, book.getBookAuthor());
            preparedStatement.setString(5, book.getAuthorId());
            preparedStatement.setString(6, book.getShelfNumber());
            preparedStatement.setString(7, book.getNumberPages());
            preparedStatement.setString(8, book.getBookCost());
            preparedStatement.setBoolean(9, book.isAvailableForLoan());
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

    public boolean validateBookIsbn(String isbn) {
        boolean unique = true;
        String validatCustomerIdSQL = "SELECT * FROM Book WHERE Isbn = ?";
        try {
            preparedStatement = connection.prepareStatement(validatCustomerIdSQL);
            preparedStatement.setString(1, isbn);
            result = preparedStatement.executeQuery();
            while (result.next()) {
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
    public boolean bookDetails(){
         try{
             String sql = "select * from book where concat(name, book_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

         }
    }
}
