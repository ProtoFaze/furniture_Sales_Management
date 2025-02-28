/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.File;
import Classes.SalesOrder;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class DeleteQuotation extends javax.swing.JPanel {
    MainPage parent;
    private DefaultTableModel temp;

    /**
     * Creates new form DeleteQuotation
     */
    public DeleteQuotation() {
        initComponents();
    }
    
    public DeleteQuotation(MainPage parent) {
        initComponents();
        this.parent = parent;
        LoadData();
    }
    
    void LoadData(){
        populateTable();
    }
    
    void populateTable(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                temp = (DefaultTableModel) tblQuotation.getModel();
                temp.setRowCount(0);
                Object row[] = new Object[7];
                for (SalesOrder sales : SalesOrder.salesOrders) {
                    // Filter sales orders based on the logged-in salesperson's ID
                    if(SalesOrder.isMyQuotation(sales.getQuotation(), parent.user.getId())){
                        row[0] = sales.getQuotation();
                        row[1] = sales.getId();
                        row[2] = sales.getFurniture();
                        row[3] = sales.getQuantity();
                        row[4] = sales.getTotal();
                        row[5] = sales.getCustomer();
                        row[6] = sales.getStatus();
                        temp.addRow(row);
                    }
                    
                }
            }
        });
    }
    private boolean validateInput(){
        // Validate QuotationID text field
        String quotationIDText = tfQuotationID.getText().trim();
        if (quotationIDText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quotation ID cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    private void deleteQuotation(String selectedQuotationID) {
        Boolean isDeleted = false;
        if(SalesOrder.isMyQuotation(selectedQuotationID, parent.user.getId())){
            SalesOrder.deleteWholeQuotation(selectedQuotationID);
            isDeleted = true;
        }
        // If the order is found, remove it from the list
        if (isDeleted) {
            //Display table again after delete
            parent.updateData();
            // Display a message indicating that the order is deleted
            JOptionPane.showMessageDialog(this, "Quotation deleted successfully!");
        } else {
            // If the order is not found, display an error message
            JOptionPane.showMessageDialog(this, "Quotation not found", "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuotation = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        tfQuotationID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSaveChanges = new javax.swing.JButton();

        setOpaque(false);

        tblQuotation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "QUOTATION ID", "ORDER ID", "FURNITURE ID", "QUANTITY", "TOTAL", "CUSTOMER ID", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblQuotation);
        if (tblQuotation.getColumnModel().getColumnCount() > 0) {
            tblQuotation.getColumnModel().getColumn(0).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("DELETE QUOTATION");

        jLabel2.setText("QUOTATION ID");

        btnSaveChanges.setText("SAVE CHANGES");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveChanges))
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        if (!validateInput()) {
            JOptionPane.showMessageDialog(this, "Please enter a Quotation ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            deleteQuotation(tfQuotationID.getText());
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblQuotation;
    private javax.swing.JTextField tfQuotationID;
    // End of variables declaration//GEN-END:variables
}
