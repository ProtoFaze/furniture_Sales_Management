/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import classes.Officer;
import classes.SalesPerson;
import classes.User;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author damonng
 */
public class StaffList extends javax.swing.JPanel {
    MainPage parent;
    User selectedWorker;
    private ProfilePage subPage;
    private DefaultTableModel helper;
    private JButton btnInspect;
    private static List<Officer> officers;
    private static List<SalesPerson> salesPeople;
    private static List<User> workers;
    /**
     * Creates new form StaffList
     */
    public StaffList(){
        initComponents();
    }
    /**
     * 
     * @param parent to reuse the generated main page and its attributes
     */
    public StaffList(MainPage parent) {
        initComponents();
        this.parent = parent;
        officers = Officer.officers;
        salesPeople = SalesPerson.salesPeople;
        if(officers!=null && salesPeople!=null){
            workers = new ArrayList<>();
            btnInspect = new JButton();
            workers.addAll(officers);
            workers.addAll(salesPeople);
            populateTable();
            tblworkers.getColumn("Action").setCellRenderer( new ButtonRenderer());
            tblworkers.getColumn("Action").setCellEditor( new ButtonEditor(new JCheckBox()));
            btnInspect.addActionListener((ActionEvent event) -> {
                int row = tblworkers.getSelectedRow();
                String id = (String) tblworkers.getValueAt(row, 0);
                workers.stream()
                .filter(worker -> worker.getId().equals(id))
                .findFirst()
                .ifPresent(worker -> selectedWorker = worker);
                subPage = new ProfilePage(this);
                subPage.setVisible(true);
            });
        }
    }

    public void populateTable(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                helper = (DefaultTableModel) tblworkers.getModel();
                helper.setRowCount(0);
                Object row[] = new Object[5]; 
                for (User worker : workers) {
                    //add to new temp table if room is available
                    row[0] = worker.getId();
                    row[1] = worker.getFullName();
                    row[2] = worker.getMail();
                    row[3] = worker.getDob();
                    helper.addRow(row);
                }
            }
        });
    }
    public void populateTable(String filter){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create a TableRowSorter and set it to the JTable
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblworkers.getModel());
                tblworkers.setRowSorter(sorter);

                // Create a RowFilter based on the filter condition
                RowFilter<Object, Object> rowFilter = new RowFilter<Object, Object>() {
                    public boolean include(Entry<?, ?> entry) {
                        // Get the ID column (column 0), and return "false" if the ID does not meet the filter condition
                        String id = entry.getStringValue(0);
                        switch(filter){
                            case"officers"->     {return officers.stream().anyMatch(officer -> officer.getId().equals(id));}
                            case"sales people"-> {return salesPeople.stream().anyMatch(salesPerson -> salesPerson.getId().equals(id));}
                            default->           {return true;}
                        }
                    }
                };
                sorter.setRowFilter(rowFilter);
            }
        });
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer{
        public ButtonRenderer(){
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null)? "Inspect" : value.toString());
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
            label = (value == null) ? "Inspect" : value.toString();
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
        tblworkers = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();

        tblworkers.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblworkers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Birth Date", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblworkers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblworkers);
        if (tblworkers.getColumnModel().getColumnCount() > 0) {
            tblworkers.getColumnModel().getColumn(0).setResizable(false);
            tblworkers.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblworkers.getColumnModel().getColumn(2).setResizable(false);
            tblworkers.getColumnModel().getColumn(4).setResizable(false);
        }

        title.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Staff List");

        filter.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show all", "Officers", "Sales people" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        populateTable(filter.getSelectedItem().toString().toLowerCase());
    }//GEN-LAST:event_filterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblworkers;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
