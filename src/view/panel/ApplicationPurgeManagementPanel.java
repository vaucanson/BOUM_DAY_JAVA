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
              
        initState();
        
       
    }
    
    // affiche les informations sur le panel en fonction de la date de création des pièces
    private void initState()
    {
        nbPurge =  PieceManager.getNbPurge(); // récupère le nombre de pièces créees il y a plus d'un an
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        buttonValidate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonValidate.setText("Valider");
        buttonValidate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        labelNumberOfPiecesToPurge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNumberOfPiecesToPurge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumberOfPiecesToPurge.setText("Label info purge");

        labelPurgeImpossible.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPurgeImpossible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPurgeImpossible.setText("Label purge impossible");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE LA PURGE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(labelNumberOfPiecesToPurge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelPurgeImpossible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(labelNumberOfPiecesToPurge)
                .addGap(98, 98, 98)
                .addComponent(labelPurgeImpossible)
                .addGap(77, 77, 77)
                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
       
        //s'il n'y a aucune pièce à purger
        if (nbPurge <= 0)
        {
            JOptionPane.showMessageDialog(null, "Erreur : toutes les pièces enregistrée dans la base de données datent de moins d'un an.");
        }
        // demande de confirmation avant de lancer la suppression des pièces concernées en base de donnée
        else if (JOptionPane.showConfirmDialog(null,"Purger la base de donnée ? ", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            PieceManager.purge();
            JOptionPane.showMessageDialog(null, "La base de donnée à été purgée.");
            
            // on actualise le panel pour redonner l'état actuel de la purge
            initState(); 
        }
    }//GEN-LAST:event_buttonValidateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonValidate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelNumberOfPiecesToPurge;
    private javax.swing.JLabel labelPurgeImpossible;
    // End of variables declaration//GEN-END:variables
}
