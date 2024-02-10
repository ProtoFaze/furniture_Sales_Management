/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author damonng
 * For objects like customers 
 */
public abstract class Person {
    protected String id, fullName, emailAddress, dob;
    protected char gender;

    public Person(String id, String fullName, String emailAddress, String dob, char gender) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.gender = gender;
    }

    //SETTERS
    public void setId(String id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setMail(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public void setDob(LocalDate dob){
        String dateRegex = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateRegex);
        String dateString = dob.format(formatter);
        this.dob = dateString;
    }
    public void setGender(char gender){
        char original = this.gender;
        this.gender = (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') 
            ? original 
            : Character.toUpperCase(gender) ;
    }
    
    //GETTERS
    public String getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    public String getMail(){
        return emailAddress;
    }
    public String getDob(){
        return dob;
    }
    public String getGenderAsString(){
        return String.valueOf(gender);
    }
    public char getGender() {
        return gender;
    }
    
}
