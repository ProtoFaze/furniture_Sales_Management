/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wenliang
 */
public class Officer extends User{
    public static List<Officer> officers;
    
    static void subsetUser(){
        if (User.list == null || User.list.isEmpty()) {
            User.populateList();
        }
        officers = User.list.stream()
            .filter(user -> user.getRole().equals("officer"))
            .map(user -> (Officer) user)
            .collect(Collectors.toList());
    }
    
    //for read file
    public Officer(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "officer";
    }
    //for registration
    public Officer(String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "officer";
    }    

    
    public String writeToFile(){
        return "";
    }
}
