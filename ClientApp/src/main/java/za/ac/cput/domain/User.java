/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.domain;

import java.io.Serializable;

public class User implements Serializable{
    private int userID;
    private String userName;
    private int userContactNumber;
    private String userAddressDetail;
    private String password;
    
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    

    public User(int userID, String userName, int userContactNumber, String userAddressDetail, String password) {
        this.userID = userID;
        this.userName = userName;
        this.userContactNumber = userContactNumber;
        this.userAddressDetail = userAddressDetail;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserContactNumber() {
        return userContactNumber;
    }
    
     public void setPassword(String password) {
        this.password = password;
    }
     
    public String getPassword() {
        return password;
    }

    public void setUserContactNumber(int userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserAddressDetail() {
        return userAddressDetail;
    }

    public void setUserAddressDetail(String userAddressDetail) {
        this.userAddressDetail = userAddressDetail;
    }
    
    
}
