/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furniture_sales_management;

import Classes.Admin;
import Classes.Officer;
import Classes.SalesPerson;
import Classes.User;
import Interface.Login;
import java.util.List;
import java.util.stream.Collectors;

public class Furniture_Sales_Management {
    private static List<User> users;
    private static List<Admin> admins;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        users=User.list;
        admins = Admin.admins;
        Login page = new Login();
        page.setVisible(true);
    }
    
    public static List<User> getUsers(){
        return users;
    }
}
