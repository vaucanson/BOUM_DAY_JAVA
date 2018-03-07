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
        buttonEndBatch = new javax.swing.JButton();
        buttonStartBatch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listPress = new javax.swing.JScrollPane();
        listPress2 = new javax.swing.JList();

        setPreferredSize(new java.awt.Dimension(900, 500));

        listBatch.setModel(sblm);
        jScrollPane1.setViewportView(listBatch);

        buttonEndBatch.setText("Désafecter un lot");
        buttonEndBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEndBatchActionPerformed(evt);
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
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonEndBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listPress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listPress, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addComponent(buttonEndBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEndBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEndBatchActionPerformed
        FreePressProductionPopUpFrame.getInstance();
        

    }//GEN-LAST:event_buttonEndBatchActionPerformed

    private void buttonStartBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartBatchActionPerformed
        ConfirmStart();
    }//GEN-LAST:event_buttonStartBatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEndBatch;
    private javax.swing.JButton buttonStartBatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listBatch;
    private javax.swing.JScrollPane listPress;
    private javax.swing.JList listPress2;
    // End of variables declaration//GEN-END:variables
}
