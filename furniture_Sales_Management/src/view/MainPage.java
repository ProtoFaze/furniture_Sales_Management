package view;

import Classes.Admin;
import Classes.SalesOrder;
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
    private static List<SalesOrder> salesOrders;
    
    /**
     * Creates new form MainPage
     * @param user
     */
    public MainPage(User user) {

        this.user = user;
        String roleLblText;
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
        switch (this.user.getRole()){
            case "admin" -> {
                users = User.list;
            }
            case "officer" -> {
                
            }
            case "sales person" -> {
               salesOrders = SalesOrder.salesOrders;
               

            }
            default -> {
                users = null;
                admins = null;
                salesOrders = null;
            }
        }
        
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
        PeopleList = new view.PersonList(this);
        generateReport = new view.GenerateDocument(this);
        salesOrderPage = new view.SalesOrderPage(this);
        searchSalesOrder = new view.SearchSalesOrder(this);
        createSalesOrder = new view.CreateSalesOrder(this);
        deleteSalesOrder = new view.DeleteSalesOrder(this);
        modifySalesOrder = new view.ModifySalesOrder(this);
        personalSales = new view.PersonalSales(this);
        ProfileBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jobMainbtn1 = new javax.swing.JButton();
        jobMainbtn2 = new javax.swing.JButton();
        jobMainbtn3 = new javax.swing.JButton();
        jobMainbtn4 = new javax.swing.JButton();

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
        jobMainbtn.setText("func1");
        jobMainbtn.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn.setSize(new java.awt.Dimension(120, 30));
        jobMainbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtnActionPerformed(evt);
            }
        });

        Tabs.setBackground(new java.awt.Color(186, 255, 175));
        Tabs.addTab("Staff List", PeopleList);
        Tabs.addTab("Generate Report", generateReport);
        Tabs.addTab("Sales Order", salesOrderPage);
        Tabs.addTab("Search Sales", searchSalesOrder);
        Tabs.addTab("Create Sales", createSalesOrder);
        Tabs.addTab("Delete Sales", deleteSalesOrder);
        Tabs.addTab("Edit Sales", modifySalesOrder);
        Tabs.addTab("Sales List", personalSales);

        ProfileBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ProfileBtn.setText("View Profile");
        ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.setSize(new java.awt.Dimension(120, 30));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo_small.png"))); // NOI18N
        lblTitle.setText("YOYO Sales Helper");

        jobMainbtn1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn1.setText("func2");
        jobMainbtn1.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn1.setSize(new java.awt.Dimension(120, 30));
        jobMainbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn1ActionPerformed(evt);
            }
        });

        jobMainbtn2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn2.setText("func3");
        jobMainbtn2.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn2.setSize(new java.awt.Dimension(120, 30));
        jobMainbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn2ActionPerformed(evt);
            }
        });

        jobMainbtn3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn3.setText("func4");
        jobMainbtn3.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn3.setSize(new java.awt.Dimension(120, 30));
        jobMainbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn3ActionPerformed(evt);
            }
        });

        jobMainbtn4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn4.setText("func5");
        jobMainbtn4.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn4.setSize(new java.awt.Dimension(120, 30));
        jobMainbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(89, 89, 89)
                        .addComponent(welcometxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addComponent(rolelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(ProfileBtn))
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jobMainbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(Tabs)))
                .addContainerGap())
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(welcometxt)
                    .addComponent(rolelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfileBtn))
                .addGap(16, 16, 16)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addComponent(jobMainbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(LogoutBtn))
                    .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void jobMainbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobMainbtn1ActionPerformed

    private void jobMainbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobMainbtn2ActionPerformed

    private void jobMainbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobMainbtn3ActionPerformed

    private void jobMainbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobMainbtn4ActionPerformed

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
    view.PersonList PeopleList;
    private javax.swing.JButton ProfileBtn;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JPanel bgPanel;
    view.CreateSalesOrder createSalesOrder;
    private view.DeleteSalesOrder deleteSalesOrder;
    private view.GenerateDocument generateReport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jobMainbtn;
    private javax.swing.JButton jobMainbtn1;
    private javax.swing.JButton jobMainbtn2;
    private javax.swing.JButton jobMainbtn3;
    private javax.swing.JButton jobMainbtn4;
    private javax.swing.JLabel lblTitle;
    private view.ModifySalesOrder modifySalesOrder;
    private view.PersonalSales personalSales;
    private javax.swing.JLabel rolelbl;
    private view.SalesOrderPage salesOrderPage;
    private view.SearchSalesOrder searchSalesOrder;
    private javax.swing.JLabel welcometxt;
    // End of variables declaration//GEN-END:variables
}