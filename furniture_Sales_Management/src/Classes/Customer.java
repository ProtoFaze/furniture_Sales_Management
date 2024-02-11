/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;

/**
 *
 * @author damonng
 */
public class Customer extends Person{
    private String address;
    public static List<Customer> list;
    public static int latestId;
    
    static{
        populateList();
        latestId = list.size()+1;
    }
    //for read
    public Customer(String id, String fullName, String emailAddress, String dob, char gender, String address) {
        super(id, fullName, emailAddress, dob, gender);
        this.address = address;
    }
    //for create
    public Customer(String fullName, String emailAddress, String dob, char gender, String address) {
        super(String.valueOf(latestId++), fullName, emailAddress, dob, gender);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public static void populateList(){
        list = File.read("customer", Customer.class);
    }
}
