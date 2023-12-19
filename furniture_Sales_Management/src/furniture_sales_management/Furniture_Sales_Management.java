/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furniture_sales_management;

import Classes.File;
import Interface.Login;
//import com.toedter.calendar.JDateChooser;

public class Furniture_Sales_Management {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login(File.readAdmins());
        login.setVisible(true);
//        JDateChooser start = new JDateChooser();
//        System.out.print(start.getDate());
        
    }
    
}
