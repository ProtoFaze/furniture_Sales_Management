/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Classes.SalesOrder;
import Classes.User;
import Classes.Verify;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Liang
 */
public class GeneratePDF extends javax.swing.JFrame {
    private User user;
    private String ID;
    private DefaultTableModel model;
    private int Total;
    /**
     * Creates new form PDFTest
     */
    public GeneratePDF(User user, String ID) {
        initComponents();
        model = (DefaultTableModel) QuotationList.getModel();
        this.user = user;
        this.ID = ID;
        LoadData();
    }
    
    public void LoadData(){
        model.setRowCount(0);
        NameTxt.setText(user.getUserName());
        DateTxt.setText(Verify.LocalDateToString(LocalDate.now()));
        for (SalesOrder order : SalesOrder.salesOrders) {
            String orderApproved = order.getApprovedBy();
            if (orderApproved != null 
                    && orderApproved.equals(user.getId()) 
                    && order.getStatus().equals("Approved") 
                    && order.getCustomer().equals(ID)) {
                Object[] row = new Object[model.getColumnCount()];
                // Fill in the values from the SalesOrder object
                row[0] = order.getId();
                row[1] = order.getQuotation();
                row[2] = order.getQuantity();
                row[3] = order.getTotal();
                Total += order.getTotal();
                
                model.addRow(row);
            }
        }
        TotalTxt.setText("RM " + Integer.toString(Total));
    }
    
    private String selectFilePath() {
        String path = "";
        
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = chooser.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();
        }
        return path;
    }
    
    private void pdf(String filePath) {
        try{
            Dimension panelSize = InvoicePanel.getSize();
            BufferedImage capture = new BufferedImage(panelSize.width, panelSize.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = capture.createGraphics();
            InvoicePanel.paint(graphics);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Image image = Image.getInstance(capture, null);
            document.add(image);
            document.close();
            JOptionPane.showMessageDialog(this, "PDF generated successfully.");
        } catch (IOException | com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving to PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        InvoicePanel = new javax.swing.JPanel();
        InvoiceLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuotationList = new javax.swing.JTable();
        DateLbl = new javax.swing.JLabel();
        DateTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NameTxt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TotalTxt = new javax.swing.JLabel();
        ProductionBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        GenerateBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        GenerateBtn.setText("Generate PDF");
        GenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBtnActionPerformed(evt);
            }
        });

        InvoicePanel.setBackground(new java.awt.Color(255, 255, 255));
        InvoicePanel.setForeground(new java.awt.Color(255, 255, 255));

        InvoiceLbl.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        InvoiceLbl.setForeground(new java.awt.Color(0, 0, 0));
        InvoiceLbl.setText("Invoice");

        QuotationList.setBackground(new java.awt.Color(255, 255, 255));
        QuotationList.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        QuotationList.setForeground(new java.awt.Color(0, 0, 0));
        QuotationList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "QuotationID", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(QuotationList);

        DateLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        DateLbl.setForeground(new java.awt.Color(0, 0, 0));
        DateLbl.setText("Date:");

        DateTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        DateTxt.setForeground(new java.awt.Color(0, 0, 0));
        DateTxt.setText("--DATE--");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("YOYO Furniture");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("137, Jln Medan 6 ,Taman Medan");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("46000, Petaling Jaya");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Selangor");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Approved By:");

        NameTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NameTxt.setText("--NAME--");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("**Please pay within 2 weeks of issue");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("*This is a computer generated document. No signature is needed.");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Grand Total:");

        TotalTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TotalTxt.setText("--TOTAL--");

        javax.swing.GroupLayout InvoicePanelLayout = new javax.swing.GroupLayout(InvoicePanel);
        InvoicePanel.setLayout(InvoicePanelLayout);
        InvoicePanelLayout.setHorizontalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2))
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel3))
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                        .addComponent(DateLbl)
                        .addGap(18, 18, 18)
                        .addComponent(DateTxt)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                        .addComponent(InvoiceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NameTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(TotalTxt)
                .addGap(23, 23, 23))
        );
        InvoicePanelLayout.setVerticalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InvoiceLbl)
                .addGap(19, 19, 19)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLbl)
                    .addComponent(DateTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NameTxt)
                    .addComponent(jLabel6)
                    .addComponent(TotalTxt))
                .addGap(130, 130, 130)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        ProductionBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ProductionBtn.setText("Send to Production");
        ProductionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductionBtnActionPerformed(evt);
            }
        });

        BackBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BackBtn.setText("Close");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductionBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenerateBtn))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InvoicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductionBtn)
                    .addComponent(GenerateBtn)
                    .addComponent(BackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBtnActionPerformed
        // TODO add your handling code here:
        pdf(selectFilePath());
        this.setVisible(false);
    }//GEN-LAST:event_GenerateBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void ProductionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductionBtnActionPerformed
        // TODO add your handling code here:
        openDefaultMailClient();
        
    }//GEN-LAST:event_ProductionBtnActionPerformed
    
    private static void openDefaultMailClient() {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
            try {
                Desktop.getDesktop().mail(new URI("mailto:yoyoproduction@mail.com"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Desktop doesn't support mail");
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel DateLbl;
    private javax.swing.JLabel DateTxt;
    private javax.swing.JButton GenerateBtn;
    private javax.swing.JLabel InvoiceLbl;
    private javax.swing.JPanel InvoicePanel;
    private javax.swing.JLabel NameTxt;
    private javax.swing.JButton ProductionBtn;
    private javax.swing.JTable QuotationList;
    private javax.swing.JLabel TotalTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
