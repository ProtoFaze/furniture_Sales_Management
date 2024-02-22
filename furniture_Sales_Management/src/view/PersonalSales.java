/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.SalesOrder;
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
        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show all", "Pending", "Approved", "Rejected" }));
        LoadData();
    }
    public void LoadData(){
        showSales("Show all");
    }
    private void showSales(String filter) {
        DefaultTableModel model = (DefaultTableModel) tblPersonalSales.getModel();
        model.setRowCount(0); // Clear existing rows

        // Iterate through the salesOrders list and add rows for matching salesperson ID
        for (SalesOrder order : SalesOrder.salesOrders) {
            String orderSalesPersonId = order.getGeneratedBy();
            String orderStatus = order.getStatus();
            if (orderSalesPersonId != null && orderSalesPersonId.equals(salesPersonId) && 
                (filter.equals("Show all") || orderStatus.equals(filter)))  
                {
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
        filterStatus = new javax.swing.JComboBox<>();

        setOpaque(false);

        lblPersonalSales.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblPersonalSales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonalSales);

        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filterStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblOrderID)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPersonalSales, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonalSales)
                    .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOrderID)
                        .addGap(339, 339, 339))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterStatusActionPerformed
        String selectedStatus = String.valueOf(filterStatus.getSelectedItem());
        
        showSales(selectedStatus);
    }//GEN-LAST:event_filterStatusActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filterStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPersonalSales;
    private javax.swing.JTable tblPersonalSales;
    // End of variables declaration//GEN-END:variables
}
