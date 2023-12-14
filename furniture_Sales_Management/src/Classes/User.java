/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author damonng
 */
abstract class User {
    //Declare variables
    protected String id, fullName, emailAddress, username, password, dob, role;
    protected char gender;
    
    
    //constructors
    User(String id, String username, String fullName, String emailAddress, char gender, String dob, String password){
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
        this.role = "";
    }
    //SETTERS
    public void setName(String fullName){
        this.fullName = fullName;
    }
    public void setMail(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public void setGender(char gender){
        char original = this.gender;
        this.gender = (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') 
            ? original 
            : Character.toUpperCase(gender) ;
    }
    public void setDOB(String dob){
        this.dob = dob;
    }
    public void setDOB(LocalDate dob){
        String dateRegex = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateRegex);
        String dateString = dob.format(formatter);
        this.dob = dateString;
    }
    
    
    //GETTERS
    public String getName(){
        return this.fullName;
    }
    public String getmail(){
        return this.emailAddress;
    }
    public char getGender(){
        return this.gender;
    }
    public String getdob(){
        return this.dob;
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
     * Admin ........
     * @return status of role-specific main function's wrote operation
     */
    abstract String writeToFile();
    
}