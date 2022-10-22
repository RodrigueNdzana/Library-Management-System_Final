/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.views.gui;;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import za.ac.cput.clientToServer.ClientToServer;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import za.ac.cput.clientToServer.ClientToServer;
import za.ac.cput.domain.User;



public class SignUpGUI extends JFrame implements ActionListener {
    
    private JFrame mainFrame;
    private JPanel panelNorth,panelSouth,panelCenter;
    
    private JLabel lblPicture;
    
    private JLabel lblHeading;
    
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblErrorName;
    
    
    
    
    private  JLabel lblUserName;
    private JTextField txtUserName;
    private JLabel lblErrorUserName;
    
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JLabel lblErrorPassword;
    
    private JLabel lblConfirmPassword;
    private JTextField txtConfirmPassword;
    private JLabel lblErrorConfirmPassword;
    
    private JButton btnSave;
    private JButton btnExit;
    private JButton btnCancel;
    
    private Font  font2, font3;
    ArrayList<User> usersLog = new ArrayList<>();
    ArrayList<User> adminsLog = new ArrayList<>();
    ClientToServer request = new ClientToServer();
    User userInfo;
    public SignUpGUI (){
        mainFrame = new JFrame("LIBRARY REGISTRATION");
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.BLACK);
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.LIGHT_GRAY);
        
        font3 = new Font("Impact", Font.PLAIN,40);
        font2 = new Font("Courier", Font.BOLD | Font.ITALIC, 16);
        
        lblPicture = new JLabel(new ImageIcon("Book.png"));
        lblPicture.setPreferredSize(new Dimension(200,100));
                
        lblHeading = new JLabel("Library Registration", SwingConstants.CENTER);
        lblHeading.setFont(font3);
        lblHeading.setForeground(Color.WHITE);
        
        lblName = new JLabel("Full Name: ");
        lblName.setFont(font2);
        txtName = new JTextField(15);
        lblErrorName = new JLabel("*required");
        lblErrorName.setForeground(Color.red);
        lblErrorName.setVisible(false);
        
        
        lblUserName = new JLabel("Username: ");
        lblUserName.setFont(font2);
        txtUserName = new JTextField(10);
        lblErrorUserName = new JLabel("*required");
        lblErrorUserName.setForeground(Color.red);
        lblErrorUserName.setVisible(false);
        
        lblPassword = new JLabel("Password: ");
        lblPassword.setFont(font2);
        txtPassword = new JTextField(15);
        lblErrorPassword = new JLabel("*required");
        lblErrorPassword.setForeground(Color.red);
        lblErrorPassword.setVisible(false);
        
        lblConfirmPassword = new JLabel("Confirm Password: ");
        lblConfirmPassword.setFont(font2);
        txtConfirmPassword = new JTextField(15);
        lblErrorConfirmPassword = new JLabel("*required");
        lblErrorConfirmPassword.setForeground(Color.red);
        lblErrorConfirmPassword.setVisible(false);
        
        btnSave = new JButton("SignUp");
        btnSave.setBackground(Color.BLACK);
        btnSave.setForeground(Color.WHITE);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        
        btnExit = new JButton("EXIT");
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        btnSave.setPreferredSize(new Dimension(40,40));
        
        
    }
    
    public void setGui(){
        panelNorth.setLayout(new GridLayout(1, 2));
        panelCenter.setLayout(new GridLayout(5, 3));
        panelSouth.setLayout(new GridLayout(1, 2));
        
        //North Panel.
        panelNorth.add(lblPicture);
        panelNorth.add(lblHeading);

        
        //Centre Panel.
        panelCenter.add(lblName);
        panelCenter.add(txtName);
        panelCenter.add(lblErrorName);
        
        
        panelCenter.add(lblUserName);
        panelCenter.add(txtUserName);
        panelCenter.add(lblErrorUserName);
        
        
        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(lblErrorPassword);
        
        panelCenter.add(lblConfirmPassword);
        panelCenter.add(txtConfirmPassword);
        panelCenter.add(lblErrorConfirmPassword);
        
       
        
         //South Panel.
        panelSouth.add(btnSave);
        panelSouth.add(btnCancel);
        panelSouth.add(btnExit);
        
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
        btnExit.addActionListener(this);
        
         //Adding Panels to Frame.
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
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
    
    public boolean validationChecker() {
        boolean valid = true;
        
        if (txtName.getText().equals("")) {
            valid = false; 
            lblErrorName.setVisible(true); 
        } else {
            lblErrorName.setVisible(false);
        }
        if (txtUserName.getText().equals("")) {
            valid = false; 
            lblErrorUserName.setVisible(true); 
        } else {
            lblErrorUserName.setVisible(false);
        }
         
        if (txtPassword.getText().equals("")) {
            valid = false;
            lblErrorPassword.setVisible(true); 
        } else {
            lblErrorPassword.setVisible(false);

        }

        if (txtConfirmPassword.getText().equals("")) {
            valid = false; 
            lblErrorConfirmPassword.setVisible(true); 
        } else {
            lblErrorConfirmPassword.setVisible(false);

        }
        
        return valid;
    }
    
    public void resettingForm(){
        txtName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
    }
    

        
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSave) {
             if (txtName.getText().isEmpty() || txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty() || txtConfirmPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All Field must be fields with value \n make some of the  field are not empty");
            } else{
                
                boolean validateUser = request.validateUserName(txtUserName.getText());
                if (validateUser == false){
                String name = txtName.getText();
                String userName = txtUserName.getText();
                String password = txtPassword.getText();
                String confirmPassword = txtConfirmPassword.getText();
                
                boolean response;
                userInfo = new User(name, userName, password,confirmPassword);
                 response = request.addUser(userInfo);
                 
                 if(response == true){
                      JOptionPane.showMessageDialog(null, "User added  Successfully.");
                        resettingForm();
                        new SignUpGUI().setVisible(false);
                        dispose();
                        new LearnerGUI().setVisible(true);
                 }else if (validateUser == true) {
                    JOptionPane.showMessageDialog(null, "The Enter User Name already exits. \n enter another ISBN");
                }
                } 
            }
//        
       } else if (e.getSource() == btnCancel){ 
             new Front().setButton();
                     new SignUpGUI().setVisible(false);
                     
                     dispose();
                     
                  
                     
    }else if (e.getSource() == btnExit) {
            System.exit(0);
        }

    }
    
    
    public static void main(String[] args) {
        new SignUpGUI().setGui();
    }
}
    
