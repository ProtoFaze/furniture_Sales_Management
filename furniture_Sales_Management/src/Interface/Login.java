/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Classes.Admin;
import Classes.File;
import Classes.Officer;
import Classes.SalesPerson;
import Classes.User;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginLbl.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        LoginLbl.setText("Login");

        UserLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UserLbl.setText("Username:");

        UserTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        PassLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PassLbl.setText("Password:");

        PassTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        RegisterBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RegisterBtn.setText("Register");
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });

        LoginBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        ExitBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(LoginLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(123, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserLbl)
                            .addComponent(PassLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserTxt)
                            .addComponent(PassTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(RegisterBtn)
                        .addGap(18, 18, 18)
                        .addComponent(LoginBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ExitBtn)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(LoginLbl)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLbl)
                    .addComponent(UserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitBtn)
                    .addComponent(LoginBtn)
                    .addComponent(RegisterBtn))
                .addGap(86, 86, 86))
        );

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
        if(validUName == null && validPass == null){
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
            JOptionPane.showMessageDialog(null, validUName+validPass, "Error", JOptionPane.ERROR_MESSAGE);
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
    // End of variables declaration//GEN-END:variables
}
