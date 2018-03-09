/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import entity.Batch;
import javax.swing.JOptionPane;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */
public class ControlPanel extends StylePanel {

    private MainFrame parent;
    private Batch currentBatch;
    private int counter = 0;
    int goal;

    public ControlPanel(MainFrame frame) {
        initComponents();
        setVisible(true);
        this.parent = frame;

    }

<<<<<<< HEAD
    public void initControl()
    {
        if (parent.getCurrentPress() != null)
        {
            setCurrentPress(parent.getCurrentPress());
            labTitle.setText("Presse n°" + Integer.toString(currentBatch.getId()));   
            
         //   labBatchPiece.setText("Lot n°" + Integer.toString(dao.BatchManager.getOne(currentBatch).getId()));

=======
    public void initControl() {
        if (parent.getCurrentBatch() != null) {
            setCurrentBatch(parent.getCurrentBatch());
            goal = currentBatch.getPiecesNumber();
            labTitle.setText("Lot n°" + Integer.toString(currentBatch.getId()));
            labBatchPiece.setText("Presse n°" + Integer.toString(dao.PressManager.getOne(currentBatch).getId()));
            labModel.setText("Modèle de pièce : " + currentBatch.getModel());
            setProgression();
>>>>>>> master
        }
    }

    public void setProgression() {

        labProgressing.setText(counter + " pièce controlée(s) sur " + goal);

        if (counter == goal) {
            if (currentBatch.getState() == 3) {
                JOptionPane.showMessageDialog(null, "La saisie du lot est terminée.");
                dao.BatchManager.setStateFour(currentBatch);
                parent.changePanel(new ControlChoosePressPanel(parent));
            } else {
                JOptionPane.showMessageDialog(null, "Attention, la presse n'a pas été libérée correctement. Veuillez en référer à votre supérieur. "
                        + "Attendez son signal avant de terminer le lot");
                buttonValidate.setEnabled(false);

            }

        }
    }

    public void setCurrentBatch(Batch batch) {
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
        buttonBreak = new javax.swing.JButton();
        labModel = new javax.swing.JLabel();
        labProgressing = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

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
        buttonStopBatch.setText("Fin du contröle");
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

        buttonBreak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonBreak.setText("Mettre le contole en pause");
        buttonBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBreakActionPerformed(evt);
            }
        });

        labModel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labModel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labModel.setText("lab model");

        labProgressing.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labProgressing.setText("progression");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBrokenPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labHL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labHT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfHL, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(tfHT, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(tfBL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(buttonStopBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labProgressing, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222))))
            .addComponent(labBatchPiece, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labModel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labBatchPiece)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labModel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labHL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labHT))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labBL)
                            .addComponent(tfBL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labProgressing, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(tfBT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(labBT))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(cbBrokenPiece)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(buttonStopBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        if ((tool.CommonTools.isFloat(tfHT.getText())) && (tool.CommonTools.isFloat(tfHL.getText())) && (tool.CommonTools.isFloat(tfBT.getText())) && (tool.CommonTools.isFloat(tfBL.getText()))) {

            confirmStart();
            
            setProgression();
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez saisir l'intégrité de l'ensemble des dimensions.");
        }
    }//GEN-LAST:event_buttonValidateActionPerformed

    private void tfHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHLActionPerformed

    private void cbBrokenPieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBrokenPieceActionPerformed
        if (cbBrokenPiece.isSelected()) {
            tfHT.setText("0");
            tfHL.setText("0");
            tfBT.setText("0");
            tfBL.setText("0");
        }
    }//GEN-LAST:event_cbBrokenPieceActionPerformed

    private void buttonStopBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopBatchActionPerformed
        if (currentBatch.getState() == 3) {
            confirmStop();
        } else {
            JOptionPane.showMessageDialog(null, "Attention, la presse n'a pas été libérée correctement. Veuillez en référer à votre supérieur.");
        }

    }//GEN-LAST:event_buttonStopBatchActionPerformed

    private void buttonBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBreakActionPerformed

        confirmBreak();

    }//GEN-LAST:event_buttonBreakActionPerformed

    private void confirmBreak() {
        if (JOptionPane.showConfirmDialog(null, "Mettre le lot en pause ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean stop = dao.BatchManager.setBreak(currentBatch, (goal - counter + 1));
            if (stop) {
                JOptionPane.showMessageDialog(null, "Le lot a bien été mis en pause.");
                parent.changePanel(new ControlChoosePressPanel(parent));
            }
        }
    }

    private void confirmStop() {
        if (JOptionPane.showConfirmDialog(null, "Arrêter le lot ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dao.BatchManager.setStateFour(currentBatch);
            JOptionPane.showMessageDialog(null, "Le lot a bien été stoppé.");
            parent.changePanel(new ControlChoosePressPanel(parent));
        }
    }

    private void confirmStart() {
        if (JOptionPane.showConfirmDialog(null, "Valider la pièce ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (cbBrokenPiece.isSelected()) {
                if (JOptionPane.showConfirmDialog(null, "Attention, vous allez envoyer la pièce au rebut. Continuer ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dao.PieceManager.create(0, 0, 0, 0, currentBatch.getId());
                    tfHT.setText("");
                    tfHL.setText("");
                    tfBT.setText("");
                    tfBL.setText("");
                    cbBrokenPiece.setSelected(false);
                    counter++;
                }
            } else {
                dao.PieceManager.create(
                        Float.parseFloat(tfHT.getText()),
                        Float.parseFloat(tfHL.getText()),
                        Float.parseFloat(tfBT.getText()),
                        Float.parseFloat(tfBL.getText()),
                        currentBatch.getId()
                );
                tfHT.setText("");
                tfHL.setText("");
                tfBT.setText("");
                tfBL.setText("");
                counter++;
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBreak;
    private javax.swing.JButton buttonStopBatch;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JCheckBox cbBrokenPiece;
    private javax.swing.JLabel labBL;
    private javax.swing.JLabel labBT;
    private javax.swing.JLabel labBatchPiece;
    private javax.swing.JLabel labHL;
    private javax.swing.JLabel labHT;
    private javax.swing.JLabel labModel;
    private javax.swing.JLabel labProgressing;
    private javax.swing.JLabel labTitle;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField tfBL;
    private javax.swing.JTextField tfBT;
    private javax.swing.JTextField tfHL;
    private javax.swing.JTextField tfHT;
    // End of variables declaration//GEN-END:variables
}
