/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.File;
import Classes.Furniture;
import Classes.SalesOrder;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class ModifySalesOrder extends javax.swing.JPanel {
    MainPage parent;
    int quantity;
    double price;
    double totalPrice = 0.0;
    private SalesOrder selectedOrder;  // To store the details of the selected order
    private String quotationID;

    /**
     * Creates new form ModifySalesOrder
     */
    public ModifySalesOrder() {
        initComponents();
    }
    public ModifySalesOrder(MainPage parent){
        initComponents();
        this.parent = parent;
        LoadData();
        loadSalesOrders(quotationID);
        tfFurnitureID.setEnabled(false);
        tfTotalPrice.setEnabled(false);
    }

    void LoadData(){
        List<String> idList = new ArrayList<>();
            for (SalesOrder salesOrder: SalesOrder.salesOrders){
                quotationID = salesOrder.getQuotation();
                if(SalesOrder.isMyQuotation(quotationID, parent.user.getId())){
                    if (quotationID != null && !idList.contains(quotationID)) {
                        idList.add(quotationID);
                    }
                }
            }
        DefaultComboBoxModel data = new DefaultComboBoxModel<>(idList.toArray(new String [0]));
        cbQuotationID.setModel(data);   
    }
    
    private void loadSalesOrders(String quotationID) {
        DefaultComboBoxModel<String> salesOrderModel = new DefaultComboBoxModel<>();

        for (SalesOrder salesOrder : SalesOrder.salesOrders) {
            if (salesOrder.getGeneratedBy().equals(parent.user.getId())&&
                salesOrder.getQuotation().equals(quotationID) 
                    && ("Pending".equalsIgnoreCase(salesOrder.getStatus()) ||
                    "Approve".equalsIgnoreCase(salesOrder.getStatus()))
                ) {
                salesOrderModel.addElement(salesOrder.getId());
            }
        }

        cbSalesOrderID.setModel(salesOrderModel);
    }
   
    public void updateTable(String quotationID) {
        // Update the table display to show only sales orders with "Approve" or "Pending" status
        DefaultTableModel model = (DefaultTableModel) tblQuotation.getModel();
        model.setRowCount(0); // Clear existing data in the table

        totalPrice = 0.0;
        for (SalesOrder sales : SalesOrder.salesOrders) {
            if (sales.getGeneratedBy().equals(parent.user.getId())&&
                sales.getQuotation().equals(quotationID) && 
                    ("Approve".equals(sales.getStatus()) || 
                    "Pending".equals(sales.getStatus()))
                ) {
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
                        sales.getStatus()
                    };
                    model.addRow(rowData);
                    // Update total price
                    totalPrice += sales.getTotal();
                }
            }
        }

        // If no records found for the given quotation ID and status
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No records found for the given quotation ID and status", "Not Found", JOptionPane.INFORMATION_MESSAGE);
        }
        tfTotalPrice.setText(String.valueOf(totalPrice));
    }
    
    
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
    
    private void updateSelectedOrder() {
        if (selectedOrder != null) {
            // Retrieve modified data
            String furniture = tfFurnitureID.getText();
            int quantity = (int) tfQuantity.getValue();
            double total = Double.parseDouble(tfTotal.getText());

            // Update the selected order details
            selectedOrder.setFurniture(furniture);
            selectedOrder.setQuantity(quantity);
            selectedOrder.setTotal(total);
            selectedOrder.setStatus("Pending");
        }
    }
    
    private void calculateTotal(){
        tfTotal.setText(Double.toString(price*quantity));
    }
     
    private SalesOrder getSelectedSalesOrder(String selectedSalesOrderID) {
        for (SalesOrder salesOrder : SalesOrder.salesOrders) {
            if (salesOrder.getId().equals(selectedSalesOrderID)) {
                return salesOrder;
            }
        }
        return null;
    }

    private void displaySalesOrderDetails(SalesOrder salesOrder) {
        tfFurnitureID.setText(salesOrder.getFurniture());
        tfQuantity.setValue(salesOrder.getQuantity());
        tfTotal.setText(Double.toString(salesOrder.getTotal()));
        Furniture matchingFurniture = findFurnitureById(salesOrder.getFurniture());
        if (matchingFurniture != null) {
            price = matchingFurniture.getPrice();
        }
        calculateTotal();
    }

    private void clearOrderDetails() {
        tfFurnitureID.setText("");
        tfQuantity.setValue(0);
        tfTotal.setText("");
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
        lblFurnitureID = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        tfStatus = new javax.swing.JLabel();
        quotationScrollPane = new javax.swing.JScrollPane();
        tblQuotation = new javax.swing.JTable();
        btnSaveChanges = new javax.swing.JButton();
        tfQuantity = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        btnBack = new javax.swing.JButton();
        lblQuotationID = new javax.swing.JLabel();
        cbQuotationID = new javax.swing.JComboBox<>();
        tfTotalPrice = new javax.swing.JTextField();
        lblGrandTotal = new javax.swing.JLabel();
        tfFurnitureID = new javax.swing.JTextField();
        lblSalesOrderID = new javax.swing.JLabel();
        cbSalesOrderID = new javax.swing.JComboBox<>();

        setOpaque(false);

        lblTitle.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("VIEW/EDIT SALES ORDER QUOTATION");

        lblFurnitureID.setText("FURNITURE ID");

        lblQuantity.setText("QUANTITY");

        lblTotal.setText("TOTAL");

        lblStatus.setText("STATUS");

        tfStatus.setText("WAITING FOR APPROVAL");

        tblQuotation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDER ID", "FURNITURE ID", "QUANTITY", "UNIT PRICE", "TOTAL COST", "CUSTOMER ID", "STATUS"
            }
        ));
        quotationScrollPane.setViewportView(tblQuotation);

        btnSaveChanges.setText("SAVE CHANGES");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        tfQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tfQuantityStateChanged(evt);
            }
        });

        btnBack.setText("BACK");

        lblQuotationID.setText("QUOTATION ID");

        cbQuotationID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbQuotationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuotationIDActionPerformed(evt);
            }
        });

        tfTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalPriceActionPerformed(evt);
            }
        });

        lblGrandTotal.setText("TOTAL PRICE");

        tfFurnitureID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFurnitureIDActionPerformed(evt);
            }
        });

        lblSalesOrderID.setText("ORDER ID");

        cbSalesOrderID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSalesOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSalesOrderIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFurnitureID)
                    .addComponent(lblQuantity)
                    .addComponent(lblStatus)
                    .addComponent(lblTotal)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalesOrderID)
                    .addComponent(lblQuotationID))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbQuotationID, 0, 162, Short.MAX_VALUE)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSalesOrderID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFurnitureID)
                    .addComponent(tfQuantity)
                    .addComponent(tfTotal)
                    .addComponent(tfStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quotationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblGrandTotal)
                        .addGap(18, 18, 18)
                        .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQuotationID)
                            .addComponent(cbQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalesOrderID)
                            .addComponent(cbSalesOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFurnitureID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFurnitureID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantity)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quotationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSaveChanges)
                                .addComponent(btnBack))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblGrandTotal))))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tfQuantityStateChanged
         quantity = (int)tfQuantity.getValue();
        // Ensure the quantity is not negative
        if (quantity < 1) {
        // If negative, set the quantity to 0
        tfQuantity.setValue(1);
    }
        calculateTotal();                
    }//GEN-LAST:event_tfQuantityStateChanged
    private boolean validateInput() {
    // Validate tfFurnitureID
    String furnitureIDText = tfFurnitureID.getText().trim();
    if (furnitureIDText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Furniture ID cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    //Validate Order ID
    String orderID = cbSalesOrderID.getSelectedItem().toString();
    if (orderID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Order ID cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Validate tfQuantity
    if (tfQuantity.getValue() == null) {
        JOptionPane.showMessageDialog(this, "Quantity cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    int quantity = (int) tfQuantity.getValue();
    if (quantity <= 0) {
        JOptionPane.showMessageDialog(this, "Quantity must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validate tfTotal
    String totalText = tfTotal.getText().trim();
    if (totalText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Total cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}
    private void clearAllFields() {
        tfFurnitureID.setText(" ");
        tfQuantity.setValue(1);
        tfTotal.setText("");
    }
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        if (!validateInput()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedOrder == null) {
            JOptionPane.showMessageDialog(this, "Please select a sales order to modify", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check if the total price matches the calculated price
        double calculatedPrice = price * quantity;
        double enteredTotal = Double.parseDouble(tfTotal.getText());
        if (calculatedPrice != enteredTotal) {
         JOptionPane.showMessageDialog(this, "Total price does not match the calculated price. Please check your entries.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        //update the selected order
        updateSelectedOrder();
        // Save the changes to file
        File.write("salesOrder", SalesOrder.salesOrders);

        JOptionPane.showMessageDialog(this, "Changes saved successfully!");

        // Reload the table to reflect the changes
        loadSalesOrders(quotationID);
        updateTable(cbQuotationID.getSelectedItem().toString());
        
        //Clear Fields
        clearAllFields();
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void tfTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalPriceActionPerformed

    private void cbQuotationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuotationIDActionPerformed
        // Retrieve the selected quotation ID from the combo box
        String selectedQuotationID = cbQuotationID.getSelectedItem().toString();
        // Load sales orders corresponding to the selected quotation ID
        loadSalesOrders(selectedQuotationID);
        // Update the table display to show only sales orders for the selected quotation ID
        updateTable(selectedQuotationID);
    }//GEN-LAST:event_cbQuotationIDActionPerformed

    private void cbSalesOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSalesOrderIDActionPerformed
        String selectedSalesOrderID = cbSalesOrderID.getSelectedItem().toString();
        selectedOrder = getSelectedSalesOrder(selectedSalesOrderID);

        if (selectedOrder != null) {
        // Display details of the selected sales order in the UI
           displaySalesOrderDetails(selectedOrder);
        } else {
        // Clear the UI if no sales order is selected
          clearOrderDetails();
        }
    }//GEN-LAST:event_cbSalesOrderIDActionPerformed

    private void tfFurnitureIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFurnitureIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFurnitureIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> cbQuotationID;
    private javax.swing.JComboBox<String> cbSalesOrderID;
    private javax.swing.JLabel lblFurnitureID;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuotationID;
    private javax.swing.JLabel lblSalesOrderID;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JScrollPane quotationScrollPane;
    private javax.swing.JTable tblQuotation;
    private javax.swing.JTextField tfFurnitureID;
    private javax.swing.JSpinner tfQuantity;
    private javax.swing.JLabel tfStatus;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTotalPrice;
    // End of variables declaration//GEN-END:variables
}
