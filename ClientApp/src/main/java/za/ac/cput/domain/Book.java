/*
 *This is a library management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.domain;

import java.io.Serializable;

public class Book implements Serializable {
    private String Isbn;
    private String BookName;
    private String BookType;
    private String BookAuthor;
    private String AuthorId;
    private String ShelfNumber;
    private String numberPages;
    private String bookCost;
    private boolean availableForLoan;

    public Book(String Isbn, String BookName, String BookType, String BookAuthor, String AuthorId, String ShelfNumber, String numberPages, String bookCost,boolean availableForLoan) {
        this.Isbn = Isbn;
        this.BookName = BookName;
        this.BookType = BookType;
        this.BookAuthor = BookAuthor;
        this.AuthorId = AuthorId;
        this.ShelfNumber = ShelfNumber;
        this.numberPages = numberPages;
        this.bookCost = bookCost;
        this.availableForLoan = availableForLoan;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getBookType() {
        return BookType;
    }

    public void setBookType(String BookType) {
        this.BookType = BookType;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String AuthorId) {
        this.AuthorId = AuthorId;
    }

    public String getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(String ShelfNumber) {
        this.ShelfNumber = ShelfNumber;
    }

    public String getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(String numberPages) {
        this.numberPages = numberPages;
    }

    public String getBookCost() {
        return bookCost;
    }

    public void setBookCost(String bookCost) {
        this.bookCost = bookCost;
    }

    public boolean isAvailableForLoan() {
        return availableForLoan;
    }

    public void setAvailableForLoan(boolean availableForLoan) {
        this.availableForLoan = availableForLoan;
    }

    @Override
    public String toString() {
        return "Books{" + "Isbn=" + Isbn + ", BookName=" + BookName + ", BookType=" + BookType + ", BookAuthor=" + BookAuthor + ", AuthorId=" + AuthorId + ", ShelfNumber=" + ShelfNumber + ", numberPages=" + numberPages + ", bookCost=" + bookCost + ", availableForLoan=" + availableForLoan + '}';
    }
    
    
}
