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
    public static int latestId;
    
//    private static List<ListUpdateListener<User>> listeners = new ArrayList<>();

    
    static{
        populateList();
        latestId = Integer.parseInt(list.getLast().getId())+1;
    }
    //constructor for registration
    public User(String userName, String fullName, String emailAddress, char gender, String dob, String passWord) {
        super(String.valueOf(latestId++), fullName, emailAddress, dob, gender);
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
    /*
    *Updates user file, list and subLists in subfunctions
    */
    public static void populateList() {
        List<User> fetchData = File.readUsers(); // read user file, doesn't detect if it's new or old
        if (list!=null && !list.equals(fetchData) && !list.containsAll(fetchData)) {
            // user file is outdated
            File.write("user", list);
        }else{
            list = fetchData;
        }

        // update list
        Admin.subsetUsers();
        Officer.subsetUsers();
        SalesPerson.subsetUsers();
        // notify(list);
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