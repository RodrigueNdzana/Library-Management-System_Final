package za.ac.cput.views.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import za.ac.cput.clientToServer.ClientToServer;
import za.ac.cput.domain.Learner;



/*
 *This is alibrary management system
 *Group : Revolutionary/*
 *This is alibrary management system
 *Group : Revolutionary/*
 *This is alibrary management system
 *Group : Revolutionary/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */




public class AddNewLearner extends JFrame implements ActionListener {
//      private JTextField txtStudentNumber, txtStudentName, txtAddress, txtPhoneNumber, txtAlternativeNumber, txtAge;

    // private JPanel mainContainer;

    private JPanel content, panelNorth, panelWest, panelEast, panelSouth;
    private JTextField txtStudentNumber, txtStudentName, txtAddress, txtPhoneNumber, txtAlternativeNumber, txtAge;
    private JLabel lblTitle, lblStudentNumber, lblStudentName, lblAddress, lblLearnerGrade, lblFieldStudy, lblPhoneNumber, lblAlternativeNumber, lblAge;
    private JLabel lblErrorStudentNumber, lblErrorStudentName, lblErrorField, lblErrorGrade, lblErrorAddress, lblErrorPhoneNumber, lblErrorAlternativeNumber, lblErrorAge;
    private JComboBox cbFieldStudy, cbLearnerGrade;
    private JButton btnAddLearner, btnClear, btnBack;
    
    ClientToServer request = new ClientToServer();
    
    Learner learner;
    public static void main(String[] args) {
        new AddNewLearner().runAddLearner();
    }

