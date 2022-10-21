/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */

package za.ac.cput.views.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class issueBookGUI extends JFrame implements ActionListener {
    private JFrame mainFrame;
    private JPanel panelNorth,panelSouth, panelCenter;
    
    private JLabel lblPicture;
    private JLabel lblHeading;
    
    private JLabel lblBookID;
    private JTextField txtBookID;
    
    private JLabel lblUserID;
    private JTextField txtUserID;
    
    private JLabel lblDaysRented;
    private JTextField txtDaysRented;
    
    private JLabel lblIssuedDate;
    private JTextField txtIssuedDate;
    
    private JButton btnSubmit;
    private JButton btnBack;
    
    private Font  font2, font3;
    
public issueBookGUI(){
    mainFrame = new JFrame("ISSUE BOOK");
    panelNorth = new JPanel();
    panelNorth.setBackground(Color.BLACK);
    panelSouth = new JPanel();
    panelCenter = new JPanel();
    panelCenter.setBackground(Color.LIGHT_GRAY);

    font3 = new Font("Impact", Font.PLAIN,40);
    font2 = new Font("Courier", Font.BOLD | Font.ITALIC, 16);
    
    lblPicture = new JLabel(new ImageIcon("Book.png"));
    lblPicture.setPreferredSize(new Dimension(200,100));
    
    lblHeading = new JLabel("Issue Book", SwingConstants.CENTER);
    lblHeading.setFont(font3);
    lblHeading.setForeground(Color.WHITE);
    
    lblBookID = new JLabel("BOOK ID: ");
    lblBookID.setFont(font2);
    txtBookID = new JTextField(15);
    
    lblUserID = new JLabel("USER ID: ");
    lblUserID.setFont(font2);
    txtUserID = new JTextField(15);
        
    lblDaysRented = new JLabel("DAYS RENTED: ");
    lblDaysRented.setFont(font2);
    txtDaysRented = new JTextField(15);
        
    lblIssuedDate = new JLabel("ISSUED DATE: ");
    lblIssuedDate.setFont(font2);
    txtIssuedDate = new JTextField(15);
    
    btnSubmit = new JButton("SUBMIT");
    btnBack = new JButton("BACK");
    
    }

public void setGUI(){
    panelNorth.setLayout(new GridLayout(1, 2));
    panelCenter.setLayout(new GridLayout(4, 3));
    panelSouth.setLayout(new GridLayout(1, 2));

    //North Panel.
    panelNorth.add(lblPicture);
    panelNorth.add(lblHeading);
    
    //Center Panel
    panelCenter.add(lblBookID);
    panelCenter.add(txtBookID);
        
    panelCenter.add(lblUserID);
    panelCenter.add(txtUserID);
    
    panelCenter.add(lblDaysRented);
    panelCenter.add(txtDaysRented);
        
    panelCenter.add(lblIssuedDate);
    panelCenter.add(txtIssuedDate);
    
    //SouthPanel 
    panelSouth.add(btnSubmit);
     panelSouth.add(btnBack);
    
    btnSubmit.addActionListener(this);
    btnBack.addActionListener(this);
    
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
     

   @Override
    public void actionPerformed(ActionEvent e) {
        //Functionality 
         if(e.getSource()== btnSubmit){
           new AdminFunctionsGUI().setGui();
                     new issueBookGUI().setVisible(false);
                     
                      dispose();
                     
         }else if(e.getSource() == btnBack){
                 new AdminFunctionsGUI().setGui();
                     new issueBookGUI().setVisible(false);
                     
                     dispose();
    }
    }
 
    
public static void main(String[] args){
        new issueBookGUI().setGUI();
        
   }

}

  

    
 




