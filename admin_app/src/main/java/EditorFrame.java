
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
        showProducts();
        showOrders();
    }
    
    public EditorFrame() {
        initComponents();
    }
    
    public ArrayList<Product> productsList() {
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
    
    public void showProducts() {
        ArrayList<Product> list = productsList();
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

    public ArrayList<Order> ordersList() {
        ArrayList<Order> ordersList = new ArrayList<>();          
        try {
            String query = "SELECT * FROM orders";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Order order;
            while(resultSet.next()) {
                order = new Order(resultSet.getInt("id"), resultSet.getString("destination_city"),
                                  resultSet.getString("destination_post_code"),
                                  resultSet.getString("destination_street"),
                                  resultSet.getInt("Status"));
                ordersList.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return ordersList;
    }
    
    public void showOrders() {
        ArrayList<Order> list = ordersList();
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getDestinationCity();
            row[2] = list.get(i).getDestinationPostCode();
            row[3] = list.get(i).getDestinationStreet();
            row[4] = list.get(i).getStatus();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setDoneButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        modifyButton = new javax.swing.JButton();

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Destination City", "Destination Post Code", "Destination Street", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ordersTable);

        jLabel1.setText("ORDERS");

        jLabel2.setText("PRODUCTS");

        setDoneButton.setText("Set Done");
        setDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDoneButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Products:");

        jLabel4.setText("Orders:");

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newItemAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newItemPriceGrossField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(newItemNameField)
                            .addComponent(newItemPriceNettoField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(newItemIdField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newItemAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(setDoneButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(newItemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newItemPriceNettoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newItemPriceGrossField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newItemAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setDoneButton)
                            .addComponent(newItemAddButton))
                        .addGap(5, 5, 5)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifyButton)))
                .addContainerGap(20, Short.MAX_VALUE))
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
            showProducts();
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
            showProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void setDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDoneButtonActionPerformed
        try {
            int row = ordersTable.getSelectedRow();
            String value = ordersTable.getModel().getValueAt(row, 0).toString();
            String query = "UPDATE orders SET Status = 1 WHERE id="+value;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            showOrders();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_setDoneButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        try {
            int row = itemsTable.getSelectedRow();
            String value = itemsTable.getModel().getValueAt(row, 0).toString();
            String priceNetto = itemsTable.getModel().getValueAt(row, 2).toString();
            String priceGross = itemsTable.getModel().getValueAt(row, 3).toString();
            String amount = itemsTable.getModel().getValueAt(row, 4).toString();
            
            String query = "UPDATE products"+
                           " SET price_nett ="+priceNetto+
                           ", price_gross ="+priceGross+
                           ", amount ="+amount+
                           " WHERE id ="+value;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            showProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyButton;
    private javax.swing.JToggleButton newItemAddButton;
    private javax.swing.JTextField newItemAmountField;
    private javax.swing.JTextField newItemIdField;
    private javax.swing.JTextField newItemNameField;
    private javax.swing.JTextField newItemPriceGrossField;
    private javax.swing.JTextField newItemPriceNettoField;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton setDoneButton;
    // End of variables declaration//GEN-END:variables
}