    public AddNewLearner() {
        this.setTitle("http://www/library_Management_System/home/userLogin/administrator/addLeaner");
        setBounds(350, 150, 879, 500);
        content = new JPanel();
        content.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 224), 5), "Add New Learner(s)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        content.setBounds(10, 29, 398, 344);
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("learner.png");
        Image bookImg = icon.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT);
        ImageIcon addBook = new ImageIcon(bookImg);
        JLabel lbladding = new JLabel(addBook);
        lbladding.setBackground(Color.WHITE);

        lblTitle = new JLabel("Add New Learner");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 28));
        lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        panelNorth.add(lbladding);
        panelNorth.add(lblTitle);

        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();

        lblStudentNumber = new JLabel("Student Number: ");
        lblStudentNumber.setForeground(new Color(255, 0, 0));
        lblStudentNumber.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorStudentNumber = new JLabel("Required");
        lblErrorStudentNumber.setForeground(Color.red);
        lblErrorStudentNumber.setVisible(false);

        lblStudentName = new JLabel("Student Name: ");
        lblStudentName.setForeground(new Color(63, 112, 77));
        lblStudentName.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorStudentName = new JLabel("Required");
        lblErrorStudentName.setForeground(Color.red);
        lblErrorStudentName.setVisible(false);

        lblAddress = new JLabel("Address: ");
        lblAddress.setForeground(new Color(63, 112, 77));
        lblAddress.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorAddress = new JLabel("Required");
        lblErrorAddress.setForeground(Color.red);
        lblErrorAddress.setVisible(false);

        lblLearnerGrade = new JLabel("Grade: ");
        lblLearnerGrade.setForeground(new Color(63, 112, 77));
        lblLearnerGrade.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorGrade = new JLabel("Required");
        lblErrorGrade.setForeground(Color.red);
        lblErrorGrade.setVisible(false);

        lblFieldStudy = new JLabel("Field: ");
        lblFieldStudy.setFont(new Font("Calibri", Font.BOLD, 18));
        lblFieldStudy.setForeground(new Color(63, 112, 77));
        lblErrorField = new JLabel(" Not Required");
        lblErrorField.setForeground(Color.red);
        lblErrorField.setVisible(false);

        lblPhoneNumber = new JLabel("Phone Number: ");
        lblPhoneNumber.setForeground(new Color(63, 112, 77));
        lblPhoneNumber.setFont(new Font("Calibri", Font.BOLD, 16));
        lblErrorPhoneNumber = new JLabel("Required");
        lblErrorPhoneNumber.setForeground(Color.red);
        lblErrorPhoneNumber.setVisible(false);

        lblAlternativeNumber = new JLabel("Alternative Number: ");
        lblAlternativeNumber.setForeground(new Color(63, 112, 77));
        lblAlternativeNumber.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorAlternativeNumber = new JLabel("Not Required");
        lblErrorAlternativeNumber.setForeground(Color.red);
        lblErrorAlternativeNumber.setVisible(false);

        lblAge = new JLabel("Age: ");
        lblAge.setForeground(new Color(63, 112, 77));
        lblAge.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorAge = new JLabel("Required");
        lblErrorAge.setForeground(Color.red);
        lblErrorAge.setVisible(false);

        txtStudentNumber = new JTextField();
        txtStudentNumber.setFont(new Font("Arial", Font.BOLD, 14));

        txtStudentName = new JTextField();
        txtStudentName.setFont(new Font("Arial", Font.BOLD, 14));

        String[] fieldStudy = {"Science", "Accounting", "Computer Study", "Biology"};
        cbFieldStudy = new JComboBox(fieldStudy);
        cbFieldStudy.setFont(new Font("Arial", Font.BOLD, 14));

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setFont(new Font("Arial", Font.BOLD, 14));

        txtAddress = new JTextField();
        txtAddress.setFont(new Font("Arial", Font.BOLD, 14));

        txtAlternativeNumber = new JTextField();
        txtAlternativeNumber.setFont(new Font("Arial", Font.BOLD, 14));

        String[] grade = {"4", "5", "5AE", "6", "6AE", "7", "7AE", "7AC"};
        cbLearnerGrade = new JComboBox(grade);
        cbLearnerGrade.setFont(new Font("Arial", Font.BOLD, 14));

        txtAge = new JTextField();
        txtAge.setFont(new Font("Arial", Font.BOLD, 14));

        btnAddLearner = new JButton("Add Learner");
        btnAddLearner.setBorder(new CompoundBorder(new LineBorder(new Color(246, 190, 0)), null));
        btnAddLearner.setFont(new Font("Calibri", Font.BOLD, 18));
        btnAddLearner.setBackground(Color.BLACK);
        btnAddLearner.setForeground(Color.WHITE);
        btnAddLearner.setBounds(100, 150, 50, 33);

        btnBack = new JButton("Back");
        btnBack.setBorder(new CompoundBorder(new LineBorder(new Color(246, 190, 0)), null));
        btnBack.setFont(new Font("Arial", Font.BOLD, 18));
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);

        btnClear = new JButton("Clear");
        btnClear.setBackground(Color.BLACK);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Arial", Font.BOLD, 18));
        btnClear.setBorder(new CompoundBorder(new LineBorder(new Color(246, 190, 0)), null));

    }

    public void runAddLearner() {
        this.add(content);

        content.add(panelWest, BorderLayout.WEST);
        panelWest.setLayout(new GridLayout(8, 1, 78, 10));
        panelWest.setPreferredSize(new Dimension(294, 290));
        content.add(panelEast, BorderLayout.EAST);
        panelEast.setLayout(new GridLayout(8, 2, 4, 4));
        panelEast.setPreferredSize(new Dimension(494, 290));
        panelWest.setBounds(900, 67, 23, 230);
        this.add(panelNorth, BorderLayout.NORTH);
        panelWest.add(lblStudentNumber);
        panelWest.add(lblStudentName);
        panelWest.add(lblLearnerGrade);
        panelWest.add(lblFieldStudy);
        panelWest.add(lblAddress);
        panelWest.add(lblPhoneNumber);
        panelWest.add(lblAlternativeNumber);
        panelWest.add(lblAge);

        panelEast.add(txtStudentNumber);
        panelEast.add(lblErrorStudentNumber);

        panelEast.add(txtStudentName);
        panelEast.add(lblErrorStudentName);

        panelEast.add(cbLearnerGrade);
        panelEast.add(lblErrorGrade);

        panelEast.add(cbFieldStudy);
        panelEast.add(lblErrorField);

        panelEast.add(txtAddress);
        panelEast.add(lblErrorAddress);

        panelEast.add(txtPhoneNumber);
        panelEast.add(lblErrorPhoneNumber);

        panelEast.add(txtAlternativeNumber);
        panelEast.add(lblErrorAlternativeNumber);

        panelEast.add(txtAge);
        panelEast.add(lblErrorAge);
        this.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.setPreferredSize(new Dimension(184, 37));
        panelSouth.add(btnAddLearner);
        panelSouth.add(btnBack);
        panelSouth.add(btnClear);

        //Adding event listener to button
        btnAddLearner.addActionListener(this);
        btnClear.addActionListener(this);
        btnBack.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }
