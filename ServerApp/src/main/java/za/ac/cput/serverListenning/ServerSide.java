/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.serverListenning;

import za.ac.cput.dao.AddBookDAO;
import za.ac.cput.dao.AddNewLearnerDAO;
import za.ac.cput.domain.Book;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import za.ac.cput.dao.UserDAO;
//import za.ac.cput.dao.UserDAO;
import za.ac.cput.domain.Learner;

import za.ac.cput.domain.User;

public class ServerSide {

    ServerSocket listener;
    Socket client;

    ObjectInputStream input;
    ObjectOutputStream output;

    String clientRequest;

    //accessing database
    AddBookDAO bookDAO;
    AddNewLearnerDAO learnerDAO;
    UserDAO userDAO;

    //arrayList
    ArrayList<User> usersDetail = new ArrayList<>();
    ArrayList<User> adminDetail = new ArrayList<>();

    public ServerSide() {
        System.out.println("Server is running ready to connect...");
        startingServer();
        makingRequest();
        streamCreated();
        processRequest();
    }

    public void startingServer() {
        try {
            listener = new ServerSocket(5400, 1);
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
    }

    public void makingRequest() {     
        try {
//            if(listener!=null){
//                if(!listener.isClosed()){
                    client = listener.accept();
                    System.out.println("Client is connected");
                //}
           // }
        }catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
    }

    public void streamCreated() {
        try {
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
    }

    public void processRequest() {

        try {
            do {
                // here we are calling the ObjectInputStream(on readObject) to read the string addBook  that reside in the clientToServer addBook method (in hand with the ObjectOuputStream.writeObject(adddBook)
                // ObjectOutputStream is used to write the content

                clientRequest = (String) input.readObject();
                
                if (clientRequest.equalsIgnoreCase("addBook")) {
                    System.out.println("The Client(librian) has  requested to add a Book....");
                    // since we are reading data fropm the the Book Object, this is casting the data to the Book object. NB: this is serialized
                    Book book = (Book) input.readObject();
                    bookDAO = new AddBookDAO(); // here I am calling my database functionality for adding a book with hold a reference value of bookDAO
                    boolean response = bookDAO. addBook(book); // now I am accessing the REPOSNSE FOUND IN THE BOOLEAN METHOD
                    System.out.println("The Book has been added: " + response);
                    output.writeBoolean(response);
                    output.flush();

                } // Validation on the server side for isbn
                else if (clientRequest.equalsIgnoreCase("validateIsbn")) {
                    System.out.println("Request to validate ISBN");
                    String isbnNumber = (String) input.readObject();
                    bookDAO = new AddBookDAO();
                    boolean response = bookDAO.validateBookIsbn(isbnNumber);
                    System.out.println("isbn HAS BEEN VALIDATED  " + response);
                    output.writeBoolean(response);
                    output.flush();
                }
                //************ Request  for Adding new Learner *******************
                else if (clientRequest.equalsIgnoreCase("addNewLearner")) {
                    System.out.println("The Client(librian) has  requested to add a new Learner....");
                    Learner learner = (Learner) input.readObject();
                    learnerDAO = new AddNewLearnerDAO();
                    boolean response = learnerDAO.addLearner(learner);
                    System.out.println("The Learner has been added: " + response);
                    output.writeBoolean(response);
                    output.flush();

                } // Validation on the server side for StudentnUMBER
                else if (clientRequest.equalsIgnoreCase("validateAddNewLearner")) {
                    System.out.println("Request to validate Student Number accepted...");
                    String studentNumber = (String) input.readObject();
                    learnerDAO = new AddNewLearnerDAO();
                    boolean response = learnerDAO.validateStudentNumber(studentNumber);
                    System.out.println("Student Number has been validated" + response);
                    output.writeBoolean(response);
                    output.flush();
                } 
                /************************ Login server side ************/
                else if (clientRequest.equalsIgnoreCase("addUserLog")) {
                    System.out.println("Request has been made to add user SignUpDetatils");
                    User user = (User) input.readObject();
                    userDAO = new UserDAO();
                    boolean response = userDAO.addUser(user); // we are gettinig the response found in the boolean method of the clientToServer  
                    System.out.println("The User has succefully been added: " + response); // user added with a true reponse if it successful and false otherwise
                    output.writeBoolean(response);
                    output.flush();
                } else if (clientRequest.equalsIgnoreCase("validatingUserNameLogin")) {
                    System.out.println("Request to Validate User Username");
                    String userNameValidate = (String) input.readObject();
                    userDAO = new UserDAO();
                    boolean response = userDAO.validateUserId(userNameValidate);
                    System.out.println("UserName Validated: " + response);
                    output.writeBoolean(response);
                    output.flush();
                }
                
                /******************* Sign up server side********************/
                  /************************ Login server side ************/
                else if (clientRequest.equalsIgnoreCase("addUserLog")) {
                    System.out.println("Request has been made to add user Sign Up Detatils ");
                    User user = (User) input.readObject();
                    userDAO = new UserDAO();
                    boolean response = userDAO.addUser(user); // we are gettinig the response found in the boolean method of the clientToServer  
                    System.out.println("The User has succefully been added: " + response); // user added with a true reponse if it successful and false otherwise
                    output.writeBoolean(response);
                    output.flush();
                } else if (clientRequest.equalsIgnoreCase("validatingUserNameLogin")) {
                    System.out.println("Request to Validate User Username");
                    String userNameValidate = (String) input.readObject();
                    userDAO = new UserDAO();
                    boolean response = userDAO.validateUserId(userNameValidate);
                    System.out.println("UserID Validated: " + response);
                    output.writeBoolean(response);
                    output.flush();
                }
                //////// 
                    else if (clientRequest.equalsIgnoreCase("gettingUserInfo")) {
                    System.out.println("Requesting to get user info (Log in system) ");
                    userDAO = new UserDAO();
                    usersDetail = userDAO.getAllUsers();
                    output.writeObject(usersDetail);
                } else if (clientRequest.equalsIgnoreCase("gettingAdminsInfo")) {
                    System.out.println("Request Get All Admins");
                    userDAO = new UserDAO();
                    //adminDetail = UserDAO.getAllUsers();
                    output.writeObject(adminDetail);

                }
            } while (!clientRequest.equalsIgnoreCase("terminate"));

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception: " + e);
            //e.printStackTrace();

        }
    }
    //this method check if the connection is null and close the connection

//     public void close() {
//        if (server != null) {
//            try {
//                server.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}


/////////////////////////////////
/*
// initialized the server
    public void initializedAndStarts(int port) throws Exception {
        server = new ServerSocket(port);
        
        System.out.println("Server is running on port " + port);
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client is connected");
            readMessageFromSocket(clientSocket);
        }
    }

    public void readMessageFromSocket(Socket clientSocket) throws Exception {
         i am using the BufferReader to retrieve the message and display to the screen
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            for(int chr = reader.read(); reader.ready(); chr = reader.read()){
                System.out.println((char) chr);
            }
         
        try {
            do {
                // here we are calling the ObjectInputStream(on readObject) to read the string addBook  that reside in the clientToServer addBook method (in hand with the ObjectOuputStream.writeObject(adddBook)
                // ObjectOutputStream is used to write the content

                clientRequest = (String) input.readObject();

                if (clientRequest.equalsIgnoreCase("addBook")) {
                    System.out.println("The Client(librian) has  requested to add a Book....");
                    // since we are reading data fropm the the Book Object, this is casting the data to the Book object. NB: this is serialized
                    Books book = (Books) input.readObject();
                    bookDAO = new AddBookDAO(); // here I am calling my database functionality for adding a book with hold a reference value of bookDAO
                    boolean response = bookDAO.addBook(book); // now I am accessing the REPOSNSE FOUND IN THE BOOLEAN METHOD
                    System.out.println("The Book has been added: " + response);
                    output.writeBoolean(response);
                    out.flush();

                }  // Validation on the server side for isbn
                else if (clientRequest.equalsIgnoreCase("validateIsbn")){
              System.out.println("Request to validate ISBN");
                String isbnNumber = (String) input.readObject();
                bookDAO = new AddBookDAO();
                boolean response = bookDAO.validateBookIsbn(isbnNumber);
                System.out.println("isbn HAS BEEN VALIDATED  " + response);
                output.writeBoolean(response);
                output.flush();
            } 
            //************ Request  for Adding new Learner *******************
            if (clientRequest.equalsIgnoreCase("addNewLearner")) {
                    System.out.println("The Client(librian) has  requested to add a new Learner....");
                    Learners learner = (Learners) input.readObject();
                    learnerDAO = new AddNewLearnerDAO(); 
                    boolean response = learnerDAO.addLearner(learner); 
                    System.out.println("The Learner has been added: " + response);
                    output.writeBoolean(response);
                    out.flush();

                }  // Validation on the server side for StudentnUMBER
                else if (clientRequest.equalsIgnoreCase("validateAddNewLearner")){
              System.out.println("Request to validate Student Number accepted...");
                String isbnNumber = (String) input.readObject();
                learnerDAO = new AddNewLearnerDAO();
                boolean response = learnerDAO.validateStudentNumber(isbnNumber);
                System.out.println("Student Number has been validated" + response);
                output.writeBoolean(response);
                output.flush();
            } 
        }while (!clientRequest.equalsIgnoreCase("finish"));
    } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eception: " + e);
            //e.printStackTrace();

        } this method check if the connection is null and close the connection
    }
*/

/*
        //initializing input stream and socket
   
    ServerSocket listener;
    Socket client;

    ObjectInputStream inStream;
    ObjectOutputStream outStream;

    String clientRequest;
    Books book;
    AddBookDAO bookDAO;
    // constructor of the class Server
// remenber is 5440
    // creating an arraylist of Books class
    ArrayList<Books> addBookList = new ArrayList<>();

    public ServerSide(int port) {
         System.out.println("----- Server starting -----");
         startServer(6743);
         
         processClient();
    }
    public void startServer(int port) {
        try {
           listener = new ServerSocket(port);
             System.out.println("Server starts");
             System.out.println("Waiting for a client to connect ... ");  
             client = listener.accept(); // waiting for  a client to send connection request
             System.out.println("Connected with a Client!! ");
             // Receiving input messages from the client using socket
             inStream = new ObjectInputStream(client.getInputStream());
             
        } catch (IOException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

 public void processClient() {
     try {
            do{
                if (clientRequest.equalsIgnoreCase("addBook")) {
                    System.out.println("Request Add Book");
                    Books book = (Books) inStream.readObject();
                    bookDAO = new AddBookDAO();
                    boolean response = bookDAO.addBook(book);
                    System.out.println("book added: " + response);
                    outStream.writeBoolean(response);
                    outStream.flush();

                } else if (clientRequest.equalsIgnoreCase("validateBookIsbn")) {
                    System.out.println("Request Validate User ID");
                    String book = (String) inStream.readObject();
                    bookDAO = new AddBookDAO();
                    boolean response = bookDAO.validateBookIsbn(book);
                    System.out.println("isbn Validated: " + response);
                    outStream.writeBoolean(response);
                    outStream.flush();

                }
            }while (!clientRequest.equalsIgnoreCase("terminate"));
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eception: " + e);
        }
 }

 */
