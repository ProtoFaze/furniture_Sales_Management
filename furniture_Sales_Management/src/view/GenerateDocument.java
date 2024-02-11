/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Classes.SalesOrder;
import Classes.User;
import Classes.Verify;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author damonng
 */
public class GenerateDocument extends javax.swing.JPanel {

    private MainPage parent;
    private User user;
    private enum DocType{
        productionInvoice,
        salesQuotation,
        workDoneReport, 
        closedSalesReport,
    }
    private List<Object> data = new ArrayList<>();
    /**
     * Creates new form generateReport
     */
    public GenerateDocument() {
        initComponents();
    }

    public GenerateDocument(MainPage parent) {
        initComponents();
        this.parent = parent;
        loadData();
    }
    private void loadData(){
        user = parent.user;
    }
    private void generatePDF(String filePath, DocType type) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            document.add(new Paragraph("Table Data"));

            PdfPTable pdfTable = new PdfPTable(jTable1.getColumnCount());


            // Add table headers
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                pdfTable.addCell(jTable1.getColumnName(i));
            }

            // Add table data
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    pdfTable.addCell(jTable1.getValueAt(i, j).toString());
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this, "Table data saved to PDF successfully.");
        } catch (IOException | com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving to PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean isWithinRange(String id, Date inputStartDate, Date inputEndDate) {
        
        LocalDate searchStart = Verify.DateToLocalDate(inputStartDate),
                searchEnd = Verify.DateToLocalDate(inputEndDate);
        //loop through records
        for(SalesOrder salesOrder : SalesOrder.salesOrders){
            //assign values
            String recordId = salesOrder.getId();
            String productionState = salesOrder.getStatus();

            LocalDate generationDate = LocalDate.now();

            //booking status check
            if (recordId.equals(id) && productionState.equals("done")) { //matched record and state
                // Check if the generation date is out of the date range
                if ((searchStart.isBefore(generationDate) || searchStart.isEqual(generationDate))
                        && (searchEnd.isAfter(generationDate) || searchEnd.isEqual(generationDate))) {
                    return true; // Is Within Range
                }
            }
            break;
        }
        return false; // Not Within Range
    }

    public static void generatePDF(String outputFilePath) {
        Document document = new Document();

        try {

            // Create a PdfWriter with an event handler for custom layout
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
            CustomLayoutPageEvent event = new CustomLayoutPageEvent();
            writer.setPageEvent(event);

            document.open();

            // Add content to the document
            document.add(new Paragraph("This is the main content of the document."));

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

    // Custom layout event handler
    private static class CustomLayoutPageEvent extends PdfPageEventHelper {

        private PdfTemplate total;

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            // Add content to the top of each page (e.g., title)
            try {
                document.add(new Paragraph("YOYO furniture", FontFactory.getFont("Helvetica",18)));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            // Add content to the bottom of each page (e.g., footer, page number)
                int pageNumber = writer.getPageNumber();
                String footer = "Page " + pageNumber;
                float fontSize = 12;
                float pageWidth = document.getPageSize().getWidth();

                // Create a template for the total page number
                total = writer.getDirectContent().createTemplate(100, 100);
                total.setBoundingBox(new Rectangle(0, 0, 100, 100));

                // Add content to the template
                total.beginText();
                total.setFontAndSize(FontFactory.getFont("Helvetica").getBaseFont(), fontSize);
                total.setTextMatrix(0, 0);
                total.showText(footer);
                total.endText();

                // Add the template to the page
                writer.getDirectContent().addTemplate(total, pageWidth - 100, 20);


        }
        

        @Override
        public void onCloseDocument(PdfWriter writer, Document document) {
            // Update the total page number in the template
            total.beginText();
            total.setFontAndSize(FontFactory.getFont("Helvetica").getBaseFont(), 12);
            total.setTextMatrix(0, 0);
            total.showText(String.valueOf(writer.getPageNumber() - 1));
            total.endText();
        }
    }
    private void printidentifier(String path, DocType type){
        switch (type){
            case productionInvoice  ->{System.out.println(path+ "invoice");}
            case salesQuotation     ->{System.out.println(path+ "quotation");}
            case workDoneReport     ->{System.out.println(path+ "workDone");} 
            case closedSalesReport  ->{System.out.println(path+ "ClosedSales");}
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        jButton1.setText("Generate pdf");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generate Document");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generatePDF("./src/Report/Report.pdf");
//        Font font = FontFactory.getFont("Helvetica", 12);
//        System.out.println(font.getBaseFont());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
