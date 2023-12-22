/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.List;



/**
 * This class focuses on file access using google's Gson library for handling reading & writing JSON to and from a text file.
 * @author damonng
 */
public class File {
    private static final String SRCPATH = "./src/data/", EXT = ".txt";
//    private static final Gson HELPER = new Gson();
    /**
     * reads the entire JSON text file
     * @param fileName name of the file to read
     * @return JSONObject if successful, error message if not successful
     */
    public static JsonObject read(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(SRCPATH+fileName+EXT))){
            //Convert to JSON String
            Gson gson = new Gson();
            StringBuilder jsonContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);  
            }
            //Convert JSON String to JSONObject then return it
            return gson.fromJson(jsonContent.toString(), JsonObject.class);
        } catch (IOException ex) {
            System.out.println("Failed to read File"+ex.toString());
            return null;
        }
    }
    public static JsonArray readArray(String fileName){
        try{
            JsonObject object  = read(fileName);
            return object.get(fileName).getAsJsonArray();
        } catch(IllegalStateException ex) {
            System.out.println("Failed to read File"+ex.toString());
            return null;
        }
    }
    public static List<User> readUsers(){
        List<User> users = new ArrayList<>();
        Gson gson = new Gson();

        // store json in memory 
        JsonArray userJson = File.readArray("user");
        
        // store admins into list then return when done
        for (JsonElement element: userJson){
            JsonObject object = element.getAsJsonObject();
            String role = object.get("role").getAsString();
            User user;
            switch (role){
                case "admin" -> {
                    user = gson.fromJson(object, Admin.class);
                    users.add(user);
                }
                case "officer" -> {
                    user = gson.fromJson(object, Officer.class);
                    users.add(user);
                }
                case "sales person" ->{
                    user = gson.fromJson(object, Officer.class);
                    users.add(user);
                }

            }
        }
        return users;
    }
    /**
     * @deprecated please use getAdmins in main.<br>
     * 
     * extract admin records from user file
     * @return an array list of admins
     */
    @Deprecated
    public static List<Admin> readAdmins(){
        //initialize HELPER function, name and list
        Gson gson = new Gson();
        String fileName = "user";
        List<Admin> admins = new ArrayList<>();

        // store json in memory 
        JsonObject userJson = read(fileName);
        JsonArray UserArray = userJson.getAsJsonArray(fileName);
        
        // store admins into list then return when done
        for (JsonElement element: UserArray){
            JsonObject adminJson = element.getAsJsonObject();
            if ("admin".equals(adminJson.get("role").getAsString())){
                System.out.println(adminJson);
                Admin admin = gson.fromJson(adminJson, Admin.class);
                admins.add(admin);
            }else{
            }
        }
        return admins;
    }
    /**
     * @deprecated please use getOfficers in main.<br>
     * extract officer records from user file
     * @return an array list of officers
     */
    @Deprecated
    public static List<Officer> readOfficers(){
        //initialize HELPER function, name and list
        Gson gson = new Gson();
        String fileName = "user";
        List<Officer> officers = new ArrayList<>();

        // store json in memory 
        JsonObject userJson = read(fileName);
        JsonArray userArray = userJson.getAsJsonArray(fileName);
        
        // store admins into list then return when done
        for (JsonElement element: userArray){
            JsonObject officerJson = element.getAsJsonObject();
            if ("officer".equals(officerJson.get("role").getAsString())){
                System.out.println(officerJson);
                Officer officer = gson.fromJson(officerJson, Officer.class);
                officers.add(officer);
            }else{
            }
        }
        return officers;
    }
    

    /**
     * For files containing multiple records, like users, sales<br>
     * rewrites the entire file to edit//add info, usable for 1 element containing array only<br>
     * If using java.util.List, File.write(fileName, gson.toJsonTree(list).getAsJsonArray())
     * @param fileName name of the file to be edited
     * @param contents (JSON object) the entire file contents saved within main after it has been updated
     * @return status of edit operation
     */
    public static String write(String fileName, JsonArray contents){
        String file = SRCPATH+fileName+EXT;
        try(PrintWriter outputFile = new PrintWriter(new FileWriter(file, false))){
            int size = contents.size();
            for (int i = 0; i < size; i++) {
                JsonObject record = contents.get(i).getAsJsonObject();
                outputFile.print(record);
                if (i < size - 1) {
                    outputFile.println(",");
                }
            }
            outputFile.println("\n]}");
            return "Success";
        }catch (IOException ex){
            return ex.toString();
        }
    }
    /**
     * For files containing only 1 record, like save or config files<br>
     * rewrites the entire file to edit//add info, usable for 1 JSONObject only<br>
     * @param fileName name of the file to be edited
     * @param content (JSON object) the entire file contents saved within main after it has been updated
     * @return status of edit operation
     */
    public static String write(String fileName, JsonObject content){
        String file = SRCPATH+fileName+EXT;
        try(PrintWriter outputFile = new PrintWriter(new FileWriter(file, false))){
            outputFile.println("{\""+fileName+"\":");
            outputFile.println(content);
            outputFile.println("}");
            return "Success";
        }catch (IOException ex){
            return ex.toString();
        }
    }
}
