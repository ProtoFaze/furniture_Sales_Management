/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interface;

/**
 *
 * @author damonng
 */
public class StaffList extends javax.swing.JPanel {

    /**
     * Creates new form StaffList
     */
    public StaffList() {
        initComponents();
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
                            case "Officers"     -> {return officers.stream().anyMatch(officer -> officer.getId().equals(id));}
                            case "Salesperson"  -> {return salesPeople.stream().anyMatch(salesPerson -> salesPerson.getId().equals(id));}
                            default             -> {return true;}
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

        StaffLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        StaffLbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        StaffLbl.setText("Staff List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Role", "Title 3", "Title 4"
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

        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Staff List");

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show All", "Officers", "Salesperson" }));
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
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StaffLbl)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(StaffLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StaffLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
