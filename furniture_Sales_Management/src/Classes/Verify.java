/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class mainly used for verification
 * verification functions return error text if there are any errors detected, otherwise returns an empty string
 * @author Aryssa
 */
public class Verify {
    private static final String DATEREGEX = "dd/MM/yyyy";
    private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat(DATEREGEX);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATEREGEX);
    
    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;

    //Username
    public static String isValidUsername(String userName) {
        String errorText = (userName.length() >= MIN_USERNAME_LENGTH && userName.length() <= MAX_USERNAME_LENGTH )? "": "username must be between 4  to 20 characters";
        return errorText;
    }
    /* 
    @param password 
    @return error text if any
    */
    //Password
    public static String isStrongPassword(String password) {//at least one uppercase, one lowercase, one digit

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for(char ch: password.toCharArray()){
            if (Character.isUpperCase(ch)){
                hasUppercase = true;}
            else if(Character.isLowerCase(ch)){
                hasLowercase = true;}
            else if(Character.isDigit(ch)){
                hasDigit = true;}
            if(hasUppercase && hasLowercase && hasDigit){
                break;
            }
        }
        String errorMsg = "";
        if (!(password.length()>=MIN_PASSWORD_LENGTH)){
            errorMsg= errorMsg + MIN_PASSWORD_LENGTH+" characters;";
        }if(!hasUppercase){
            errorMsg+="1 uppercase letter;";
        }if (!hasLowercase){
            errorMsg+="1 lowercase letter;";
        }if (!hasDigit){
            errorMsg+="1 digit;";
        }
        errorMsg = (password.length() >= MIN_PASSWORD_LENGTH && hasUppercase && hasLowercase && hasDigit) ? "": "Password must have at least " + errorMsg+"\n";

        return errorMsg;
    }

    //Email
    public static String validateEmail(String emailAddress){
        String trimmedInput = emailAddress.trim();

       if (trimmedInput.isEmpty()|| trimmedInput.length()<2){
           return "Email must be more than 2 characters\n";
       }
       else if (!trimmedInput.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$")){
           return "Invalid email format\n";
       }
       else{
           return "";
       }
    }

    //FullName
    public static String validateFullName(String FullName){
        String trimmedFullName = FullName.trim();
        if (trimmedFullName.length()<2){
            System.out.println("less than 2 characters in fname");
            return "Full Name must be more than 2 characters\n";
        }
        else if (!trimmedFullName.matches("^[A-Za-z\\s]+$")){
            return "Invalid characters in Full Name\n";
        }
        else{
            return ""; 
        }
    }

    //living address
    public static String validateAddress(String LivingAddress){
        String trimmedFullAddress = LivingAddress.trim();
        if (trimmedFullAddress.length()<2){
            return "Living address must be more than 2 characters\n";
        }
        else {
            Pattern pattern = Pattern.compile("[;\\'\"()<>%*|&$#@!]");
            Matcher matcher = pattern.matcher(trimmedFullAddress);

            if (matcher.find()) {
                return "Invalid characters detected\n";
            } else {
                return "";
            }
        }
    }

    /**
     * allows only  past or future date
     * @param date
     * @param allowFutureDate
     * @return error text if any
     */
    public static String validateDate(String date, boolean allowFutureDate){
        String formatCheck = validateDate(date);
        if(!formatCheck.isEmpty())
            return formatCheck;
        else{
            try {
                LocalDate input = StringToLocalDate(date);
                if(allowFutureDate == false){
                    return (input.isAfter(LocalDate.now())) ? "Cannot set date from the future\n":"";
                }else{
                    return (input.isBefore(LocalDate.now()))? "Cannot set date from the past\n":"";
                }
            }catch(Exception e){
                return e.toString();
            }    
        }
    }
    /**
     * allows any date, only checks if date is valid
     * @param date
     * @return error text if any
     */
    public static String validateDate(String date){
        if((!date.matches("\\d{2}/\\d{2}/\\d{4}")) && (!"".equals(date))){
            return "Format day/month/year in digits only.";
        }else{
            return "";
        }
    }
    
    
    
    
    public static LocalDate StringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, FORMATTER);
    }
    public static LocalDate DateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static String LocalDateToString(LocalDate localDate) {
        return localDate.format(FORMATTER);
    }
    public static String DateToString(Date date) {
        return DATEFORMAT.format(date);
    }
    public static Date StringToDate(String dateStr) {
        try{
            return DATEFORMAT.parse(dateStr);
        }catch(ParseException e){
            System.out.println(e);
            return null;
        }
    }
}