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
 *
 * @author damonng
 */
public class File {
    private static final String SRCPATH = "./src/data/", EXT = ".txt";
    /**
     * reads the entire json text file
     * @param fileName name of the file to be edited
     * @return JSON of add operation if success, error message if not successful
     */
    public static JsonObject read(String fileName){
        Gson gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(SRCPATH+fileName+EXT))){
            //Convert to JSON String
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
    /**
     * extract admin records from user file
     * @return an array list of admins
     */
    public static List<Admin> readAdmins(){
        //initialize helper function, name and list
        String fileName = "user";
        Gson gson = new Gson();
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
    
    public static List<Officer> readOfficers(){
        //initialize helper function, name and list
        String fileName = "user";
        Gson gson = new Gson();
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
     * For files containing multiple records, like users, sales
     * V0.1 rewrites the entire file to edit//add info, usable for 1 element containing array only
     * @param fileName name of the file to be edited
     * @param contents (JSON object) the entire file contents saved within main after it has been updated
     * @return status of edit operation
     */
    public static String write(String fileName, JsonArray contents){
        String file = SRCPATH+fileName+EXT;
        try(PrintWriter outputFile = new PrintWriter(new FileWriter(file, false))){
            outputFile.println("{\""+fileName+"\":[");
            for(JsonElement element: contents){
                //print out each record
                JsonObject record = element.getAsJsonObject();
                outputFile.println(record);
            }
            outputFile.println("]}");
            return "Success";
        }catch (IOException ex){
            return ex.toString();
        }
    }
    /**
     * For files containing only 1 record, like save or config files
     * V0.1 rewrites the entire file to edit//add info, usable for 1 element containing array only
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
