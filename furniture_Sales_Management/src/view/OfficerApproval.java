/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.SalesOrder;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Liang
 */
public class OfficerApproval extends javax.swing.JPanel {
    MainPage parent;
    private DefaultTableModel model;
    /**
     * Creates new form OfficerApproval
     */
    public OfficerApproval() {
        initComponents(); 

    }
    
    public OfficerApproval(MainPage parent) {
        this.parent = parent;
        initComponents();
        model = (DefaultTableModel) QuotationList.getModel();
        LoadData();
         
    }

    private void showQuotations(String filter) {
        model.setRowCount(0); // Clear existing rows

        // Iterate through the salesOrders list and add rows for matching salesperson ID
        for (SalesOrder order : SalesOrder.salesOrders) {
            String orderStatus = order.getStatus();
            if (orderStatus != null && filter.equals("Show all")) {
                Object[] row = new Object[model.getColumnCount()];
                // Fill in the values from the SalesOrder object
                row[0] = order.getId();
                row[1] = order.getFurniture();
                row[2] = order.getQuantity();
                row[3] = order.getTotal();
                row[4] = order.getStatus();
                row[5] = order.getQuotation();

                model.addRow(row);
                // Add a null check for getSalesPersonId()
            } else if (orderStatus != null && orderStatus.equals(filter)) {
                Object[] row = new Object[model.getColumnCount()];
                // Fill in the values from the SalesOrder object
                row[0] = order.getId();
                row[1] = order.getFurniture();
                row[2] = order.getQuantity();
                row[3] = order.getTotal();
                row[4] = order.getStatus();
                row[5] = order.getQuotation();

                // Add the row to the table model
                model.addRow(row);
            }     
        }
    }
    
    public void LoadData() {
        showQuotations("Show all");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        QuotationList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        FilterCmb = new javax.swing.JComboBox<>();
        ApproveBtn = new javax.swing.JButton();
        RejectBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();

        setOpaque(false);

        QuotationList.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        QuotationList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "FurnitureID", "Quantity", "Total Price", "Status", "QuotationID"
            }
        ));
        jScrollPane1.setViewportView(QuotationList);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quotation List");

        FilterCmb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        FilterCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show all", "Pending", "Approved", "Rejected" }));
        FilterCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterCmbActionPerformed(evt);
            }
        });

        ApproveBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ApproveBtn.setText("Approve");
        ApproveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveBtnActionPerformed(evt);
            }
        });

        RejectBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RejectBtn.setText("Reject");
        RejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RefreshBtn)
                        .addGap(18, 18, 18)
                        .addComponent(RejectBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ApproveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(FilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApproveBtn)
                    .addComponent(RejectBtn)
                    .addComponent(RefreshBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        LoadData();
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void FilterCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterCmbActionPerformed
        showQuotations(String.valueOf(FilterCmb.getSelectedItem()));
    }//GEN-LAST:event_FilterCmbActionPerformed

    private void RejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectBtnActionPerformed
        // TODO add your handling code here:
        updateStatus("Rejected");
    }//GEN-LAST:event_RejectBtnActionPerformed

    private void ApproveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveBtnActionPerformed
        // TODO add your handling code here:
        updateStatus("Approved");
    }//GEN-LAST:event_ApproveBtnActionPerformed
    
    private void updateStatus(String Status){
        if (QuotationList.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Row", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            saveChanges(String.valueOf(QuotationList.getValueAt(QuotationList.getSelectedRow(), 0)), Status);
            JOptionPane.showMessageDialog(null, "Quotation " + Status, Status, JOptionPane.INFORMATION_MESSAGE);
            LoadData();
        }
    }
    
    private void saveChanges(String ID, String Status){
        for (SalesOrder record:SalesOrder.salesOrders){
            if(ID.equals(record.getId())){
                record.setStatus(Status);
                record.setApprovedBy(parent.user.getId());
            }
        }
        parent.updateData();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApproveBtn;
    private javax.swing.JComboBox<String> FilterCmb;
    private javax.swing.JTable QuotationList;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton RejectBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
