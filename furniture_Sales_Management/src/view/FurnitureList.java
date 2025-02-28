/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;


import Classes.Furniture;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Aryssa
 */
public class FurnitureList extends javax.swing.JPanel {
    MainPage parent;
    public static List<Furniture> list;
    private DefaultTableModel temp; 
    private JButton btnInspect;
    Furniture selectedFurniture;

    /**
     * Creates new form FurnitureList
     */
    public FurnitureList() {
        initComponents();
    }
    public FurnitureList(MainPage parent) {
        initComponents();
        this.parent = parent;
        populateTable();
        setupActions();
    }
    
     void loadData(){
        selectedFurniture = null;
    }
    
    public void populateTable(){
         temp = (DefaultTableModel) tblFurniture.getModel();
            temp.setRowCount(0); // Clear existing rows

            Object row[] = new Object[4]; 

            for (Furniture furniture : Furniture.list) {
                // Assuming Furniture.list is a static list containing furniture objects
                row[0] = furniture.getId();
                row[1] = furniture.getName();
                row[2] = furniture.getCategory();
                row[3] = furniture.getPrice();

                temp.addRow(row);
    }
    }
     private void setupActions(){
        btnInspect = new JButton();
        tblFurniture.getColumn("Action").setCellRenderer( new FurnitureList.ButtonRenderer());
        tblFurniture.getColumn("Action").setCellEditor( new FurnitureList.ButtonEditor(new JCheckBox()));
        btnInspect.addActionListener((ActionEvent event) -> {
            int row = tblFurniture.getSelectedRow();
            String id = (String) tblFurniture.getValueAt(row, 0);
            Furniture.list.stream().filter(furniture -> furniture.getId().equals(id)).findFirst().ifPresent(furniture -> {
            selectedFurniture = furniture; 
            parent.createSalesOrder.cbFurniture.setText(selectedFurniture.getId()); 
            parent.changeTab("createSalesOrder"); // Redirect to another tab
});
        });
    }
     class ButtonRenderer extends JButton implements TableCellRenderer{
        public ButtonRenderer(){
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null)? "Choose" : value.toString());
            return this;
        }

    }
    class ButtonEditor extends DefaultCellEditor{
        private String label;
        
        public ButtonEditor(JCheckBox checkbox){
           super(checkbox);
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Choose" : value.toString();
            btnInspect.setText(label);
            return btnInspect;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
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
        tblFurniture = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();

        setOpaque(false);

        tblFurniture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category", "Price", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFurniture);

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Furniture List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblFurniture;
    // End of variables declaration//GEN-END:variables
}
