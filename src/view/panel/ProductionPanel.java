/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.BatchManager;
import dao.PressManager;
import entity.Batch;
import entity.Press;
import view.frame.popup.ProductionSetPressFreePopUpFrame;
import javax.swing.JOptionPane;
import model.PressListModel;
import model.BatchStateTwoListModel;
import renderer.BatchListRenderer;
import renderer.PressListRenderer;
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
     * Choix du lancement de la production. Nous vérifions préalablement qu'une valeur est bien selectionné. 
     */
    private void ConfirmStart() {
        if ((listBatch.getSelectedValue() != null) && (listPress.getSelectedValue() != null)) {
            if (JOptionPane.showConfirmDialog(null, "Lancer la production ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                sblm.launch((Batch) listBatch.getSelectedValue(), (Press) listPress.getSelectedValue());
              
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
        jSeparator1 = new javax.swing.JSeparator();
        buttonRefresh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 500));

        listBatch.setModel(sblm);
        listBatch.setCellRenderer(new BatchListRenderer());
        jScrollPane1.setViewportView(listBatch);

        buttonEndBatch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonEndBatch.setText("Désafecter un lot");
        buttonEndBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEndBatchActionPerformed(evt);
            }
        });

        buttonStartBatch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonStartBatch.setText("Demarrer Lot");
        buttonStartBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartBatchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lancement de Production");

        listPress.setModel(lpm);
        listPress.setCellRenderer(new PressListRenderer());
        jScrollPaneListPress.setViewportView(listPress);

        buttonRefresh.setText("Rafraîchir");
        buttonRefresh.setToolTipText("<html>Mettre à jour la liste des lots et la liste des presses</html>");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonRefresh)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonEndBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneListPress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStartBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneListPress, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(buttonEndBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ouvre le popup qui présente tous les lots à libérer
     * @param evt 
     */
    private void buttonEndBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEndBatchActionPerformed
        ProductionSetPressFreePopUpFrame.getInstance();


    }//GEN-LAST:event_buttonEndBatchActionPerformed

    private void buttonStartBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartBatchActionPerformed
       if ((PressManager.isActive((Press)listPress.getSelectedValue()) && (PressManager.isFree((Press)listPress.getSelectedValue()))))
       {
           if (BatchManager.getState((Batch)listBatch.getSelectedValue()) == 1)
           {
            ConfirmStart();
            buttonRefreshActionPerformed(evt);
           }
           else
           {
                JOptionPane.showMessageDialog(this, "Erreur : l'état du lot selectionné été modifié", "Gestion de Production", JOptionPane.OK_OPTION);
                buttonRefreshActionPerformed(evt);
           }
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Erreur : l'état de la presse selectionnée été modifié", "Gestion de Production", JOptionPane.OK_OPTION);
           buttonRefreshActionPerformed(evt);
       }
    }//GEN-LAST:event_buttonStartBatchActionPerformed

    /**
     * Bouton de rafraichissement de la liste, charge un nouveau modèle
     * @param evt 
     */
    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        sblm = new BatchStateTwoListModel();
        lpm = new PressListModel();
        
        listBatch.setModel(sblm);
        listPress.setModel(lpm);
    }//GEN-LAST:event_buttonRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEndBatch;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonStartBatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneListPress;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listBatch;
    private javax.swing.JList listPress;
    // End of variables declaration//GEN-END:variables
}
