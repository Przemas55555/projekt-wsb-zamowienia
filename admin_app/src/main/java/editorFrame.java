
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 30Luty
 */
public class editorFrame extends javax.swing.JFrame {

    private String m_login = null;

    /**
     * Creates new form editorFrame
     */
    public editorFrame(String p_login) {
        initComponents();
        this.m_login = p_login;
        try {
        m_connection = DriverManager.getConnection("jdbc:mysql://localhost/orders", m_login, "");
        } catch(SQLException ex) {
            Logger.getLogger(loginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        showUsers();
    }
    
    public editorFrame() {
        initComponents();
    }
    
    public ArrayList<item> itemsList() {
        ArrayList<item> itemsList = new ArrayList<>();          
        try {
            String query = "SELECT * FROM products";
            Statement statement = m_connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            item l_item;
            while(resultSet.next()) {
                l_item = new item(resultSet.getInt("id"), resultSet.getString("name"),
                                  resultSet.getInt("price_nett"), resultSet.getInt("price_gross"),
                                  resultSet.getInt("amount"));
                itemsList.add(l_item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsList;
    }
    
    public void showUsers() {
        ArrayList<item> l_list = itemsList();
        DefaultTableModel l_model = (DefaultTableModel) itemsTable.getModel();
        l_model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < l_list.size(); i++) {
            row[0] = l_list.get(i).getId();
            row[1] = l_list.get(i).getName();
            row[2] = l_list.get(i).getPriceNetto();
            row[3] = l_list.get(i).getPriceGross();
            row[4] = l_list.get(i).getAmount();
            l_model.addRow(row);
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

        newItemNameField = new javax.swing.JTextField();
        newItemPriceNettoField = new javax.swing.JTextField();
        newItemPriceGrossField = new javax.swing.JTextField();
        newItemAmountField = new javax.swing.JTextField();
        newItemAddButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        newItemIdField = new javax.swing.JTextField();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newItemAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newItemPriceGrossField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(newItemNameField)
                            .addComponent(newItemPriceNettoField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(newItemIdField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(newItemAddButton)))
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
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
                .addGap(28, 28, 28)
                .addComponent(newItemAddButton)
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
            PreparedStatement statement = m_connection.prepareStatement(query);
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
            Logger.getLogger(editorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_newItemAddButtonActionPerformed

    private void newItemPriceNettoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemPriceNettoFieldActionPerformed
        // TODO add your handling code here:
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editorFrame().setVisible(true);
            }
        });
    }

    Connection m_connection = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
