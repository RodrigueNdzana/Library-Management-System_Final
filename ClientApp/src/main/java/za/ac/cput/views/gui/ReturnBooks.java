/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


/**
 *
 * @author SinothandoM
 */
public class ReturnBooks extends JFrame implements ActionListener {
     private JFrame mainFrame;
    private JPanel panelNorth,panelSouth, panelCenter;
    
    private JLabel lblPicture;
    private JLabel lblHeading;
    
    private JLabel lblISBN;
    private JTextField txtISBN;
    
    private JLabel lblStudentID;
    private JTextField txtStudentID;
    
    private JLabel lblBook;
    private JTextField txtBook;
    
    private JLabel lblIssuedDate;
    private JTextField txtIssuedDate;
    
    private JLabel lblReturnDate;
    private JTextField txtReturnDate;
    
    
    
    private JButton btnSubmit;
     private JButton btnBack;
    
    private Font  font2, font3;
    
    public ReturnBooks(){
         mainFrame = new JFrame("Return BooK");
    panelNorth = new JPanel();
    panelNorth.setBackground(Color.BLACK);
    panelSouth = new JPanel();
    panelCenter = new JPanel();
    panelCenter.setBackground(Color.LIGHT_GRAY);

    font3 = new Font("Impact", Font.PLAIN,40);
    font2 = new Font("Courier", Font.BOLD | Font.ITALIC, 16);
    
    lblPicture = new JLabel(new ImageIcon("Book.png"));
    lblPicture.setPreferredSize(new Dimension(200,100));
    
    lblHeading = new JLabel("Return Book", SwingConstants.CENTER);
    lblHeading.setFont(font3);
    lblHeading.setForeground(Color.WHITE);
    
    lblISBN = new JLabel("ISBN: ");
    lblISBN.setFont(font2);
    txtISBN = new JTextField(15);
    
    lblStudentID = new JLabel("Student ID: ");
    lblStudentID.setFont(font2);
    txtStudentID = new JTextField(15);
        
    lblBook = new JLabel("Book: ");
    lblBook.setFont(font2);
    txtBook = new JTextField(15);
        
    lblIssuedDate = new JLabel("ISSUED DATE: ");
    lblIssuedDate.setFont(font2);
    txtIssuedDate = new JTextField(15);
    
    lblReturnDate = new JLabel("Return DATE: ");
    lblReturnDate.setFont(font2);
    txtReturnDate = new JTextField(15);
    
    btnSubmit = new JButton("Return");
    btnBack = new JButton("Back");
    
    }

public void setGUI(){
    panelNorth.setLayout(new GridLayout(1, 2));
    panelCenter.setLayout(new GridLayout(5, 3));
    panelSouth.setLayout(new GridLayout(1, 3));

    //North Panel.
    panelNorth.add(lblPicture);
    panelNorth.add(lblHeading);
    
    //Center Panel
    
     panelCenter.add(lblStudentID);
    panelCenter.add(txtStudentID);
    
 
    panelCenter.add(lblISBN);
    panelCenter.add(txtISBN);
        
   
    panelCenter.add(lblBook);
    panelCenter.add(txtBook);
        
    panelCenter.add(lblIssuedDate);
    panelCenter.add(txtIssuedDate);
    
    panelCenter.add(lblReturnDate);
    panelCenter.add(txtReturnDate);
    
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
         if(e.getSource()== btnSubmit){
           new AdminFunctionsGUI().setGui();
                     new ReturnBooks().setVisible(false);
                        dispose();
                     
         }else if(e.getSource() == btnBack){
                 new AdminFunctionsGUI().setGui();
                     new ReturnBooks().setVisible(false);
                     
                     dispose();
         }
   
    }
public static void main(String[] args){
        new ReturnBooks().setGUI();
        
   }
}