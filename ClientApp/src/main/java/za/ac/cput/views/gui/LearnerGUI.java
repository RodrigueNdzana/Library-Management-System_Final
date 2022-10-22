/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.views.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.cput.clientToServer.ClientToServer;
import za.ac.cput.domain.User;



public class LearnerGUI extends JFrame implements ActionListener {

    private JPanel panelNorth;
    private JPanel panelCenter, panelGender;
    private JPanel panelSouth;
    
    private JLabel lblLogo;
    private JLabel lblHeading;
    private JLabel lblPadding0, lblPadding01, lblPadding1, lblPadding2, lblPadding3, lblPadding4, lblPadding5;
   
    private JLabel lblRecordCount;
      private JLabel lblRecordCount2;
    
    
    private JLabel lblStudent;
    private JTextField txtStudent;
    
    
    private JLabel lblPassword;
    private JTextField txtPassword;
    
    
    private JButton btnLogin,btnCancel, btnExit;
    private Font ft1, ft2, ft3, ft4;
    
   
    private int index;
    private int size;
    
     ArrayList<User> adminsLog = new ArrayList<>();
    ClientToServer request = new ClientToServer();
    public LearnerGUI() {
        super("Learner");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelGender = new JPanel();
        panelSouth = new JPanel();
        
        lblLogo = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("download.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblLogo.setIcon(imageIcon);
        lblHeading = new JLabel("Learner Login");
        
        lblRecordCount = new JLabel("");
        
        
        lblStudent = new JLabel("Username: ");
        txtStudent = new JTextField();
        
        lblRecordCount2 = new JLabel("");
        
        
        lblPassword = new JLabel("Password: ");
        txtPassword = new JTextField();
        
        
        lblPadding0 = new JLabel("");
        lblPadding01 = new JLabel("");
        lblPadding1 = new JLabel("");
        lblPadding2 = new JLabel("");
        lblPadding3 = new JLabel("");
        lblPadding4 = new JLabel("");
        lblPadding5 = new JLabel("");
        
        
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);
        ft4 = new Font("Arial", Font.ITALIC, 16);

    }
    
    public void setGUI() {
        //Places all GUI elements on the frame
        panelNorth.setLayout(new FlowLayout());
        setBounds(350, 150, 879, 500);
        panelCenter.setLayout(new GridLayout(4, 3));
        panelSouth.setLayout(new GridLayout(1, 2));
        
        panelNorth.add(lblLogo);
        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.white);
        panelNorth.setBackground(new Color(0,  0, 0));
        
        lblRecordCount.setFont(ft4);
        lblRecordCount.setHorizontalAlignment(JLabel.RIGHT);
        panelCenter.add(lblPadding0);
        panelCenter.add(lblPadding01);
        panelCenter.add(lblRecordCount);
       
        
        lblStudent.setFont(ft2);
        lblStudent.setHorizontalAlignment(JLabel.RIGHT);
        txtStudent.setFont(ft2);
        panelCenter.add(lblStudent);
        panelCenter.add(txtStudent);
        panelCenter.add(lblPadding1);
        
        lblRecordCount2.setFont(ft4);
        lblRecordCount2.setHorizontalAlignment(JLabel.RIGHT);
        panelCenter.add(lblPadding2);
        panelCenter.add(lblPadding3);
        panelCenter.add(lblRecordCount2);
        
        lblPassword.setFont(ft2);
        lblPassword.setHorizontalAlignment(JLabel.RIGHT);
        txtPassword.setFont(ft2);
        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(lblPadding4);
        
         lblRecordCount2.setFont(ft4);
        lblRecordCount2.setHorizontalAlignment(JLabel.RIGHT);
        panelCenter.add(lblPadding2);
        panelCenter.add(lblPadding3);
        panelCenter.add(lblRecordCount2);
        
        
        btnLogin.setFont(ft3);
         btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(Color.white);
        
        btnCancel.setFont(ft3);
        btnCancel.setBackground(new Color(0, 0, 0));
        btnCancel.setForeground(Color.white);
        
        btnExit.setFont(ft3);
         btnExit.setBackground(new Color(0, 0, 0));
        btnExit.setForeground(Color.white);
        
        panelSouth.add(btnLogin);
        panelSouth.add(btnCancel);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
       btnExit.addActionListener(this);
        
        this.setSize(600, 600);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        LearnerGUI();
    }
    
    public boolean isInputValid(){
        boolean valid = true;
         
        if (txtStudent.getText().equals("")){
            valid = false;
            JOptionPane.showMessageDialog(null, "First name cannot be left Empty",
      "ERROR!", JOptionPane.ERROR_MESSAGE);
         } 
        
        if (txtPassword.getText().equals("")){
            valid = false;
             JOptionPane.showMessageDialog(null, "Password cannot be left Empty",
      "ERROR!", JOptionPane.ERROR_MESSAGE);
         }
          return valid;
          
          
    }
    
    public void resetForm(){
        txtStudent.setText("");
        txtPassword.setText("");
        
     
    }
        
    
    
    public void LearnerGUI() {
  
       
        
    }
    
   @Override
   public void actionPerformed(ActionEvent e){
  
    if (e.getSource() == btnLogin ) {
        adminsLog = request.gettingUserInfo();
            boolean userLoginMatch = false;
            for (int i = 0; i < adminsLog.size(); i++) {
                if (adminsLog.get(i).getUserName().equals(txtStudent.getText())&& adminsLog.get(i).getPassword().equals(txtPassword.getText())) {
                    userLoginMatch = true;
                }
            }
            if (userLoginMatch == true) {
                 JOptionPane.showMessageDialog(null, "Welcome You have succefully Sign in.");
                //mainFrame.dispose();
                
               // adminFrame.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Admin ID or Password!");
            }

// //Got data from gui put it into variable email and password
// String username= txtStudent.getText();    
// String password = String.valueOf(txtPassword.getText());// Was getPassword but gave me error
 
 //created user object with email and password
          

 /*if(UserDAO.show(u)){
   JOptionPane.showMessageDialog(null,"Welcome" +  " "+ u.getUserID()+ " " + u.getUserName());  
 System.exit(0);
 }  
 else{
 JOptionPane.showMessageDialog(null,"Your email and/ or password is incorrect");
 txtStudent.hasFocus();
 }*/
       }else if (e.getSource() == btnCancel){ 
           new Front().setButton();
                     new LearnerGUI().setVisible(false);
       
            
                     dispose();
                     
            resetForm();
            
             
        }else if (e.getSource() == btnExit){   
            resetForm();
             System.exit(0);
            
        }else if (e.getSource() == txtStudent){
            if (txtStudent.getText().equals(0)){
       
                btnLogin.setEnabled(true);
            }else{
                btnLogin.setEnabled(false);
                
              
            }
        
        }
 
        }
   
    public static void main(String[] args){
        new LearnerGUI().setGUI();
        
    }
}
