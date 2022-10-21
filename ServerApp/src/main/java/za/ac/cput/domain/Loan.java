/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.domain;

public class Loan {

    private long studentNumber;
    private int isbn;
    private boolean availableForLoan;

    public Loan(long studentNumber, int isbn, boolean availableForLoan) {
        this.studentNumber = studentNumber;
        this.isbn = isbn;
        this.availableForLoan = availableForLoan;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailableForLoan() {
        return availableForLoan;
    }

    public void setAvailableForLoan(boolean availableForLoan) {
        this.availableForLoan = availableForLoan;
    }

    @Override
    public String toString() {
        return "Loan{" + "studentNumber=" + studentNumber + ", isbn=" + isbn + ", availableForLoan=" + availableForLoan + '}';
    }

}
