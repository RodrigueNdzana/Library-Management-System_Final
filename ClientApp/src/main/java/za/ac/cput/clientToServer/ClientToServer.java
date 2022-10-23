/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.clientToServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Learner;
import za.ac.cput.domain.User;
import za.ac.cput.views.gui.Front;

public class ClientToServer {

    private Socket socket; // name the socket
    ObjectOutputStream output;  // can be used in have with the writeObject() method
    ObjectInputStream input;    // can be used in have with the readObject() method

    public ClientToServer() {
        try {
            socket = new Socket("127.0.0.1", 5400);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
          
        } catch (IOException ex) {
            System.out.println(ex);
           // ex.printStackTrace();
        }

    }

   
    //***************** Add book Client to server request**************
    public boolean addBook(Book book) {
        try {
            output.writeObject("addBook");
            System.out.println("1");
            output.flush();
            output.writeObject(book);
            System.out.println("2");
            output.flush();
            System.out.println("ClientToServer addBook method has been completed successfully");
            return input.readBoolean();
        } catch (IOException ioe) {
            System.out.println("ClientToServer addBook Method: " + ioe);
            return false;
        }
    }
    //Validate the ISBN number in the Client class.

    public boolean validateBookIsbn(String isbn) {
        try {
            output.writeObject("validateIsbn");
            output.flush();
            output.writeObject(isbn);
            output.flush();
            System.out.println("ClientToServer validate Isbn method has been completed successfully");
            return input.readBoolean();
        } catch (IOException ex) {
            System.out.println("CLientToServer validatedIsbn Method  " + ex);
            return true;
        }
       
    }

    // ********* Client side Add New Learner ***********************
    public boolean addLearner(Learner learner) {
        try {
            output.writeObject("addNewLearner");
            output.flush();
            output.writeObject(learner);
            output.flush();
            System.out.println("ClientToServer addNewLearner method has been completed successfully");
            return input.readBoolean();
        } catch (IOException ioe) {
            System.out.println("ClientToServer addNewLearner Method Error: " + ioe);
            return true;
        }
    }
    //Validate the Student number in the Client class.

    public boolean validateStudentNumber(String studentNumber) {
        try {
            output.writeObject("validateAddNewLearner");
            output.flush();
            output.writeObject(studentNumber);
            output.flush();
            System.out.println("ClientToServer validate student number method has been completed successfully");
            return input.readBoolean();
        } catch (IOException ex) {
            System.out.println("CLientToServer validatedStudent Method error " + ex);
            return true;
        }
        //return false;
    }
     /************* Client to server request to add user
     * @return  **************/
    public boolean addUser(User mainUser) {
        try {
            output.writeObject("addUserLog");
            output.flush();
            output.writeObject(mainUser);
            output.flush();
            System.out.println("ClientServer resquet method has been completed ");
            return input.readBoolean();
        } catch (IOException ioe) {
            System.out.println("ClientServer addUser Method has errr in adding user: " + ioe);
            return true;
        }
    }
    //validate username of a table sign since it is a primary. 
    public boolean validateUserName(String userName) {
        try {
            output.writeObject("validatingUserNameLogin");
            output.flush();
            output.writeObject(userName);
            output.flush();
            System.out.println("ClientServer validating UserName Login method: completed");
            return input.readBoolean();
        } catch (IOException ex) {
            System.out.println("CLientServer validatedUserID Method: " + ex);
            //ex.printStackTrace();
            return true;
        }
    }

    //****************** Login and sign up request *********************
    public ArrayList<User> gettingUserInfo() {
        
        try {
            System.out.println("ClientToServer sign up method page");
            output.writeObject("gettingUserInfo");
            output.flush();
            System.out.println("ClientToServer sign up method has succefully be completed");
            return (ArrayList<User>) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("ClientToServer sign up meht method:" + ex);
            return new ArrayList<>();
        }
    }
//
    public static void main(String[] args) {
       // new ClientToServer();
        new Front().setButton();
    }
}
