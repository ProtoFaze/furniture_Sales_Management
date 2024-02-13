/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.File;
import Classes.Furniture;
import Classes.Invoice;
import Classes.SalesOrder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class CreateQuotation1 extends javax.swing.JPanel {
    double price;
    double grandTotal = 0.0;
    MainPage parent;
    private DefaultTableModel temp; 
    /**
     * Creates new form CreateQuotation1
     */
    public CreateQuotation1() {
        initComponents();
    }
    public CreateQuotation1(MainPage parent) {
        initComponents();
        this.parent = parent;
        tfTotalPrice.setEnabled(false);
        tfQuotationID.setEnabled(false);
        LoadData();
    }
// Update the combo box model
    private void updateComboBox(){
        LoadData();
    }
    void LoadData() {
        List<String> idList = new ArrayList<>();
        for (SalesOrder salesOrder : SalesOrder.salesOrders) {
            String quotationID = salesOrder.getquotation();
            if (quotationID != null && !idList.contains(quotationID)) {
                idList.add(quotationID);
            }
        }
        DefaultComboBoxModel data = new DefaultComboBoxModel<>(idList.toArray(new String[0]));
        cbQuotationID.setModel(data);
//        updateTable();
    }
    void updateTable(String quotationID) {
        DefaultTableModel model = (DefaultTableModel) tblQuotation.getModel();
        model.setRowCount(0); // Clear existing data in the table

        grandTotal = 0.0;
        for (SalesOrder sales : SalesOrder.salesOrders) {
            if (sales.getquotation().equals(quotationID)) {
                // Retrieve the furniture object associated with the furniture ID
                Furniture matchingFurniture = findFurnitureById(sales.getFurniture());

                if (matchingFurniture != null) {
                    // Add details to the table, including the unit price
                    Object[] rowData = {
                            sales.getId(),
                            sales.getFurniture(),
                            sales.getQuantity(),
                            matchingFurniture.getPrice(), // Display unit price
                            sales.getTotal(),
                            sales.getCustomer(),
                    };
                    model.addRow(rowData);
                    //Update total price
                    grandTotal += sales.getTotal();
                }                
            }
        }

        // If no records found for the given quotation ID
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No records found for the given quotation ID", "Not Found", JOptionPane.INFORMATION_MESSAGE);
        }
        tfTotalPrice.setText(String.valueOf(grandTotal));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuotation = new javax.swing.JTable();
        tfTotalPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        cbQuotationID = new javax.swing.JComboBox<>();
        tfQuotationID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setOpaque(false);

        lblTitle.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUOTATION");

        tblQuotation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ORDER ID", "FURNITURE ID", "QUANTITY", "UNIT PRICE", "TOTAL COST", "CUSTOMER ID"
            }
        ));
        jScrollPane1.setViewportView(tblQuotation);
        if (tblQuotation.getColumnModel().getColumnCount() > 0) {
            tblQuotation.getColumnModel().getColumn(0).setResizable(false);
            tblQuotation.getColumnModel().getColumn(4).setResizable(false);
        }

        tfTotalPrice.setEnabled(false);
        tfTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalPriceActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL PRICE");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        cbQuotationID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbQuotationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuotationIDActionPerformed(evt);
            }
        });

        tfQuotationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuotationIDActionPerformed(evt);
            }
        });

        jLabel3.setText("QUOTATION ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCreate)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
           // TODO add your handling code here:
    String selectedQuotationID = cbQuotationID.getSelectedItem().toString();

        // Check if the selectedQuotationID is not empty
        if (!selectedQuotationID.isEmpty()) {
            boolean invoiceExist = false;
            for (Invoice invoice: Invoice.list){
                if (invoice.getId().equals(selectedQuotationID)){
                    invoiceExist = true;
                    break;
                }
            }
            
            if (!invoiceExist){
                Invoice.list.add(new Invoice(selectedQuotationID, grandTotal));
            }
            parent.updateData();
            JOptionPane.showMessageDialog(this, "Quotation Created!");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Quotation ID", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbQuotationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuotationIDActionPerformed
    String selectedQuotationID = cbQuotationID.getSelectedItem().toString();
    tfQuotationID.setText(selectedQuotationID);
    btnCreate.setEnabled(true);
    updateTable(selectedQuotationID);

    
    }//GEN-LAST:event_cbQuotationIDActionPerformed

    private void tfTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalPriceActionPerformed

    private void tfQuotationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuotationIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuotationIDActionPerformed

private Furniture findFurnitureById(String furnitureId) {
    // Iterate through the list of furniture objects
    for (Furniture furniture : Furniture.list) {
        // Check if the current furniture object's ID matches the specified ID
        if (furniture.getId().equals(furnitureId)) {
            // Return the matching furniture object
            return furniture;
        }
    }
    // Return null if no matching furniture is found
    return null;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    javax.swing.JComboBox<String> cbQuotationID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblQuotation;
    private javax.swing.JTextField tfQuotationID;
    private javax.swing.JTextField tfTotalPrice;
    // End of variables declaration//GEN-END:variables
}
