/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interface;

import Classes.SalesOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class PersonalSales extends javax.swing.JPanel {
    
    private DefaultTableModel temp;
    private String salesPersonId;
    MainPage parent;
    /**
     * Creates new form PersonalSales
     */
    public PersonalSales(){
        initComponents();
    }
    public PersonalSales(MainPage parent) {
        initComponents();
        this.parent = parent;
        salesPersonId = parent.user.getId();
    }

    private void showSalesForSalesPerson() {
    DefaultTableModel model = (DefaultTableModel) tblPersonalSales.getModel();
    model.setRowCount(0); // Clear existing rows

    // Iterate through the salesOrders list and add rows for matching salesperson ID
    for (SalesOrder order : SalesOrder.salesOrders) {
        System.out.println("ID: " + salesPersonId + "Sales Person : " + order.getGeneratedBy());
        // Add a null check for getSalesPersonId()
        String orderSalesPersonId = order.getGeneratedBy();
        if (orderSalesPersonId != null && orderSalesPersonId.equals(salesPersonId)) {
            // Create a new array with the expected size for the table model
            Object[] row = new Object[model.getColumnCount()];

            // Fill in the values from the SalesOrder object
            row[0] = order.getId();
            row[1] = order.getFurniture();
            row[2] = order.getQuantity();
            row[3] = order.getTotal();
            row[4] = order.getCustomer();
            row[5] = order.getStatus();

            // Add the row to the table model
            model.addRow(row);
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

        lblPersonalSales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonalSales = new javax.swing.JTable();
        lblOrderID = new javax.swing.JLabel();
        btnShowSales = new javax.swing.JButton();

        lblPersonalSales.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPersonalSales.setText("PERSONAL SALES");

        tblPersonalSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ORDER ID", "FURNITURE ID", "QUANTITY", "TOTAL", "CUSTOMER ID", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tblPersonalSales);

        btnShowSales.setText("SHOW SALES");
        btnShowSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblOrderID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPersonalSales)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnShowSales)
                        .addGap(280, 280, 280))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblPersonalSales)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(lblOrderID)
                        .addGap(339, 339, 339))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowSales)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSalesActionPerformed
        // TODO add your handling code here:
        showSalesForSalesPerson();
    }//GEN-LAST:event_btnShowSalesActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowSales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPersonalSales;
    private javax.swing.JTable tblPersonalSales;
    // End of variables declaration//GEN-END:variables
}
