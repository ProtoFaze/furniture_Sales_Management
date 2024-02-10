/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furniture_sales_management;

import Classes.User;
import view.Login;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;



public class Furniture_Sales_Management {
    private static List<User> users;    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        users=User.list;
        Login page = new Login();
        page.setVisible(true);
//        test.testAlnum();
    }
    
    public static LocalDate convertStringToLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate;
    }
    public static LocalDate DateToLocalDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
    public static String convertLocalDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr = localDate.format(formatter);
        return dateStr;
    }

    /**
     *@deprecated switch to use classes.User.list;
     * @return list of system users
     */
    public static List<User> getUsers(){
        return users;
    }
}
