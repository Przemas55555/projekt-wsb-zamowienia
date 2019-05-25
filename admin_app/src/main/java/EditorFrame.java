
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditorFrame extends javax.swing.JFrame {

    private String login = null;

    public EditorFrame(String login) {
        initComponents();
        this.login = login;
        try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/orders", this.login, "");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        showUsers();
    }
    
    public EditorFrame() {
        initComponents();
    }
    
    public ArrayList<Product> itemsList() {
        ArrayList<Product> itemsList = new ArrayList<>();          
        try {
            String query = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Product item;
            while(resultSet.next()) {
                item = new Product(resultSet.getInt("id"), resultSet.getString("name"),
                                  resultSet.getInt("price_nett"), resultSet.getInt("price_gross"),
                                  resultSet.getInt("amount"));
                itemsList.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return itemsList;
    }
    
    public void showUsers() {
        ArrayList<Product> list = itemsList();
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPriceNetto();
            row[3] = list.get(i).getPriceGross();
            row[4] = list.get(i).getAmount();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newItemNameField = new javax.swing.JTextField();
        newItemPriceNettoField = new javax.swing.JTextField();
        newItemPriceGrossField = new javax.swing.JTextField();
        newItemAmountField = new javax.swing.JTextField();
        newItemAddButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        newItemIdField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newItemNameField.setText("Name");
        newItemNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemNameFieldFocusGained(evt);
            }
        });

        newItemPriceNettoField.setText("Price netto");
        newItemPriceNettoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemPriceNettoFieldFocusGained(evt);
            }
        });
        newItemPriceNettoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemPriceNettoFieldActionPerformed(evt);
            }
        });

        newItemPriceGrossField.setText("Price gross");
        newItemPriceGrossField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemPriceGrossFieldFocusGained(evt);
            }
        });

        newItemAmountField.setText("Amount");
        newItemAmountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemAmountFieldFocusGained(evt);
            }
        });

        newItemAddButton.setText("Add");
        newItemAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemAddButtonActionPerformed(evt);
            }
        });

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Price netto", "Price gross", "Amount"
            }
        ));
        jScrollPane1.setViewportView(itemsTable);

        newItemIdField.setText("Id");
        newItemIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemIdFieldFocusGained(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(newItemAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newItemPriceGrossField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(newItemNameField)
                        .addComponent(newItemPriceNettoField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(newItemIdField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newItemAddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(newItemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newItemPriceNettoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newItemPriceGrossField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newItemAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newItemAddButton)
                    .addComponent(deleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newItemAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemAddButtonActionPerformed
        String query = "insert into products (id, name, price_nett, price_gross, amount)values(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(newItemIdField.getText()));
            statement.setString(2, newItemNameField.getText());
            statement.setInt(3, Integer.parseInt(newItemPriceNettoField.getText()));
            statement.setInt(4, Integer.parseInt(newItemPriceGrossField.getText()));
            statement.setInt(5, Integer.parseInt(newItemAmountField.getText()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted successfully");
            showUsers();
            newItemIdField.setText("Id");
            newItemNameField.setText("Name");
            newItemPriceNettoField.setText("Price netto");
            newItemPriceGrossField.setText("Price gross");
            newItemAmountField.setText("Amount");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_newItemAddButtonActionPerformed

    private void newItemPriceNettoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemPriceNettoFieldActionPerformed
    }//GEN-LAST:event_newItemPriceNettoFieldActionPerformed

    private void newItemIdFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemIdFieldFocusGained
        newItemIdField.setText(null);
    }//GEN-LAST:event_newItemIdFieldFocusGained

    private void newItemNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemNameFieldFocusGained
        newItemNameField.setText(null);
    }//GEN-LAST:event_newItemNameFieldFocusGained

    private void newItemPriceNettoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemPriceNettoFieldFocusGained
        newItemPriceNettoField.setText(null);
    }//GEN-LAST:event_newItemPriceNettoFieldFocusGained

    private void newItemPriceGrossFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemPriceGrossFieldFocusGained
        newItemPriceGrossField.setText(null);
    }//GEN-LAST:event_newItemPriceGrossFieldFocusGained

    private void newItemAmountFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemAmountFieldFocusGained
        newItemAmountField.setText(null);
    }//GEN-LAST:event_newItemAmountFieldFocusGained

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            int row = itemsTable.getSelectedRow();
            String value = itemsTable.getModel().getValueAt(row, 0).toString();
            String query = "DELETE FROM products where id="+value;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            showUsers();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorFrame().setVisible(true);
            }
        });
    }

    Connection connection = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable itemsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton newItemAddButton;
    private javax.swing.JTextField newItemAmountField;
    private javax.swing.JTextField newItemIdField;
    private javax.swing.JTextField newItemNameField;
    private javax.swing.JTextField newItemPriceGrossField;
    private javax.swing.JTextField newItemPriceNettoField;
    // End of variables declaration//GEN-END:variables
}
