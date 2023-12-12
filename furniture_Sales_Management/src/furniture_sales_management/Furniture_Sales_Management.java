/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package furniture_sales_management;

import Classes.File;
import Classes.Admin;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
/**
 *
 * @author damonng
 */
public class Furniture_Sales_Management {
    Admin[] SalesPeople;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        LoginPage login = new LoginPage(File.read("room"));
        JsonObject json = File.read("room");
        JsonArray roomArray = json.getAsJsonArray("room");
        
        for (JsonElement element: roomArray){
            JsonObject record = element.getAsJsonObject(); //convert to access keys
            record.get("id");
        }
    }
    
}
