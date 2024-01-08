/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
/**
 *
 * @author damonng
 */
public abstract class User extends Person {
    //Declare variables
    protected String userName, passWord, role;
    
    //constructors
    public User(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, fullName, emailAddress, dob, gender);
        this.userName = userName;
        this.passWord = passWord;
        this.role = "";
    }
    
    //SETTERS
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPass(String password){
        this.passWord = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    
    //GETTERS
    public String getUserName(){
        return this.userName;
    }
    public String getPass(){
        return this.passWord;
    }
    public String getRole() {
        return role;
    }
    
    /**
     * allows users to edit profile 
     * @param new_data the keywords in plaintext
     * @param attribute the attribute to be edited
     */
    abstract void edit_Profile(String new_data, int attribute);
    /**
     * used for each role's main function, 
     * salesperson create sales order, 
     * officer approve sales order//create invoice
     * Admin edits staff records
     * @return status of role-specific main function's wrote operation
     */
    abstract String writeToFile();
    
}