/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import entity.Batch;
import entity.Press;
import view.frame.popup.FreePressProductionPopUpFrame;
import javax.swing.JOptionPane;
import model.ListPressModel;
import model.StartedBatchListModel;
import view.frame.MainFrame;

/**
 *
 * @author mattar
 */
public class ProdPanel extends StylePanel {

      private MainFrame parent;
      private model.StartedBatchListModel sblm = new StartedBatchListModel();
      private model.ListPressModel lpm = new ListPressModel();
        
    public ProdPanel(MainFrame parent) {
        initComponents();
        setVisible(true);
        this.parent = parent;
    }
    
    private void ConfirmStart()
    {
        
       if (JOptionPane.showConfirmDialog(null,"Lancer la production ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
       {
          sblm.launch((Batch) listBatch.getSelectedValue(), (Press) listPress2.getSelectedValue());
          lpm.removePress((Press) listPress2.getSelectedValue());
       }          
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBatch = new javax.swing.JList();
        buttonFreePress = new javax.swing.JButton();
        buttonStartBatch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listPress = new javax.swing.JScrollPane();
        listPress2 = new javax.swing.JList();

        setPreferredSize(new java.awt.Dimension(900, 500));

        listBatch.setModel(sblm);
        jScrollPane1.setViewportView(listBatch);

        buttonFreePress.setText("Libérer Presse");
        buttonFreePress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFreePressActionPerformed(evt);
            }
        });

        buttonStartBatch.setText("Demarrer Lot");
        buttonStartBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartBatchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Lancement de Production");

        listPress2.setModel(lpm);
        listPress.setViewportView(listPress2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(listPress, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonFreePress, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(buttonFreePress, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listPress, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFreePressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFreePressActionPerformed
        FreePressProductionPopUpFrame.getInstance();
        

    }//GEN-LAST:event_buttonFreePressActionPerformed

    private void buttonStartBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartBatchActionPerformed
        ConfirmStart();
    }//GEN-LAST:event_buttonStartBatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFreePress;
    private javax.swing.JButton buttonStartBatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listBatch;
    private javax.swing.JScrollPane listPress;
    private javax.swing.JList listPress2;
    // End of variables declaration//GEN-END:variables
}
