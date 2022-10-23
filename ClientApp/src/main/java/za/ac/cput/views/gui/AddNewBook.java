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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import za.ac.cput.clientToServer.ClientToServer;
import za.ac.cput.domain.Book;



public class AddNewBook extends JFrame implements ActionListener {
    // private JPanel mainContainer;

    private JPanel content, panelNorth, panelWest, panelEast, panelSouth, panelAvailable;
    private JTextField txtIsbn, txtBookName, txtBookAuthor, txtAuthorId, txtNumberPages, txtCostOfBook;
    private JLabel lblTitle, lblIsbn, lblBookName, lblBookType, lblBookAuthor, lblAuthorId, lblShelfNumber, lblNumberPages, lblCostOfBook, lblAvaliableLoan;
    private JLabel lblErrorIsbn, lblErrorBookName, lblErrorBookAuthor, lblErrorAuthorId, lblErrorShelfNumber, lblErrorBookType, lblErrorNumberPage, lblErrorCostOfBook;
    private JComboBox cbBookType, cbShelfNumber;
    private JButton btnAddBook, btnClear, btnBack;
    private JRadioButton radYes, radNo;
    ClientToServer request = new ClientToServer();
    ;
    Book book;

    public static void main(String[] args) {
        new AddNewBook().runAddBook();
    }

