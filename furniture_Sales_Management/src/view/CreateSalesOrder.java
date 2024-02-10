/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import Classes.File;
import Classes.Furniture;
import Classes.SalesOrder;
import Classes.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class CreateSalesOrder extends javax.swing.JPanel {
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
        initComponents();
        this.parent = parent;
        LoadData();
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
        lblOrderID = new javax.swing.JLabel();
        lblFurnitureID = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        tfOrderID = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        lblCustomer = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        tfCustomer = new javax.swing.JTextField();
        cbFurniture = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JSpinner();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuotation = new javax.swing.JTable();
        lblQuotation = new javax.swing.JLabel();

        lblcreate.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblcreate.setText("CREATE SALES ORDER ");

        lblOrderID.setText("ORDER ID");

        lblFurnitureID.setText("FURNITURE ID");

        lblQuantity.setText("QUANTITY");

        lblTotal.setText("TOTAL");

        tfOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOrderIDActionPerformed(evt);
            }
        });

        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        btnCreate.setText("CREATE ");
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

        cbFurniture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFurniture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFurnitureActionPerformed(evt);
            }
        });

        jLabel1.setText("WAITING FOR APPROVAL");

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
                "ORDER ID", "FURNITURE ID", "QUANTITY", "TOTAL", "CUSTOMER", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tblQuotation);

        lblQuotation.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblQuotation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuotation.setText("SALES ORDER QUOTATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFurnitureID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOrderID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFurniture, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblcreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addComponent(lblQuotation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuotation)
                    .addComponent(lblcreate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrderID)
                            .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFurnitureID)
                            .addComponent(cbFurniture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantity)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomer)
                            .addComponent(tfCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnBack)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
private void LoadData(){
    List<String> idList = new ArrayList<>();
        for (Furniture furniture: Furniture.list){
            idList.add(furniture.getId());
        }
    DefaultComboBoxModel data = new DefaultComboBoxModel<>(idList.toArray(new String [0]));
    cbFurniture.setModel(data);   
}
    private void tfOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrderIDActionPerformed
     //String orderID = tfOrderID.getText();
   
    }//GEN-LAST:event_tfOrderIDActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
        double total = Double.parseDouble(tfTotal.getText());
    }//GEN-LAST:event_tfTotalActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        // Validate input
        if (!validateInput()) {
            JOptionPane.showMessageDialog(this, "Please enter valid data for quantity and total.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     //   String id = tfOrderID.getText();
        String furniture = (String) cbFurniture.getSelectedItem();
        int amount = (int)tfQuantity.getValue();
        double total = Double.parseDouble(tfTotal.getText());
        String customer = tfCustomer.getText();

    // Create a new SalesOrder instance with the retrieved values
   // SalesOrder newSalesOrder = new SalesOrder(id, furniture, amount, total, "", customer, status);
     SalesOrder record = new SalesOrder(furniture, amount, total, parent.user.getId(), customer);
     SalesOrder.salesOrders.add(record);
    System.out.println(SalesOrder.latestId);
     File.write("salesOrder", SalesOrder.salesOrders);
    // Add the new sales order to the list
  //  newSalesOrder.createSalesOrder(id, furniture, amount, total, "", customer, status);
        JOptionPane.showMessageDialog(this, "Sales Order Created!");
        DefaultTableModel model = (DefaultTableModel) tblQuotation.getModel();
        model.addRow(new Object[]{tfOrderID.getText(), cbFurniture.getSelectedItem(), tfQuantity.getValue(), 
           tfTotal.getText(),tfCustomer.getText(), "Pending"}); 
    }//GEN-LAST:event_btnCreateActionPerformed


    
    private void cbFurnitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFurnitureActionPerformed
        // TODO add your handling code here:
        String furniture = (String) cbFurniture.getSelectedItem();
        for (Furniture record: Furniture.list){
            if (record.getId().equals(furniture)){
               price = record.getPrice();
            }
        }
        calculateTotal();
    }//GEN-LAST:event_cbFurnitureActionPerformed

    private void tfCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCustomerActionPerformed
        // TODO add your handling code here:
        String customer = tfCustomer.getText();
    }//GEN-LAST:event_tfCustomerActionPerformed

    private void tfQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tfQuantityStateChanged
        // TODO add your handling code here:
        quantity = (int)tfQuantity.getValue();
        calculateTotal();
    }//GEN-LAST:event_tfQuantityStateChanged
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
     tfTotal.setText(Double.toString(price*quantity));
 }
 
 //private String getID(){
   //  String salesPersonID = ;
 //}

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> cbFurniture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblFurnitureID;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuotation;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblcreate;
    private javax.swing.JTable tblQuotation;
    javax.swing.JTextField tfCustomer;
    private javax.swing.JTextField tfOrderID;
    private javax.swing.JSpinner tfQuantity;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}

