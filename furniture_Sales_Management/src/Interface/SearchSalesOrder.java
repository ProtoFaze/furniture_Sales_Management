/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interface;

import Classes.SalesOrder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aryssa
 */
public class SearchSalesOrder extends javax.swing.JPanel {
    MainPage parent;
    /**
     * Creates new form SearchSalesOrder
     */
    public SearchSalesOrder() {
        initComponents();
    }
    public SearchSalesOrder(MainPage parent) {
        initComponents();
        this.parent = parent;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearchSalesOrder = new javax.swing.JLabel();
        tfOrderIDsearch = new javax.swing.JTextField();
        lblOrderID1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuotationSearch = new javax.swing.JTable();

        lblSearchSalesOrder.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblSearchSalesOrder.setText("SEARCH SALES ORDER");

        tfOrderIDsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOrderIDsearchActionPerformed(evt);
            }
        });

        lblOrderID1.setText("ORDER ID");

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblQuotationSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ORDER ID", "FURNITURE ID", "QUANTITY", "TOTAL", "CUSTOMER ID", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tblQuotationSearch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblOrderID1)
                        .addGap(39, 39, 39)
                        .addComponent(tfOrderIDsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(lblSearchSalesOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblSearchSalesOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOrderIDsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrderID1))
                        .addGap(66, 66, 66)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //Get order ID from text field
        String orderIDsearch = tfOrderIDsearch.getText();     
        SalesOrder salesOrder = new SalesOrder();
        String searchQuotationDetails = salesOrder.searchOrderIDinFile(orderIDsearch);
        
        if(searchQuotationDetails != null){
            JOptionPane.showMessageDialog(this, "Order ID Found!");
            updateTable(searchQuotationDetails);
        }
        else{
            JOptionPane.showMessageDialog(this, "Order ID Not Found!");
        }
                
    }//GEN-LAST:event_btnSearchActionPerformed
    
   private void updateTable(String salesQuotationDetails) {
    DefaultTableModel model = (DefaultTableModel) tblQuotationSearch.getModel();
    model.setRowCount(0);

    String[] parts = salesQuotationDetails.split(",");

    // Create a new array with the expected size for the table model
    Object[] row = new Object[model.getColumnCount()];

    // Fill in the values from the parts array, set empty string for missing values
    for (int i = 0; i < model.getColumnCount(); i++) {
        String columnName = model.getColumnName(i).trim();
        if (columnName.equals("ORDER ID")) {
            row[i] = parts[0].trim();
        } else if (columnName.equals("FURNITURE ID")) {
            row[i] = parts[1].trim();
        } else if (columnName.equals("QUANTITY")) {
            row[i] = parts[2].trim();
        } else if (columnName.equals("TOTAL")) {
            row[i] = parts[3].trim();
        } else if (columnName.equals("CUSTOMER ID")) {
            row[i] = parts[4].trim(); 
        } else if (columnName.equals("STATUS")) {
            row[i] = parts[5].trim(); 
        } else {
            row[i] = ""; // Set empty string for unknown columns
        }
    }

    // Add the row to the table model
    model.addRow(row);
}

    private void tfOrderIDsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrderIDsearchActionPerformed
        // TODO add your handling code here:
        String orderIDsearch = tfOrderIDsearch.getText();
    }//GEN-LAST:event_tfOrderIDsearchActionPerformed
   private String[] searchOrderIDinFile(String orderIDsearch) {
        try (BufferedReader br = new BufferedReader(new FileReader("salesOrder.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String orderIDFromFile = parts[0].trim();
                if (orderIDFromFile.equals(orderIDsearch)) {
                    // Order ID found, return the details
                    return parts;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching for Order ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderID1;
    private javax.swing.JLabel lblSearchSalesOrder;
    private javax.swing.JTable tblQuotationSearch;
    private javax.swing.JTextField tfOrderIDsearch;
    // End of variables declaration//GEN-END:variables
}
