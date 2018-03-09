/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.PieceManager;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author boilleau
 * 
 */
public class ApplicationPurgeManagementPanel extends StylePanel {

    /**
     * Creates new form PurgePanel
     */
    
    private int nbPurge;
    
    public ApplicationPurgeManagementPanel() {
        initComponents();
        
        nbPurge =  PieceManager.getNbPurge();
        
        
        
        
        if (nbPurge <= 0)
        {
            labelNumberOfPiecesToPurge.setText("Purge impossible :");
            labelPurgeImpossible.setText("Aucune pièce ne date d'il y a plus d'un an.");
            buttonValidate.setEnabled(false);
        }
        else
        {
            labelNumberOfPiecesToPurge.setText(nbPurge + " pièces peuvent être supprimées du stock.");
            labelPurgeImpossible.setText("");
             buttonValidate.setEnabled(true);
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

        buttonValidate = new javax.swing.JButton();
        labelNumberOfPiecesToPurge = new javax.swing.JLabel();
        labelPurgeImpossible = new javax.swing.JLabel();

        buttonValidate.setText("Valider");
        buttonValidate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        labelNumberOfPiecesToPurge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNumberOfPiecesToPurge.setText("Label info purge");

        labelPurgeImpossible.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPurgeImpossible.setText("Label purge impossible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 260, Short.MAX_VALUE)
                .addComponent(labelPurgeImpossible)
                .addGap(288, 288, 288))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(labelNumberOfPiecesToPurge)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(labelNumberOfPiecesToPurge)
                .addGap(57, 57, 57)
                .addComponent(labelPurgeImpossible)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        if (nbPurge <= 0)
        {
            JOptionPane.showMessageDialog(null, "Erreur : toutes les pièces enregistrée dans la base de données datent de moins d'un an.");
        }
        
        else if (JOptionPane.showConfirmDialog(null,"Purger la base de donnée ? ", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            PieceManager.purge();
            JOptionPane.showMessageDialog(null, "La base de donnée à été purgée.");
        }
    }//GEN-LAST:event_buttonValidateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonValidate;
    private javax.swing.JLabel labelNumberOfPiecesToPurge;
    private javax.swing.JLabel labelPurgeImpossible;
    // End of variables declaration//GEN-END:variables
}
