/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furniture_sales_management;

import Classes.Admin;
import Classes.File;
import java.util.List;
import java.security.*;

public class Furniture_Sales_Management {
    static List<Admin> admins ;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        LoginPage login = new LoginPage(File.read("room"));
           admins = File.readAdmins();
           System.out.println(admins.size());
           for (Admin admin : admins){
               System.out.print(admin.getmail());
           }
//        JDateChooser start = new JDateChooser();
//        System.out.print(start.getDate());
        
    }
    
}
