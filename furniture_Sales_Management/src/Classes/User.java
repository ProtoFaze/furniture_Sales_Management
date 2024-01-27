/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;
/**
 *
 * @author damonng
 */
public abstract class User extends Person {
    //Declare variables
    protected String userName, passWord, role;
    public static List<User> list;
    public static int latestId = 1;
    
//    private static List<ListUpdateListener<User>> listeners = new ArrayList<>();

    
    static{
        populateList();
    }
    //constructor for registration
    public User(String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(String.valueOf(latestId+=1), fullName, emailAddress, dob, gender);
        this.userName = userName;
        this.passWord = passWord;
        this.role = "";
    }
    
    //constructors for read file
    public User(String id, String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(id, fullName, emailAddress, dob, gender);
        this.userName = userName;
        this.passWord = passWord;
        this.role = "";
        if(Integer.parseInt(id)>latestId){
            latestId = Integer.parseInt(id);
        }
    }
    
    //SETTERS
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPass(String password){
        this.passWord = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    
    //GETTERS
    public String getUserName(){
        return this.userName;
    }
    public String getPass(){
        return this.passWord;
    }
    public String getRole() {
        return role;
    }
    
    public static void populateList(){
        list = File.readUsers();
        Admin.subsetUsers();
        Officer.subsetUser();
        SalesPerson.subsetUser();
//        notify(list);
    }
//    private static void notify(List<User> newUserList) {
//        for (ListUpdateListener listener : listeners) {
//            listener.onListUpdated(newUserList);
//        }
//    }
//    //autoUpdate all subLists
//    public static void addUserListListener(ListUpdateListener listener) {
//        listeners.add(listener);
//    }

    /**
     * used for each role's main function, 
     * salesperson create sales order, 
     * officer approve sales order//create invoice
     * Admin edits staff records
     * @return status of role-specific main function's wrote operation
     */
    abstract String writeToFile();
            
}