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
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;



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
    
    public LocalDate convertStringToLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate;
    }
    public LocalDate DateToLocalDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
    public String convertLocalDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr = localDate.format(formatter);
        return dateStr;
    }
    public static List<User> getUsers(){
        return users;
    }
}
