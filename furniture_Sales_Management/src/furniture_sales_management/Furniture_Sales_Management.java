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
    /** @deprecated please use Admin.admins in Admin.<br>
     * generates a copy of admin records stored in main<br>
     * for read purposes only<br>
     * editing this copy does not affect the one in main
     * @return an array list of sales person
     */
    public static List<Admin> getAdmins(){
        return users.stream()
        .filter(user -> user.getRole().equals("admin"))
        .map(user -> new Admin(user.getId(), user.getUserName(), user.getFullName(), user.getMail(), user.getGender(), user.getDob(), user.getPass()))
        .collect(Collectors.toList());
    }
    /** @deprecated please use Officer.officers in Officer.<br>
     * generates a copy of admin records stored in main<br>
     * for read purposes only<br>
     * editing this copy does not affect the one in main
     * @return an array list of sales person
     */
    public static List<Officer> getOfficer(){
        return users.stream()
        .filter(user -> user.getRole().equals("officer"))
        .map(user -> new Officer(user.getId(), user.getUserName(), user.getFullName(), user.getMail(), user.getGender(), user.getDob(), user.getPass()))
        .collect(Collectors.toList());
    }
    /** @deprecated please use SalesPerson.salesPeople in SalesPerson.<br>
     * generates a copy of admin records stored in main<br>
     * for read purposes only<br>
     * editing this copy does not affect the one in main
     * @return an array list of sales person
     */
    public static List<SalesPerson> getSalesPerson(){
        return users.stream()
        .filter(user -> user.getRole().equals("sales person"))
        .map(user -> new SalesPerson(user.getId(), user.getUserName(), user.getFullName(), user.getMail(), user.getGender(), user.getDob(), user.getPass()))
        .collect(Collectors.toList());
    }
    
    public static List<User> getUsers(){
        return users;
    }
}
