/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
//import java.util.ArrayList;
//import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author damonng
 */
public class SalesPerson extends User {
    public static List<SalesPerson> salesPeople;
    
    static{
        subsetUsers();
    }
    
    static void subsetUsers(){
        if (User.list == null || User.list.isEmpty()) {
            User.populateList();
        }
        salesPeople = User.list.stream()
            .filter(user -> user.getRole().equals("sales person"))
            .map(user -> (SalesPerson) user)
            .collect(Collectors.toList());
    }

    //for read file
    public SalesPerson(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "sales person";
    }
    //for registration
    public SalesPerson(String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "sales person";
    }

    
    @Override
    public String writeToFile(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
