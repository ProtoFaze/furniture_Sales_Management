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
     *
     * V0.1 rewrites the entire file to edit//add info, usable for 1 element containing array only
     * @param fileName name of the file to be edited
     * @param content (JSON object) the entire file content saved within main after it has been updated
     * @return status of edit operation
     */
    public static String write(String fileName, JsonArray content){
        String file = SRCPATH+fileName+EXT;
        try(PrintWriter outputFile = new PrintWriter(new FileWriter(file, false))){
            outputFile.println("{\""+fileName+"\":[");
            for(JsonElement element: content){
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
}