    public AddNewBook() {

        this.setTitle("http://www/library_Management_System/home/userLogin/administrator/addBook");
        setBounds(350, 150, 879, 500);
        content = new JPanel();
        content.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 224), 5), "Add New Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        content.setBounds(10, 29, 398, 344);
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("bookImage.png");
        Image bookImg = icon.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT);
        ImageIcon addBook = new ImageIcon(bookImg);
        JLabel lbladding = new JLabel(addBook);
        lbladding.setBackground(Color.WHITE);

        lblTitle = new JLabel("Add New Book");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 28));
        lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        panelNorth.add(lbladding);
        panelNorth.add(lblTitle);

        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();

        lblIsbn = new JLabel("Isbn: ");
        lblIsbn.setForeground(new Color(255, 0, 0));
        lblIsbn.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorIsbn = new JLabel("Required");
        lblErrorIsbn.setForeground(Color.red);
        lblErrorIsbn.setVisible(false);

        lblBookName = new JLabel("Book name: ");
        lblBookName.setForeground(new Color(63, 112, 77));
        lblBookName.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorBookName = new JLabel("Required");
        lblErrorBookName.setForeground(Color.red);
        lblErrorBookName.setVisible(false);

        lblBookType = new JLabel("Book Type");
        lblBookType.setFont(new Font("Calibri", Font.BOLD, 18));
        lblBookType.setForeground(new Color(63, 112, 77));
        lblErrorBookType = new JLabel(" not Required");
        lblErrorBookType.setForeground(Color.red);
        lblErrorBookType.setVisible(true);

        lblBookAuthor = new JLabel("Book Author");
        lblBookAuthor.setForeground(new Color(63, 112, 77));
        lblBookAuthor.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorBookAuthor = new JLabel("Required");
        lblErrorBookAuthor.setForeground(Color.red);
        lblErrorBookAuthor.setVisible(false);

        lblAuthorId = new JLabel("Author Id: ");
        lblAuthorId.setForeground(new Color(63, 112, 77));
        lblAuthorId.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorAuthorId = new JLabel("Required");
        lblErrorAuthorId.setForeground(Color.red);
        lblErrorAuthorId.setVisible(false);

        lblShelfNumber = new JLabel("Shelf Number");
        lblShelfNumber.setForeground(new Color(63, 112, 77));
        lblShelfNumber.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorShelfNumber = new JLabel("Required");
        lblErrorShelfNumber.setForeground(Color.red);
        lblErrorShelfNumber.setVisible(false);

        lblNumberPages = new JLabel("Number Pages: ");
        lblNumberPages.setForeground(new Color(63, 112, 77));
        lblNumberPages.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorNumberPage = new JLabel("Required");
        lblErrorNumberPage.setForeground(Color.red);
        lblErrorNumberPage.setVisible(false);

        lblCostOfBook = new JLabel("Book Cost: ");
        lblCostOfBook.setForeground(new Color(63, 112, 77));
        lblCostOfBook.setFont(new Font("Calibri", Font.BOLD, 18));
        lblErrorCostOfBook = new JLabel("Required");
        lblErrorCostOfBook.setForeground(Color.red);
        lblErrorCostOfBook.setVisible(false);

        lblAvaliableLoan = new JLabel("Is This Book Available?: ");
         lblNumberPages.setForeground(new Color(63, 112, 77));
        lblNumberPages.setFont(new Font("Calibri", Font.BOLD, 18));
        panelAvailable = new JPanel();
        radYes = new JRadioButton("Yes");
        radNo = new JRadioButton("No");
        ButtonGroup agreeButtonGroup = new ButtonGroup();
        agreeButtonGroup.add(radYes);
        agreeButtonGroup.add(radNo);

        txtIsbn = new JTextField(50);
        txtIsbn.setFont(new Font("Arial", Font.BOLD, 14));

        txtBookName = new JTextField();
        txtBookName.setFont(new Font("Arial", Font.BOLD, 14));

        String[] bookType = {"Romance", "Action"};
        cbBookType = new JComboBox(bookType);
        cbBookType.setFont(new Font("Arial", Font.BOLD, 14));

        txtBookAuthor = new JTextField();
        txtBookAuthor.setFont(new Font("Arial", Font.BOLD, 14));

        txtAuthorId = new JTextField();
        txtAuthorId.setFont(new Font("Arial", Font.BOLD, 14));

        String[] shelfNumber = {"Rb23", "TR892", "UI891"};
        cbShelfNumber = new JComboBox(shelfNumber);
        cbShelfNumber.setFont(new Font("Arial", Font.BOLD, 14));

        txtNumberPages = new JTextField();
        txtNumberPages.setFont(new Font("Arial", Font.BOLD, 14));

        txtCostOfBook = new JTextField();
        txtCostOfBook.setForeground(new Color(47, 79, 79));
        txtCostOfBook.setFont(new Font("Arial", Font.BOLD, 14));

        btnAddBook = new JButton("Add Book");
        btnAddBook.setBorder(new CompoundBorder(new LineBorder(new Color(246, 190, 0)), null));
        btnAddBook.setFont(new Font("Calibri", Font.BOLD, 18));
        btnAddBook.setBackground(Color.BLACK);
        btnAddBook.setForeground(Color.WHITE);
        btnAddBook.setBounds(100, 150, 50, 33);

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

    public void runAddBook() {
        this.add(content);

        content.add(panelWest, BorderLayout.WEST);
        panelWest.setLayout(new GridLayout(9, 1, 78, 10));
        panelWest.setPreferredSize(new Dimension(294, 290));
        content.add(panelEast, BorderLayout.EAST);
        panelEast.setLayout(new GridLayout(9, 2, 4, 4));
        panelEast.setPreferredSize(new Dimension(494, 290));
        panelWest.setBounds(900, 67, 23, 230);
        this.add(panelNorth, BorderLayout.NORTH);
        panelAvailable.setLayout(new GridLayout(1, 2));
        panelWest.add(lblIsbn);
        panelWest.add(lblBookName);
        panelWest.add(lblBookType);
        panelWest.add(lblBookAuthor);
        panelWest.add(lblAuthorId);
        panelWest.add(lblShelfNumber);
        panelWest.add(lblNumberPages);
        panelWest.add(lblCostOfBook);
        panelWest.add(lblAvaliableLoan);
        
        panelEast.add(txtIsbn);
        panelEast.add(lblErrorIsbn);

        panelEast.add(txtBookName);
        panelEast.add(lblErrorBookName);

        panelEast.add(cbBookType);
        panelEast.add(lblErrorBookType);

        panelEast.add(txtBookAuthor);
        panelEast.add(lblErrorBookAuthor);

        panelEast.add(txtAuthorId);
        panelEast.add(lblErrorAuthorId);

        panelEast.add(cbShelfNumber);
        panelEast.add(lblErrorShelfNumber);

        panelEast.add(txtNumberPages);
        panelEast.add(lblErrorNumberPage);
        panelEast.add(txtCostOfBook);
        panelEast.add(lblErrorCostOfBook);
       panelEast.add(radYes);
       panelEast.add(radNo);
       
        this.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.setPreferredSize(new Dimension(184, 37));
        panelSouth.add(btnAddBook);
        panelSouth.add(btnBack);
        panelSouth.add(btnClear);

        //Adding event listener to button
        btnAddBook.addActionListener(this);
        btnClear.addActionListener(this);
        btnBack.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }
    /// this method check for validation amongst field to prevent empty field

    public boolean validationChecker() {
        boolean valid = true;
        //caregiberCode
        if (txtIsbn.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorIsbn.setVisible(true); // display the label
        } else {
            lblErrorIsbn.setVisible(false);
        }
        if (txtBookName.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorBookName.setVisible(true); // display the label
        } else {
            lblErrorBookName.setVisible(false);
        }

        if (txtBookAuthor.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorBookAuthor.setVisible(true); // display the label
        } else {
            lblErrorBookAuthor.setVisible(false);

        }
        if (txtAuthorId.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorAuthorId.setVisible(true); // display the label
        } else {
            lblErrorAuthorId.setVisible(false);

        }
        if (txtNumberPages.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorNumberPage.setVisible(true); // display the label
        } else {
            lblErrorNumberPage.setVisible(false);
        }
        if (txtCostOfBook.getText().equals("")) {
            valid = false; // set valid to false because the field is null
            lblErrorCostOfBook.setVisible(true); // display the label
        } else {
            lblErrorCostOfBook.setVisible(false);
        }

        return valid;
    }
    // method to clear form

    public void resettingForm() {
        txtIsbn.setText("");
        txtBookName.setText("");
        cbBookType.setSelectedIndex(0);
        txtBookAuthor.setText("");
        cbShelfNumber.setSelectedIndex(0);
        txtAuthorId.setText("");
        txtNumberPages.setText("");
        txtCostOfBook.setText("");

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnAddBook) {
            if (txtIsbn.getText().isEmpty() || txtBookName.getText().isEmpty() || txtBookAuthor.getText().isEmpty() || txtAuthorId.getText().isEmpty() || txtNumberPages.getText().isEmpty()|| txtCostOfBook.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All Field must be fields with value \n make some of the  field are not empty");
            } else{
                
                boolean validateIsbn = request.validateBookIsbn(txtIsbn.getText());
                if (validateIsbn == true){
                String isbn = txtIsbn.getText();
                String bookName = txtBookName.getText();
                String bookType = cbBookType.getSelectedItem().toString();
                String bookAuthor = txtBookAuthor.getText();
                String shelfNumber = cbShelfNumber.getSelectedItem().toString();
                String authorId = txtAuthorId.getText();
                String numberPage = txtNumberPages.getText();
                String cost = txtCostOfBook.getText();
                boolean avaiLableLoan = radYes.isSelected() ? true : false;
                boolean response;
                book = new Book(isbn, bookName, bookType, bookAuthor, authorId, shelfNumber, numberPage, cost, avaiLableLoan);
                 response = request.addBook(book);
                 
                 if(response == true){
                      JOptionPane.showMessageDialog(null, "Book added  Successfully.");
                        resettingForm();
                 }else if (validateIsbn == true) {
                    JOptionPane.showMessageDialog(null, "The Enter ISBN already exits. \n enter another ISBN");
                }
                } 
            }
        }
    }
}
