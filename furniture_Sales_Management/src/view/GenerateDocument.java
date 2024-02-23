/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.SalesOrder;
import Classes.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author damonng
 */
public class GenerateDocument extends javax.swing.JPanel {
    
    private DefaultTableModel model;
    private MainPage parent;
    private User user;
    private enum DocType{
        productionInvoice,
        salesQuotation,
        workDoneReport, 
        closedSalesReport,
    }
    /**
     * Creates new form generateReport
     */
    public GenerateDocument() {
        initComponents();
    }

    public GenerateDocument(MainPage parent) {
        initComponents();
        this.parent = parent;
        System.out.println(parent.toString());
        model = (DefaultTableModel) DocumentList.getModel();
        LoadData();
    }
    
    // Load data into the table
    public void LoadData(){
        user = parent.user;
        // Reset table content
        model.setRowCount(0);
        for (SalesOrder order : SalesOrder.salesOrders) {
            if (shouldInclude(user.getRole(), user.getId(), order)) {
                Object[] row = new Object[model.getColumnCount()];
                // Fill in the values from the SalesOrder object
                row[0] = order.getId();
                row[1] = order.getFurniture();
                row[2] = order.getQuantity();
                row[3] = order.getTotal();
                row[4] = order.getCustomer();
                row[5] = order.getStatus();
                row[6] = order.getGeneratedBy();
                row[7] = order.getApprovedBy();
                row[8] = order.getQuotation();

                model.addRow(row);
            }
        }
    }
    private boolean shouldInclude(String role, String userId, SalesOrder order){
        String orderApproved = order.getApprovedBy();
        switch(role){
            case "admin"->{return (order.getStatus().equals("Approved"));}
            case "officer"->{return (orderApproved != null && orderApproved.equals(userId) && order.getStatus().equals("Approved"));}
            default->{return false;}
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

        GenerateBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DocumentList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        ReportBtn = new javax.swing.JButton();

        setOpaque(false);

        GenerateBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        GenerateBtn.setText("Open Document");
        GenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBtnActionPerformed(evt);
            }
        });

        DocumentList.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        DocumentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "FurnitureID", "Quantity", "Total", "CustomerID", "Status", "Generated By", "Approved By", "QuotationID"
            }
        ));
        jScrollPane1.setViewportView(DocumentList);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generate Document");

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        SearchBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/search.png"))); // NOI18N
        SearchBtn.setText(" Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        ReportBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ReportBtn.setText("Generate Report");
        ReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(583, 590, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshBtn)
                                .addGap(10, 10, 10)
                                .addComponent(ReportBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GenerateBtn)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn)
                    .addComponent(GenerateBtn)
                    .addComponent(RefreshBtn)
                    .addComponent(ReportBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBtnActionPerformed
        int selectedRow = DocumentList.getSelectedRow();
        Object[] data = new Object[model.getColumnCount()];
        if (selectedRow >= 0){
            for (int i = 0; i < model.getColumnCount(); i++) {
                data[i] = model.getValueAt(selectedRow, i);
            }
            GeneratePDF page = new GeneratePDF(data[4].toString(), parent);
            page.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to Generate PDF!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GenerateBtnActionPerformed

    
    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        String text = SearchTxt.getText();
        if (!text.equals("")) { 
            for (SalesOrder order : SalesOrder.salesOrders) {
                String orderId = order.getId();
                if (shouldInclude(user.getRole(), user.getId(), order) && orderId.equals(text)) {
                    Object[] row = new Object[model.getColumnCount()];
                    // Fill in the values from the SalesOrder object
                    row[0] = order.getId();
                    row[1] = order.getFurniture();
                    row[2] = order.getQuantity();
                    row[3] = order.getTotal();
                    row[4] = order.getCustomer();
                    row[5] = order.getStatus();
                    row[6] = order.getGeneratedBy();
                    row[7] = order.getApprovedBy();
                    row[8] = order.getQuotation();

                    model.addRow(row);
                }
            }
        } else {
            LoadData();
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        LoadData();
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void ReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportBtnActionPerformed
        // TODO add your handling code here:
        GenerateReport page = new GenerateReport(user);
        page.setVisible(true);
    }//GEN-LAST:event_ReportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DocumentList;
    private javax.swing.JButton GenerateBtn;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton ReportBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
