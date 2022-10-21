/*
 *This is alibrary management system
 *Group : Revolutionary
 * September 2022
 */
package za.ac.cput.domain;

public class User {
    private String firstName;
    private String userName;
    private String password;
    private String confirmPassword;

    public User(String firstName, String userName, String password, String confirmPassword) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword + '}';
    }
    

}
