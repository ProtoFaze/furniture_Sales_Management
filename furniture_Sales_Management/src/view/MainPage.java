package view;

import Classes.Admin;
import Classes.Customer;
import Classes.File;
import Classes.Invoice;
import Classes.SalesOrder;
import Classes.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JFrame;
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
    Color colorPrimary, colorSecondary;
    
    private static List<User> users;
    private static List<Admin> admins;
    private static List<SalesOrder> salesOrders;
    private static List<Customer> customers;
    private static List<Invoice> invoices;
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
        loadData();
    }

    private void loadData(){
        welcometxt.setText("Welcome " + user.getFullName());
        switch (this.user.getRole()){
            case "admin" -> {
                users = User.list;
                invoices = null;
                customers = null;
                salesOrders = null;
                Tabs.remove(personalSales);personalSales = null;
                Tabs.remove(createSalesOrder);createSalesOrder = null;
                Tabs.remove(modifySalesOrder);modifySalesOrder = null;
                Tabs.remove(createQuotation);createQuotation = null;
                Tabs.remove(deleteQuotation);deleteQuotation = null;
                Tabs.remove(furnitureList);furnitureList = null;
                Tabs.remove(officerApproval);officerApproval = null;
                jobMainbtn1.setText("Staff List");
                jobMainbtn2.setText("Generate Report");
                jobMainbtn3.setVisible(false);
                jobMainbtn4.setVisible(false);
                jobMainbtn5.setVisible(false);
            }
            case "officer" -> {
                invoices = Invoice.list;
                jobMainbtn1.setText("Pending Sales");
                jobMainbtn2.setText("Generate Documents");
                jobMainbtn3.setVisible(false);
                jobMainbtn4.setVisible(false);
                jobMainbtn5.setVisible(false);
                changeTab("officerApproval");
            }
            case "sales person" -> {
                salesOrders = SalesOrder.salesOrders;
                customers = Customer.list;
                invoices = Invoice.list;
                jobMainbtn1.setText("Sales List");
                jobMainbtn2.setText("Create Sales");
                jobMainbtn3.setText("Create Quotation");
                jobMainbtn4.setText("Modify");
                jobMainbtn5.setText("Delete Quotation");
                Tabs.remove(officerApproval);
                Tabs.remove(generateReport);
                officerApproval = null;
                generateReport = null; 
            }
            default -> {
                users = null;
                admins = null;
                salesOrders = null;
                customers = null;
                invoices = null;
                Tabs = null;
            }
        }
        
    }
    
    public void changeTab(String ComponentName){
        CardLayout cardLayout = (CardLayout) Tabs.getLayout();
        cardLayout.show(Tabs, ComponentName);
    }
    public void updateData(){
        File.write("user", User.list);
        User.populateList();
        if(!user.getRole().equals("admin")){
            File.write("customer",Customer.list);
            Customer.populateList();
            File.write("salesOrder", SalesOrder.salesOrders);
            SalesOrder.populateList();
            File.write("invoice", Invoice.list);
            Invoice.populateList();
        }
        switch (user.getRole()){
            case "admin"-> {
                peopleList.loadData();
            }
            case "officer"->{
                officerApproval.LoadData();
                generateReport.LoadData();
            }
            case "sales person"->{
                personalSales.LoadData();
                createSalesOrder.LoadData();
                createQuotation.LoadData();
                modifySalesOrder.LoadData();
                deleteQuotation.LoadData();                
            }
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
        welcometxt = new javax.swing.JLabel();
        ProfileBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jobMainbtn1 = new javax.swing.JButton();
        jobMainbtn2 = new javax.swing.JButton();
        jobMainbtn3 = new javax.swing.JButton();
        jobMainbtn4 = new javax.swing.JButton();
        jobMainbtn5 = new javax.swing.JButton();
        Tabs = new javax.swing.JPanel();
        personalSales = new view.PersonalSales(this);
        createSalesOrder = new view.CreateSalesOrder(this);
        modifySalesOrder = new view.ModifySalesOrder(this);
        peopleList = new view.PersonList(this);
        generateReport = new view.GenerateDocument(this);
        officerApproval = new view.OfficerApproval(this);
        furnitureList = new view.FurnitureList(this);
        createQuotation = new view.CreateQuotation(this);
        deleteQuotation = new view.DeleteQuotation(this);

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

        welcometxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        welcometxt.setText("Welcome, ");

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

        lblTitle.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo_small.png"))); // NOI18N
        lblTitle.setText("YOYO Sales Helper");
        lblTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleMouseClicked(evt);
            }
        });

        jobMainbtn1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn1.setText("func1");
        jobMainbtn1.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn1ActionPerformed(evt);
            }
        });

        jobMainbtn2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn2.setText("func2");
        jobMainbtn2.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn2ActionPerformed(evt);
            }
        });

        jobMainbtn3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn3.setText("func3");
        jobMainbtn3.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn3ActionPerformed(evt);
            }
        });

        jobMainbtn4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn4.setText("func4");
        jobMainbtn4.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn4ActionPerformed(evt);
            }
        });

        jobMainbtn5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jobMainbtn5.setText("func5");
        jobMainbtn5.setPreferredSize(new java.awt.Dimension(120, 30));
        jobMainbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobMainbtn5ActionPerformed(evt);
            }
        });

        Tabs.setOpaque(false);
        Tabs.setLayout(new java.awt.CardLayout());
        Tabs.add(personalSales, "personalSales");
        Tabs.add(createSalesOrder, "createSalesOrder");
        Tabs.add(modifySalesOrder, "modifySalesOrder");
        Tabs.add(peopleList, "peopleList");
        Tabs.add(generateReport, "generateReport");
        Tabs.add(officerApproval, "officerApproval");
        Tabs.add(furnitureList, "furnitureList");
        Tabs.add(createQuotation, "createQuotation");
        Tabs.add(deleteQuotation, "deleteQuotation");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProfileBtn)
                        .addContainerGap())
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jobMainbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jobMainbtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(Tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(welcometxt)
                    .addComponent(ProfileBtn))
                .addGap(0, 0, 0)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addComponent(jobMainbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jobMainbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoutBtn))
                    .addComponent(Tabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jobMainbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn1ActionPerformed
        System.out.println(user.getRole());
        switch(user.getRole()){
            case "admin"->{changeTab("peopleList");}
            case "officer"->{changeTab("officerApproval");}
            case "sales person"->{changeTab("personalSales");}
            default->{
            }
        }
    }//GEN-LAST:event_jobMainbtn1ActionPerformed

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

    private void jobMainbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn2ActionPerformed
        switch(user.getRole()){
            case "admin"->{changeTab("generateReport");}
            case "officer"->{changeTab("generateReport");}
            case "sales person"->{changeTab("createSalesOrder");}
            default->{}
        }
    }//GEN-LAST:event_jobMainbtn2ActionPerformed

    private void jobMainbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn3ActionPerformed
        switch(user.getRole()){
            case "admin"->{changeTab("generateReport");}
            case "officer"->{changeTab("generateReport");}
            case "sales person"->{changeTab("createQuotation");}
            default->{}
        }
    }//GEN-LAST:event_jobMainbtn3ActionPerformed

    private void jobMainbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn4ActionPerformed
        switch(user.getRole()){
            case "admin"->{changeTab("generateReport");}
            case "officer"->{changeTab("generateReport");}
            case "sales person"->{changeTab("modifySalesOrder");}
            default->{}
        }
    }//GEN-LAST:event_jobMainbtn4ActionPerformed

    private void jobMainbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobMainbtn5ActionPerformed
        switch(user.getRole()){
            case "admin"->{changeTab("generateReport");}
            case "officer"->{changeTab("generateReport");}
            case "sales person"->{changeTab("deleteQuotation");}
            default->{}
        }
    }//GEN-LAST:event_jobMainbtn5ActionPerformed

    private void lblTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMouseClicked
        switch(user.getRole()){
            case "admin"->{changeTab("peopleList");}
            case "officer"->{changeTab("officerApproval");}
            case "sales person"->{changeTab("personalSales");}
            default->{}
        }
    }//GEN-LAST:event_lblTitleMouseClicked

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
    private javax.swing.JPanel Tabs;
    private javax.swing.JPanel bgPanel;
    view.CreateQuotation createQuotation;
    view.CreateSalesOrder createSalesOrder;
    private view.DeleteQuotation deleteQuotation;
    private view.FurnitureList furnitureList;
    private view.GenerateDocument generateReport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jobMainbtn1;
    private javax.swing.JButton jobMainbtn2;
    private javax.swing.JButton jobMainbtn3;
    private javax.swing.JButton jobMainbtn4;
    private javax.swing.JButton jobMainbtn5;
    private javax.swing.JLabel lblTitle;
    private view.ModifySalesOrder modifySalesOrder;
    private view.OfficerApproval officerApproval;
    view.PersonList peopleList;
    private view.PersonalSales personalSales;
    private javax.swing.JLabel welcometxt;
    // End of variables declaration//GEN-END:variables
}