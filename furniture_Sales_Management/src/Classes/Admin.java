/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author damonng
 */
public class Admin extends User{
    public static List<Admin> admins;
    static{
        subsetUsers();
    }
    static void subsetUsers(){
        if (User.list == null || User.list.isEmpty()) {
            User.populateList();
        }
        admins = User.list.stream()
            .filter(user -> user.getRole().equals("admin"))
            .map(user -> (Admin) user)
            .collect(Collectors.toList());
    }
    
    
    //for read file
    public Admin(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "admin";
    }

    //for registration
    public Admin(String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "admin";
    }

    public void getAllWorkers(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String writeToFile(){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
