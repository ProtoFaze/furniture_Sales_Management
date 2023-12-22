/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author wenliang
 */
public class Officer extends User{
    public Officer(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, userName, fullName, emailAddress, gender, dob, passWord);
        this.role = "officer";
    }
    
    public String writeToFile(){
        return "";
    }
    
    @Override
    public void edit_Profile(String new_data, int attribute) {
//        boolean verified = false;
//        //verification
//        if (verified == true){
//            //apply changes
//            switch (attribute){
//                case 0 -> this.setName(new_data);
//                case 1 -> this.setMail(new_data);
//                case 2 -> this.setGender(new_data.charAt(0));
//                case 3 -> this.setDOB(new_data);
//            }
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
