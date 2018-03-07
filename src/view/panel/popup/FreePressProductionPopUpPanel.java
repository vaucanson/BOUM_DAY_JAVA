/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel.popup;

import entity.Batch;
import entity.Press;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.FreePressTableModel;
import view.panel.StylePanel;

/**
 *
 * @author badaroux
 */
public class FreePressProductionPopUpPanel extends StylePanel {

    private JFrame parent;
    private FreePressTableModel fptm = new FreePressTableModel();
    
    public FreePressProductionPopUpPanel(JFrame frame) {
        initComponents();
        this.setVisible(true);
        this.parent = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePressBatch = new javax.swing.JTable();
        buttonValidate = new javax.swing.JButton();
        labTitle = new javax.swing.JLabel();

        tablePressBatch.setModel(fptm);
        jScrollPane1.setViewportView(tablePressBatch);

        buttonValidate.setText("Désafecter un lot");
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        labTitle.setText("Gestion des presses");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 177, Short.MAX_VALUE)
                .addComponent(labTitle)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(buttonValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labTitle)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonValidate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        ConfirmStart();
    }//GEN-LAST:event_buttonValidateActionPerformed
private void ConfirmStart()
    {   
       if (JOptionPane.showConfirmDialog(null,"Libérer la presse ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
       {
          int row = tablePressBatch.getSelectedRow();
          int column = tablePressBatch.getSelectedColumn();
          
          if (tablePressBatch.getValueAt(row, column).getClass() == Press.class)
          {
                JOptionPane.showMessageDialog(null, "Merci de selectionner une celulle 'lot' et non pas une presse");
          }
          else
          {
                fptm.launch((Batch) tablePressBatch.getValueAt(row, column));
                fptm.fireTableDataChanged();
          }
 
       }            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonValidate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTable tablePressBatch;
    // End of variables declaration//GEN-END:variables
}
