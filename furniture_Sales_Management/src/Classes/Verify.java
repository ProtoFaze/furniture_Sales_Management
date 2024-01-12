/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Aryssa
 */
public class Verify {
    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isValidUsername(String userName) {
        return userName.length() >= MIN_USERNAME_LENGTH &&
               userName.length() <= MAX_USERNAME_LENGTH;
    }
    /*
     
@param password
@return */
public static boolean isStrongPassword(String password) {//at least one uppercase, one lowercase, one digit
 
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
         break;}}
 return password.length() >= MIN_PASSWORD_LENGTH && hasUppercase && hasLowercase && hasDigit;}
}