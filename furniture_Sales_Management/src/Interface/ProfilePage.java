/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Classes.Admin;
import Classes.File;
import Classes.User;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Liang
 */
public class ProfilePage extends javax.swing.JFrame {
    
    /**
     * Creates new form ProfilePage
     */
    private MainPage parent;
    private StaffList workerSource;
    User user;
    private static List<User> users;
    private static List<Admin> admins;
    boolean edit;
    boolean isChanged = false;
    
    public ProfilePage(MainPage parent) {
        this.parent = parent;
        this.user = parent.user;
        this.admins = Admin.admins;
        this.users = User.list;
        
        initComponents();
        NameTxt.setText(user.getFullName());
        IdTxt.setText(user.getId());
        EmailTxt.setText(user.getMail());
        GenderTxt.setText(user.getGenderAsString());
        UserTxt.setText(user.getUserName());
        PassTxt.setText(user.getPass());
        System.out.println(user);
    }
    
    public ProfilePage(StaffList parent) {
        this.workerSource = parent;
        this.user = workerSource.selectedWorker;
        this.admins = Admin.admins;
        this.users = User.list;
        
        initComponents();
        NameTxt.setText(user.getFullName());
        IdTxt.setText(user.getId());
        EmailTxt.setText(user.getMail());
        GenderTxt.setText(user.getGenderAsString());
        UserTxt.setText(user.getUserName());
        PassTxt.setText(user.getPass());
        System.out.println(user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProfileLbl = new javax.swing.JLabel();
        NameLbl = new javax.swing.JLabel();
        GenderLbl = new javax.swing.JLabel();
        EmailLbl = new javax.swing.JLabel();
        IdLbl = new javax.swing.JLabel();
        UserLbl = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        PassLbl = new javax.swing.JLabel();
        IdTxt = new javax.swing.JLabel();
        GenderTxt = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        EmailTxt = new javax.swing.JTextField();
        UserTxt = new javax.swing.JTextField();
        PassTxt = new javax.swing.JPasswordField();
        EditBtn = new javax.swing.JButton();
        PassBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProfileLbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ProfileLbl.setText("Profile");

        NameLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NameLbl.setText("Fullname:");

        GenderLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        GenderLbl.setText("Gender: ");

        EmailLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EmailLbl.setText("Email: ");

        IdLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        IdLbl.setText("ID:");

        UserLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UserLbl.setText("Username:");

        BackBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        PassLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PassLbl.setText("Password:");

        IdTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        IdTxt.setText("ID_NUMBER");

        GenderTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        GenderTxt.setText("GENDER_M/F");

        NameTxt.setEditable(false);
        NameTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NameTxt.setFocusable(false);

        EmailTxt.setEditable(false);
        EmailTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EmailTxt.setFocusable(false);

        UserTxt.setEditable(false);
        UserTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UserTxt.setFocusable(false);

        PassTxt.setEditable(false);
        PassTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PassTxt.setFocusable(false);

        EditBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        PassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/show.png"))); // NOI18N
        PassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserLbl)
                    .addComponent(NameLbl)
                    .addComponent(IdLbl)
                    .addComponent(GenderLbl)
                    .addComponent(PassLbl)
                    .addComponent(EmailLbl))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(EmailTxt)
                    .addComponent(GenderTxt)
                    .addComponent(UserTxt)
                    .addComponent(PassTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ProfileLbl)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLbl)
                    .addComponent(IdTxt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLbl)
                    .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailLbl)
                    .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLbl)
                    .addComponent(GenderTxt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLbl)
                    .addComponent(UserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PassLbl)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PassTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EditBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(BackBtn)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PassBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        if(parent!=null){
            parent.user = user;
            parent.setVisible(true);
        }else{
            workerSource.selectedWorker = user;
            workerSource.populateTable();
            workerSource.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        String status;
        if (edit) {
            status = "save";
        } else {
            status = "edit";
        }
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + status + "?","Confirm " + status, JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            if (!edit){
                Edit(true);
                edit = true;
            } else {
                saveChanges();
                Edit(false);
                edit = false;
            }
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void PassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassBtnActionPerformed
        // TODO add your handling code here:
        if(PassBtn.isSelected()) {
            PassTxt.setEchoChar((char)0);
        } else {
            PassTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_PassBtnActionPerformed
    
    private void Edit(boolean flag){
        NameTxt.setEditable(flag);
        NameTxt.setFocusable(flag);
        EmailTxt.setEditable(flag);
        EmailTxt.setFocusable(flag);
        UserTxt.setEditable(flag);
        UserTxt.setFocusable(flag);
        PassTxt.setEditable(flag);
        PassTxt.setFocusable(flag);
        if (flag) {
            EditBtn.setText("Save");
        } else {
            EditBtn.setText("Edit");
        }
    }
    
    private void saveChanges(){
        for (User record:users){
            if(user.getId().equals(record.getId())){
                record.setFullName(NameTxt.getText());
                record.setMail(EmailTxt.getText());
                record.setUserName(UserTxt.getText());
                record.setPass(String.valueOf(PassTxt.getPassword()));
            }
            File.write("user", users);
            User.populateList();
        }
    }
   
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProfilePage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel EmailLbl;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JLabel GenderLbl;
    private javax.swing.JLabel GenderTxt;
    private javax.swing.JLabel IdLbl;
    private javax.swing.JLabel IdTxt;
    private javax.swing.JLabel NameLbl;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JToggleButton PassBtn;
    private javax.swing.JLabel PassLbl;
    private javax.swing.JPasswordField PassTxt;
    private javax.swing.JLabel ProfileLbl;
    private javax.swing.JLabel UserLbl;
    private javax.swing.JTextField UserTxt;
    // End of variables declaration//GEN-END:variables
}
