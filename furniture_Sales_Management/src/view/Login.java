/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Classes.Admin;
import Classes.File;
import Classes.Officer;
import Classes.SalesPerson;
import Classes.User;
import Classes.Verify;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Liang
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form LoginTest
     */
    private int chance = 3;   
    private static List<User> users;
    public static List<Admin> admins;
    private User currentUser;
    private JsonObject lastUser;
    private final Gson helper;
    
    public Login() {
        initComponents();
        this.admins = Admin.admins;
        this.users = User.list;
        helper = new Gson();
        

        this.lastUser = File.read("lastUser");
        lastUser = lastUser.get("lastUser").getAsJsonObject();
        if(lastUser != null){
            UserTxt.setText(lastUser.get("userName").getAsString());
            PassTxt.setText(lastUser.get("passWord").getAsString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginLbl = new javax.swing.JLabel();
        UserLbl = new javax.swing.JLabel();
        UserTxt = new javax.swing.JTextField();
        PassLbl = new javax.swing.JLabel();
        PassTxt = new javax.swing.JPasswordField();
        RegisterBtn = new javax.swing.JButton();
        LoginBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 340));
        setPreferredSize(new java.awt.Dimension(630, 340));
        setResizable(false);
        setSize(new java.awt.Dimension(630, 360));
        getContentPane().setLayout(null);

        LoginLbl.setBackground(new java.awt.Color(255, 255, 255));
        LoginLbl.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        LoginLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginLbl.setText("Login");
        LoginLbl.setOpaque(true);
        getContentPane().add(LoginLbl);
        LoginLbl.setBounds(170, 60, 281, 31);

        UserLbl.setBackground(new java.awt.Color(255, 255, 255));
        UserLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UserLbl.setText("Username:");
        UserLbl.setOpaque(true);
        getContentPane().add(UserLbl);
        UserLbl.setBounds(140, 140, 80, 19);

        UserTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(UserTxt);
        UserTxt.setBounds(240, 140, 214, 29);

        PassLbl.setBackground(new java.awt.Color(255, 255, 255));
        PassLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PassLbl.setText("Password:");
        PassLbl.setOpaque(true);
        getContentPane().add(PassLbl);
        PassLbl.setBounds(150, 180, 70, 19);

        PassTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(PassTxt);
        PassTxt.setBounds(240, 180, 214, 29);

        RegisterBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RegisterBtn.setText("Register");
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });
        getContentPane().add(RegisterBtn);
        RegisterBtn.setBounds(180, 270, 90, 30);

        LoginBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBtn);
        LoginBtn.setBounds(280, 270, 76, 30);

        ExitBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ExitBtn);
        ExitBtn.setBounds(370, 270, 76, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void RegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterBtnActionPerformed
        Register page = new Register();
        page.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegisterBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        String usr,pass,
        validUName = null, validPass = null;
        //assign values
        usr = UserTxt.getText();
        pass = String.valueOf(PassTxt.getPassword());

        //run validation
        String errorText = Verify.isValidUsername(usr)+Verify.isStrongPassword(pass);
        if(errorText.isEmpty()){
            //login
            login(usr, pass);
            //Record not found 
            if(currentUser == null){
                chance -= 1;
                if (chance == 0){
                    JOptionPane.showMessageDialog(rootPane, "Login chances exhausted, exiting system", "System Lockout", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "You have " + chance + " chances remaining", "Reducing login chances", JOptionPane.ERROR_MESSAGE);
                }
            //Record found
            } else {
                if(!usr.equals(lastUser.get("userName").getAsString())&&
                   !pass.equals(lastUser.get("passWord").getAsString())){
                   lastUser.addProperty("passWord", pass);
                   lastUser.addProperty("userName", usr);
                   File.write("lastUser", lastUser);
                   System.out.print("Updated latest login credentials");
                }
                MainPage window = new MainPage(currentUser);
                window.setVisible(true);
                this.setVisible(false);
            }
        } else {
            //assign error text
            JOptionPane.showMessageDialog(null, errorText, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit login.","Confirm Exit", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Thank you for using the system.","Exiting registration", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_ExitBtnActionPerformed
    
    private void login(String username, String password){
        users.forEach(user -> {
            if (username.equals(user.getUserName()) && password.equals(user.getPass())) {
                //save a JSON copy
                JsonObject userJSON;
                userJSON = helper.fromJson(helper.toJson(user), JsonObject.class);

                String role = user.getRole();
                switch (role) {
                    // convert to appropriate role
                    case "admin"        -> currentUser = helper.fromJson(userJSON,Admin.class);
                    case "officer"      -> currentUser = helper.fromJson(userJSON,Officer.class);
                    case "sales person" -> currentUser = helper.fromJson(userJSON,SalesPerson.class);
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JLabel PassLbl;
    private javax.swing.JPasswordField PassTxt;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JLabel UserLbl;
    private javax.swing.JTextField UserTxt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
