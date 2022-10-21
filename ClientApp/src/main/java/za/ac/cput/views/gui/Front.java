/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.views.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author SinothandoM
 */
public class Front extends JFrame implements ActionListener {
    
private JPanel button = new JPanel();
private JButton lb = new JButton("Librarian");
private JButton st = new JButton("Student");
private JButton sp = new JButton("SignUp");

Container con = getContentPane();
private JPanel panelNorth = new JPanel();


public Front(){

    setTitle("Library_System_Management/Home");
    setSize(650,500);
    setLocation(360,100);
 setResizable(false);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
setBackground();
setButton();
setVisible(true);
}


public void setBackground(){
    
 JLabel background = new JLabel(new ImageIcon("homee.jpg"));
con.add(background);
con.setLayout(new FlowLayout());
con.add(button);
background.add( button );
panelNorth.add(button);

}


public void setButton(){

    Font but = new Font("Serif" , Font.ITALIC , 20);

    lb.setFont(but);
    st.setFont(but);
    sp.setFont(but);
    

    button.add(lb);
    button.add(st);
    button.add(sp);
    

    con.add(button);
    
    lb.addActionListener((ActionListener) this);
    st.addActionListener(this);
    sp.addActionListener(this);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

}

@Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
       //Functionality
      
       if(e.getSource()== lb){
           new LibrarianGUI().setGUI();
                     new Front().setVisible(false);
       
            
                     dispose();
                     
                     
             }else if(e.getSource() == st){
                 new LearnerGUI().setGUI();
                     new Front().setVisible(false);
                     
                     dispose();
                     
                 }else if(e.getSource() == sp){
                 new SignUpGUI().setGui();
                     new Front().setVisible(false);
                     
                     dispose();
                 }
    }

 public static void main(String[] args) {
        new Front();
    }

  

   
    
}
