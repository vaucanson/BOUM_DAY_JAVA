/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.PieceManager;
import entity.Batch;
import entity.Piece;
import view.frame.popup.ControlCancelPopUpFrame;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */

public class ControlPanel extends StylePanel {

   private MainFrame parent;
   private Batch currentBatch;


   
    public ControlPanel(MainFrame frame) {
        initComponents();
        setVisible(true);
        this.parent = frame;
    
        
    }

    public void initControl()
    {
        if (parent.getCurrentPress() != null)
        {
            setCurrentPress(parent.getCurrentPress());
            labTitle.setText("Presse n°" + Integer.toString(currentBatch.getId()));   
            
         //   labBatchPiece.setText("Lot n°" + Integer.toString(dao.BatchManager.getOne(currentBatch).getId()));
         
        }

    }
    
    public void setCurrentPress(Batch batch) {
        this.currentBatch = batch;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labHL = new javax.swing.JLabel();
        tfHL = new javax.swing.JTextField();
        labHT = new javax.swing.JLabel();
        labBL = new javax.swing.JLabel();
        labBT = new javax.swing.JLabel();
        tfHT = new javax.swing.JTextField();
        tfBL = new javax.swing.JTextField();
        tfBT = new javax.swing.JTextField();
        cbBrokenPiece = new javax.swing.JCheckBox();
        buttonValidate = new javax.swing.JButton();
        buttonStopBatch = new javax.swing.JButton();
        labTitle = new javax.swing.JLabel();
        labBatchPiece = new javax.swing.JLabel();

        labHL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labHL.setText("HL");

        tfHL.setToolTipText("");
        tfHL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHLActionPerformed(evt);
            }
        });

        labHT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labHT.setText("HT");

        labBL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labBL.setText("BL");

        labBT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labBT.setText("BT");

        tfHT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tfBL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tfBT.setToolTipText("");
        tfBT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cbBrokenPiece.setBackground(new java.awt.Color(206, 216, 232));
        cbBrokenPiece.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBrokenPiece.setText("Pièce cassée");
        cbBrokenPiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBrokenPieceActionPerformed(evt);
            }
        });

        buttonValidate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonValidate.setText("Valider pièce");
        buttonValidate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        buttonStopBatch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonStopBatch.setText("Arrêt du lot");
        buttonStopBatch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buttonStopBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopBatchActionPerformed(evt);
            }
        });

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("num presse");

        labBatchPiece.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labBatchPiece.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBatchPiece.setText("lab batch piece");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbBrokenPiece)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labBT)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labHL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfHL, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(tfBT)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labHT)
                            .addComponent(labBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfBL, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(tfHT))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(buttonStopBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labBatchPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labBatchPiece)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labHL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labHT)
                    .addComponent(tfHT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(cbBrokenPiece)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labBL)
                    .addComponent(tfBL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labBT)
                            .addComponent(tfBT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonStopBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
//           ValidationControlerPopUpFrame.getInstance();
            Piece p = new Piece(3, 4, 5, 1, 1);
            PieceManager.insert(p);
    }//GEN-LAST:event_buttonValidateActionPerformed

    private void tfHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHLActionPerformed

    private void cbBrokenPieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBrokenPieceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBrokenPieceActionPerformed

    private void buttonStopBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopBatchActionPerformed
        ControlCancelPopUpFrame.getInstance(dao.BatchManager.getOne(currentBatch));
    }//GEN-LAST:event_buttonStopBatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStopBatch;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JCheckBox cbBrokenPiece;
    private javax.swing.JLabel labBL;
    private javax.swing.JLabel labBT;
    private javax.swing.JLabel labBatchPiece;
    private javax.swing.JLabel labHL;
    private javax.swing.JLabel labHT;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTextField tfBL;
    private javax.swing.JTextField tfBT;
    private javax.swing.JTextField tfHL;
    private javax.swing.JTextField tfHT;
    // End of variables declaration//GEN-END:variables
}
