/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import Classes.File;
import Classes.Furniture;
import Classes.Invoice;
import Classes.SalesOrder;
import Classes.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Aryssa
 */
public class CreateSalesOrder extends javax.swing.JPanel {
    DefaultTableModel model;
    int quantity;
    double price;
    
    MainPage parent;
    /**
     * Creates new form CreateSalesOrder1
     */
    //private SalesOrder salesOrder;
    
    public CreateSalesOrder() {
        initComponents();
       
    }
    public CreateSalesOrder(MainPage parent) {
        this.parent = parent;
        initComponents();        
        LoadData();
        cbFurniture.setEnabled(false);
        tfCustomer.setEnabled(false);  
        tfQuotationID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleQuotationIDChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleQuotationIDChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleQuotationIDChange();
            }
        });
    }
    
    private void LoadData(){
        List<String> idList = new ArrayList<>();
        for (Furniture furniture: Furniture.list){
            idList.add(furniture.getId());
        }
        model = (DefaultTableModel) tblQuotation.getModel();
       
    }
    private boolean quotationExists(String quotationID) {
        // Iterate through the list of sales orders
        for (SalesOrder order : SalesOrder.salesOrders) {
            // Check if the current sales order's quotation ID matches the specified ID
            if (order.getquotation() != null && order.getquotation().equals(quotationID)) {
                return true; // Quotation ID exists
            }
        }
        return false; // Quotation ID does not exist
    }
    private boolean validateCustomerForQuotation(String customerID, String quotationID) {
        // Iterate through the list of sales orders
        for (SalesOrder order : SalesOrder.salesOrders) {
            // Check if the current sales order's quotation ID matches the specified ID
            if (order.getquotation() != null && order.getquotation().equals(quotationID)) {
                // Check if the customer ID matches
                if (!order.getCustomer().equals(customerID)) {
                    return false; // Customer ID does not match for the same quotation number
                }
            }
        }
        return true; // Customer ID matches for the same quotation number
    }
    private boolean validateInput() {
        try {
       //     int quantity = Integer.parseInt(tfQuantity.getText());
            double total = Double.parseDouble(tfTotal.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void calculateTotal(){
       // Get the selected furniture ID
       String furnitureID = cbFurniture.getText();

       // Find the corresponding Furniture object
       Furniture selectedFurniture = null;
       for (Furniture record : Furniture.list) {
           if (record.getId().equals(furnitureID)) {
               selectedFurniture = record;
               break;
                }
        }

       // Calculate the total based on the quantity and furniture price
       if (selectedFurniture != null) {
           quantity = (int) tfQuantity.getValue();
           price = selectedFurniture.getPrice();
           tfTotal.setText(Double.toString(price * quantity));
        }
    }
    private String getCustomerID(String quotationID) {
        // Iterate through the list of sales orders
        for (SalesOrder order : SalesOrder.salesOrders) {
            // Check if the current sales order's quotation ID matches the specified ID
            if (order.getquotation() != null && order.getquotation().equals(quotationID)) {
                // Return the customer ID associated with the quotation number
                return order.getCustomer();
            }
        }
        // Return an empty string or handle the case when the quotation ID is not found
        return "";
    }
    private void handleQuotationIDChange() {
        String quotationID = tfQuotationID.getText();
        // Check if the quotation number exists in the text file
        if (quotationExists(quotationID)) {
            String customerID = getCustomerID(quotationID);

            // Display the customer ID
            tfCustomer.setText(customerID);
            // Disable the tfCustomer field if the quotation number exists
            tfCustomer.setEnabled(false);
            // Disable the btnCustomerList and btnRegisterCustomer buttons
            btnCustomerList.setEnabled(false);
            btnRegisterCustomer.setEnabled(false);
            model.setRowCount(0);
            for (SalesOrder record: SalesOrder.salesOrders){
                String[] row = new String[7];
                if(record.getquotation().equals(quotationID))
                    model.addRow(new Object[]{  record.getId(),
                                                record.getFurniture(), 
                                                record.getQuantity(),
                                                record.getTotal(),
                                                record.getCustomer(), 
                                                record.getStatus(), 
                                                record.getquotation()});
            }
        } else {
        // Enable the tfCustomer field if the quotation number doesn't exist
        tfCustomer.setEnabled(true);
        // Enable the btnCustomerList and btnRegisterCustomer buttons
        btnCustomerList.setEnabled(true);
        btnRegisterCustomer.setEnabled(true);
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

        lblcreate = new javax.swing.JLabel();
        lblFurnitureID = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        lblCustomer = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        tfCustomer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuotation = new javax.swing.JTable();
        lblQuotation = new javax.swing.JLabel();
        btnRegisterCustomer = new javax.swing.JButton();
        btnCustomerList = new javax.swing.JButton();
        cbFurniture = new javax.swing.JTextField();
        btnFurnitureChoose = new javax.swing.JButton();
        lblQuotationID = new javax.swing.JLabel();
        tfQuotationID = new javax.swing.JTextField();

        setOpaque(false);

        lblcreate.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblcreate.setText("CREATE SALES ORDER ");

        lblFurnitureID.setText("FURNITURE ID");

        lblQuantity.setText("QUANTITY");

        lblTotal.setText("TOTAL");

        tfTotal.setMaximumSize(new java.awt.Dimension(240, 30));
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        btnCreate.setText("CREATE ");
        btnCreate.setMaximumSize(new java.awt.Dimension(360, 30));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblCustomer.setText("CUSTOMER ID ");

        lblStatus.setText("STATUS");

        tfCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCustomerActionPerformed(evt);
            }
        });

        jLabel1.setText("WAITING FOR APPROVAL");

        tfQuantity.setMaximumSize(new java.awt.Dimension(240, 30));
        tfQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tfQuantityStateChanged(evt);
            }
        });

        btnBack.setText("BACK");

        tblQuotation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDER ID", "FURNITURE ID", "QUANTITY", "TOTAL", "CUSTOMER", "STATUS", "QUOTATION ID"
            }
        ));
        jScrollPane1.setViewportView(tblQuotation);

        lblQuotation.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblQuotation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuotation.setText("SALES ORDER ");

        btnRegisterCustomer.setText("new");
        btnRegisterCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCustomerActionPerformed(evt);
            }
        });

        btnCustomerList.setText("choose");
        btnCustomerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerListActionPerformed(evt);
            }
        });

        cbFurniture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFurnitureActionPerformed(evt);
            }
        });

        btnFurnitureChoose.setText("choose");
        btnFurnitureChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFurnitureChooseActionPerformed(evt);
            }
        });

        lblQuotationID.setText("QUOTATION ID");

        tfQuotationID.setMaximumSize(new java.awt.Dimension(240, 30));
        tfQuotationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuotationIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblcreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblQuotationID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblFurnitureID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbFurniture)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFurnitureChoose))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegisterCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCustomerList))
                            .addComponent(tfQuotationID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(lblQuotation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuotation)
                            .addComponent(lblcreate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuotationID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFurniture, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFurnitureChoose)
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
                            .addComponent(lblCustomer)
                            .addComponent(tfCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegisterCustomer)
                            .addComponent(btnCustomerList))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack))))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
        double total = Double.parseDouble(tfTotal.getText());
    }//GEN-LAST:event_tfTotalActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Validate input
        if (!validateInput()) {
            JOptionPane.showMessageDialog(this, "Please enter valid data for quantity and total.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //   String id = tfOrderID.getText();
        String furniture = (String) cbFurniture.getText();
        int amount = (int)tfQuantity.getValue();
        double total = Double.parseDouble(tfTotal.getText());
        String customer = tfCustomer.getText();
        String quotationID = tfQuotationID.getText();
        
        // Check if the same customer ID is used for the same quotation number
    if (!validateCustomerForQuotation(customer, quotationID)) {
        JOptionPane.showMessageDialog(this, "Please enter the same customer ID for the same quotation number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    SalesOrder record = new SalesOrder(furniture, amount, total, parent.user.getId(), customer, quotationID);
    SalesOrder.salesOrders.add(record);
    File.write("salesOrder", SalesOrder.salesOrders);
    parent.updateData();
    // Add the new sales order to the list
    //  newSalesOrder.createSalesOrder(id, furniture, amount, total, "", customer, status);
        JOptionPane.showMessageDialog(this, "Sales Order Created!");
        model.addRow(new Object[]{record.getId(), record.getFurniture(), record.getQuantity(), 
        record.getTotal(),record.getCustomer(), record.getStatus(), record.getquotation()}); 
        parent.changeTab(7);
    }//GEN-LAST:event_btnCreateActionPerformed
    
    private void tfCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCustomerActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_tfCustomerActionPerformed

    private void tfQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tfQuantityStateChanged
        // TODO add your handling code here:
        quantity = (int)tfQuantity.getValue();
        calculateTotal();
    }//GEN-LAST:event_tfQuantityStateChanged

    private void btnRegisterCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCustomerActionPerformed
        Register subPage = new Register(this.parent);
        subPage.setVisible(true);
    }//GEN-LAST:event_btnRegisterCustomerActionPerformed

    private void btnCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerListActionPerformed
        //change to Customerlist tab
        parent.changeTab(5);
    }//GEN-LAST:event_btnCustomerListActionPerformed

    private void cbFurnitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFurnitureActionPerformed
        // TODO add your handling code here:
        String furniture = cbFurniture.getText();
        for (Furniture record: Furniture.list){
            if (record.getId().equals(furniture)){
               price = record.getPrice();
            }
        calculateTotal();
    }//GEN-LAST:event_cbFurnitureActionPerformed
    }
    private void btnFurnitureChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFurnitureChooseActionPerformed
        // TODO add your handling code here:
        parent.changeTab(6);
    }//GEN-LAST:event_btnFurnitureChooseActionPerformed

    private void tfQuotationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuotationIDActionPerformed
        String quotationID = tfQuotationID.getText();
         
    }//GEN-LAST:event_tfQuotationIDActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCustomerList;
    private javax.swing.JButton btnFurnitureChoose;
    private javax.swing.JButton btnRegisterCustomer;
    javax.swing.JTextField cbFurniture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblFurnitureID;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuotation;
    private javax.swing.JLabel lblQuotationID;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblcreate;
    private javax.swing.JTable tblQuotation;
    javax.swing.JTextField tfCustomer;
    private javax.swing.JSpinner tfQuantity;
    javax.swing.JTextField tfQuotationID;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}

