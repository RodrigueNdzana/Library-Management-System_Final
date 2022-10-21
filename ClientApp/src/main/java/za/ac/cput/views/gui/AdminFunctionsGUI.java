/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.views.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AdminFunctionsGUI extends JFrame implements ActionListener {
    private JFrame mainFrame;
    private JPanel panelNorth,panelSouth;
    
    private JButton btnViewBooks;
    private JButton btnViewUsers;
    private JButton btnViewIssued;
    private JButton btnIssueBook;
    private JButton btnAddUser;
    private JButton btnAddBook;
    private JButton btnReturnBook;
    private JButton btnReset;
    
    public AdminFunctionsGUI (){
        mainFrame = new JFrame("ADMIN FUNCTIONS");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        
        btnViewBooks = new JButton("View Books");
        btnViewUsers = new JButton("View Users");
        btnViewIssued = new JButton("View Issued Book");
        btnIssueBook = new JButton("Issue Book");
        btnAddUser = new JButton("Add User");
        btnAddBook = new JButton("Add Book");
        btnReturnBook = new JButton("Return Book");
        btnReset = new JButton("Reset");
        
    }
    
    public void setGui(){
        panelNorth.setLayout(new GridLayout(1, 4));
        panelSouth.setLayout(new GridLayout(1, 4));
        
        //North Panel.
        panelNorth.add(btnViewBooks);
        panelNorth.add(btnViewUsers);
        panelNorth.add(btnViewIssued);
        panelNorth.add(btnIssueBook);
        
        //South Panel.
        panelSouth.add(btnAddUser);
        panelSouth.add(btnAddBook);
        panelSouth.add(btnReturnBook);
        panelSouth.add(btnReset);
        
        btnViewBooks.addActionListener(this);
        btnViewUsers.addActionListener(this);
        btnViewIssued.addActionListener(this);
        btnIssueBook.addActionListener(this);
        btnAddUser.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnReturnBook.addActionListener(this);
        btnReset.addActionListener(this);
        
        //Adding Panels to Frame.
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);
        
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
        
         
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    
    }
    
  
  @Override
    public void actionPerformed(ActionEvent e) {
       //Functionality
       if(e.getSource()== btnViewBooks){
            
                     new AddNewLearner().runAddLearner();
                     new AdminFunctionsGUI().setVisible(false);
                    
       }
    }
    
     public static void main(String[] args) {
        new AdminFunctionsGUI().setGui();
    }

    
}
