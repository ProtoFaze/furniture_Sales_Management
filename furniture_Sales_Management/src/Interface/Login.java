package Interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.List;
import Classes.File;
import Classes.User;
import Classes.Admin;
import Classes.Officer;
import Classes.SalesPerson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 *
 * @author damonng
 */
public class Login extends javax.swing.JFrame {
    private int chance = 3;    
    List<Admin> admins;
    List<User> users;
    private User currentUser;
    private JsonObject lastUser;
    private final Gson helper;
    /**
     * Creates new form login
     * @param admins ArrayList of admin object
     * @param users
     */
    public Login(List<Admin> admins, List<User> users) {
        initComponents();
        
        //for registration
        this.admins  = admins;
        
        this.users = users;
        helper = new Gson();
        

        this.lastUser = File.read("lastUser");
        System.out.print(lastUser);
        lastUser = lastUser.get("lastUser").getAsJsonObject();
        if(lastUser != null){
            txtUsername.setText(lastUser.get("userName").getAsString());
            txtPassword.setText(lastUser.get("passWord").getAsString());
        }
    }

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pageTitle = new javax.swing.JLabel();
        divider = new javax.swing.JSeparator();
        username = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        errUName = new javax.swing.JLabel();
        password = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        errPass = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        pageTitle.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        pageTitle.setText("Login");
        pageTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        username.setBackground(null);

        lblUsername.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setText("Enter username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        errUName.setForeground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout usernameLayout = new javax.swing.GroupLayout(username);
        username.setLayout(usernameLayout);
        usernameLayout.setHorizontalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(errUName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        usernameLayout.setVerticalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameLayout.createSequentialGroup()
                .addGroup(usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usernameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsername))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errUName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblPassword.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(64, 26));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        errPass.setEditable(false);
        errPass.setBackground(new java.awt.Color(238, 238, 238));
        errPass.setColumns(20);
        errPass.setForeground(new java.awt.Color(255, 102, 51));
        errPass.setLineWrap(true);
        errPass.setRows(5);
        errPass.setWrapStyleWord(true);
        errPass.setBorder(null);
        jScrollPane1.setViewportView(errPass);

        javax.swing.GroupLayout passwordLayout = new javax.swing.GroupLayout(password);
        password.setLayout(passwordLayout);
        passwordLayout.setHorizontalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        passwordLayout.setVerticalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(passwordLayout.createSequentialGroup()
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
        );

        btnBack.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnReset.setText("Clear");
        btnReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divider)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnLogin)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(divider, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btnRegister))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit login.","Confirm Exit",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Thank you for using the system.","Exiting registration",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);}
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //declare input & validation variables
        String usr,pass,
        validUName = null, validPass = null;
        //assign values
        usr=txtUsername.getText();
        pass = String.valueOf(txtPassword.getPassword());

        //run validation
//        validUName = verify.validateString(usr);
//        validPass = verify.validatePass(pass);
        if(validUName == null && validPass == null){
            //login
            login(usr, pass);
            //Record not found 
            if(currentUser == null){
                chance-=1;
                if (chance==0){
                    JOptionPane.showMessageDialog(rootPane, "login chances exhausted, quitting system", "System Lockout", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "You have "+chance+" chances remaining", "Reducing login chances", JOptionPane.ERROR_MESSAGE);
                }
            //Record found
            }else{
                if( usr.equals(lastUser.get("userName").getAsString())&&
                    pass.equals(lastUser.get("passWord").getAsString())){
                    lastUser.addProperty("passWord", pass);
                    lastUser.addProperty("userName", usr);
                    File.write("lastUser", lastUser);
                    System.out.print("Updated latest login credentials");
                }
//                mainPage redirect = new mainPage(staff);
//                redirect.setVisible(true);
//                this.setVisible(false);
            }
        }else{
            //assign error text
            errUName.setText(validUName);
            errPass.setText(validPass);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtUsername.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
         if (txtUsername.getText().equals("Enter username")){
            txtUsername.setText("");
            txtUsername.setForeground(new Color (69,69,69));
         }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if (txtUsername.getText().equals("")){
            txtUsername.setText("Enter username");
            txtUsername.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String AdminPass = JOptionPane.showInputDialog(rootPane, "Please provide Admin Passcode");
        if(AdminPass != null){
            for (Admin admin: admins){
                if (AdminPass.equals(admin.getPass())){
                    JOptionPane.showMessageDialog(rootPane, "Redirecting to staff registration");
    //                Registration page = new Registration();
    //                page.setVisible(true);
    //                this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "wrong passcode");
                }
            }
        }

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            // enter key pressed
            // perform login validation
            txtPassword.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            // enter key pressed
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReset;
    private javax.swing.JSeparator divider;
    private javax.swing.JTextArea errPass;
    private javax.swing.JLabel errUName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JPanel password;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel username;
    // End of variables declaration//GEN-END:variables
}