/// this method check for validation amongst field to prevent empty field

    public boolean validationChecker() {
        boolean valid = true;
        //caregiberCode
        if (txtStudentNumber.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorStudentNumber.setVisible(true); // display the label
        } else {
            lblErrorStudentNumber.setVisible(false);
        }
        if (txtStudentName.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorStudentName.setVisible(true); // display the label
        } else {
            lblErrorStudentName.setVisible(false);
        }

        if (txtAddress.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorAddress.setVisible(true); // display the label
        } else {
            lblErrorAddress.setVisible(false);

        }
        if (txtPhoneNumber.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorPhoneNumber.setVisible(true); // display the label
        } else {
            lblErrorPhoneNumber.setVisible(false);

        }

        if (txtAge.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorAge.setVisible(true); // display the label
        } else {
            lblErrorAge.setVisible(false);
        }

        return valid;
    }
    // method to clear form

    public void resettingForm() {
        txtStudentNumber.setText("");
        txtStudentName.setText("");
        cbFieldStudy.setSelectedIndex(0);
        cbLearnerGrade.setSelectedIndex(0);
        txtAddress.setText("");
        txtPhoneNumber.setText("");
        txtAlternativeNumber.setText("");
        txtAge.setText("");

    }


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnAddLearner) {
            //private JTextField txtStudentNumber, txtStudentName, txtAddress, txtPhoneNumber, txtAlternativeNumber, txtAge;
            if (txtStudentNumber.getText().isEmpty() || txtStudentName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtPhoneNumber.getText().isEmpty() || txtAlternativeNumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All Field must be fields with value \n make sure all the field are not empty");
            } else {
                  boolean studentValidation = request.validateStudentNumber(txtStudentNumber.getText());
                if (studentValidation == true) {
                    String studentNumber =txtStudentNumber.getText();
                    String studentName = txtStudentName.getText();
                    String learnerGrade = cbLearnerGrade.getSelectedItem().toString();
                    String fieldStudy = cbFieldStudy.getSelectedItem().toString();
                    int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
                    int alternativeNumber = Integer.parseInt(txtAlternativeNumber.getText());
                    int age = Integer.parseInt(txtAge.getText()); 
                    String address = txtAddress.getText();
                   
                    //(int studentNumber, String studentName, String learnerGrade, String fieldStudy, int phoneNumber, int alternativeNumber, int age,String address)
                    boolean response;
                    learner = new Learner(studentNumber, studentName, learnerGrade, fieldStudy, phoneNumber, alternativeNumber, age,address);
                    response = request.addLearner(learner);
                    if (response == true) {
                        JOptionPane.showMessageDialog(null, "Student added  Successfully.");
                        resettingForm();
                    }
                } 
                    else if (studentValidation == false) {
                    JOptionPane.showMessageDialog(null, "Student Number already exist. \n please enter a new student Number");
                    
                }
            }

        
        } else if (event.getSource() == btnClear) {
            resettingForm();
        }
    }

}
