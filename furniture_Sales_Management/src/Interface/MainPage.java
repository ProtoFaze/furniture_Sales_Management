package Interface;

import Classes.Admin;
import Classes.User;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author damonng
 */
public class MainPage extends javax.swing.JFrame {
    /**
    * Primarily to get role for rendering the page and sub pages<br>
    * id would be useful for filtering records specific to current user
    */
    User user;
    ProfilePage profilePage;
    private Color colorPrimary, colorSecondary;
    private static List<User> users;
    private static List<Admin> admins;
    
    /**
     * Creates new form MainPage
     * @param user
     */
    public MainPage(User user) {

        this.user = user;
        String roleLblText;
        this.admins = Admin.admins;
        this.users = User.list;
        profilePage = new ProfilePage(this);

        //PREINIT-setColor scheme
        switch (this.user.getRole()){
            case "admin" -> {
                roleLblText="admin detected";
                colorPrimary = new Color(112, 112, 255);
                colorSecondary = new Color(230, 230, 230);
            }
            case "officer" -> {
                roleLblText="officer detected";
                colorPrimary = new Color(0, 100, 50);
                colorSecondary = new Color(100, 200, 150);
            }
            case "sales person" -> {
                roleLblText="sales person detected";
                colorPrimary = new Color(255, 153, 51);
                colorSecondary = new Color(230, 230, 230);
            }
            default -> {
                roleLblText="unidentified user detected";
                colorPrimary = new Color(244, 244, 244);
                colorSecondary = new Color(230, 230, 230);
            }
        }
        initComponents();
        rolelbl.setText(roleLblText);
        loadData();
    }

    private void loadData(){
        welcometxt.setText("Welcome " + user.getFullName());
//        staffList1 = new StaffList(this);
        
    }
    
    public void changeTab(int index){
        Tabs.setSelectedIndex(index);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bgPanel =  new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                java.awt.GradientPaint gp = new java.awt.GradientPaint(0, 0, colorPrimary, 0, height, colorSecondary);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        rolelbl = new javax.swing.JLabel();
        welcometxt = new javax.swing.JLabel();
        jobMainbtn = new javax.swing.JButton();
        Tabs = new javax.swing.JTabbedPane();
        staffList1 = new Interface.StaffList(this);
        generateReport1 = new Interface.GenerateDocument(this);
        ProfileBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rolelbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        rolelbl.setText("none detected");

        welcometxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        welcometxt.setText("Welcome, ");

        jobMainbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn.setText("button1");
        jobMainbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtnActionPerformed(evt);
            }
        });

        Tabs.setBackground(new java.awt.Color(186, 255, 175));
        Tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Tabs.addTab("Staff List", staffList1);
        Tabs.addTab("Generate Report", generateReport1);

        ProfileBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ProfileBtn.setText("View Profile");
        ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jobMainbtn))
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LogoutBtn)))
                .addGap(31, 31, 31)
                .addComponent(Tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rolelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(ProfileBtn)
                .addGap(21, 21, 21))
            .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(welcometxt)
                    .addContainerGap(572, Short.MAX_VALUE)))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jobMainbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutBtn)
                .addGap(18, 18, 18))
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addComponent(rolelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                        .addComponent(ProfileBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(Tabs)
                .addContainerGap())
            .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(welcometxt)
                    .addContainerGap(338, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobMainbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtnActionPerformed

    }//GEN-LAST:event_jobMainbtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","Confirm Exit", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Logging out.","Exiting", JOptionPane.INFORMATION_MESSAGE);
            Login page = new Login();
            page.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void ProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileBtnActionPerformed
        profilePage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ProfileBtnActionPerformed

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
//            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Mainpage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton ProfileBtn;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JPanel bgPanel;
    private Interface.GenerateDocument generateReport1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jobMainbtn;
    private javax.swing.JLabel rolelbl;
    private Interface.StaffList staffList1;
    private javax.swing.JLabel welcometxt;
    // End of variables declaration//GEN-END:variables
}