/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.domain;

import java.io.Serializable;


public class Learner implements Serializable{   
 private String studentNumber;
    private String studentName;
    private String learnerGrade;
    private String fieldStudy;
    private int phoneNumber;
    private int alternativeNumber;
    private int age;
    private String address;

    public Learner(String studentNumber, String studentName, String learnerGrade, String fieldStudy, int phoneNumber, int alternativeNumber, int age,String address) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.learnerGrade = learnerGrade;
        this.fieldStudy = fieldStudy;
        this.phoneNumber = phoneNumber;
        this.alternativeNumber = alternativeNumber;
        this.age = age;
        this.address = address;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLearnerGrade() {
        return learnerGrade;
    }

    public void setLearnerGrade(String learnerGrade) {
        this.learnerGrade = learnerGrade;
    }

    public String getFieldStudy() {
        return fieldStudy;
    }

    public void setFieldStudy(String fieldStudy) {
        this.fieldStudy = fieldStudy;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAlternativeNumber() {
        return alternativeNumber;
    }

    public void setAlternativeNumber(int alternativeNumber) {
        this.alternativeNumber = alternativeNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Learners{" + "studentNumber=" + studentNumber + ", studentName=" + studentName + ", learnerGrade=" + learnerGrade + ", fieldStudy=" + fieldStudy + ", phoneNumber=" + phoneNumber + ", alternativeNumber=" + alternativeNumber + ", age=" + age + '}';
    }
    
   
}
