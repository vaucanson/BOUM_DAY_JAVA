/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import entity.Batch;
import entity.Press;
import view.frame.popup.ProductionSetPressFreePopUpFrame;
import javax.swing.JOptionPane;
import model.PressListModel;
import model.BatchStateTwoListModel;
import view.frame.MainFrame;

/**
 *
 * @author mattar
 */
public class ProductionPanel extends StylePanel {

    private MainFrame parent;
    private model.BatchStateTwoListModel sblm = new BatchStateTwoListModel();
    private model.PressListModel lpm = new PressListModel();

    public ProductionPanel(MainFrame parent) {
        initComponents();
        setVisible(true);
        this.parent = parent;
    }

    /**
     * Choix du lancement de la production.
     */
    private void ConfirmStart() {
        if ((listBatch.getSelectedValue() != null) && (listPress.getSelectedValue() != null)) {
            if (JOptionPane.showConfirmDialog(null, "Lancer la production ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                sblm.launch((Batch) listBatch.getSelectedValue(), (Press) listPress.getSelectedValue());
                lpm.removePress((Press) listPress.getSelectedValue());
            }
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Merci de selectionner une presse + un lot avant de lancer la production"); 
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
        jScrollPaneListPress = new javax.swing.JScrollPane();
        listPress = new javax.swing.JList();

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
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lancement de Production");

        listPress.setModel(lpm);
        jScrollPaneListPress.setViewportView(listPress);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEndBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneListPress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneListPress, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(buttonStartBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(buttonEndBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEndBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEndBatchActionPerformed
        ProductionSetPressFreePopUpFrame.getInstance();


    }//GEN-LAST:event_buttonEndBatchActionPerformed

    private void buttonStartBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartBatchActionPerformed
        ConfirmStart();
    }//GEN-LAST:event_buttonStartBatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEndBatch;
    private javax.swing.JButton buttonStartBatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneListPress;
    private javax.swing.JList listBatch;
    private javax.swing.JList listPress;
    // End of variables declaration//GEN-END:variables
}
