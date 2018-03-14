/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import entity.Batch;
import entity.Piece;
import javax.swing.JOptionPane;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */
public class ControlPanel extends StylePanel {

    private MainFrame parent;
    private Batch currentBatch;
    private int counter = 0; // compteur du nombre de pièce ayant déja été controlées
    int goal; // nombre de pièce dans le lot a controler

    public ControlPanel(MainFrame frame) {
        initComponents();
        setVisible(true);
        this.parent = frame;
    }

    /**
     * Méthode permettant d'initialiser les labels de la fenêtre.
     */
    public void initControl() {
        if (parent.getCurrentBatch() != null) {
            setCurrentBatch(parent.getCurrentBatch());

            goal = currentBatch.getPiecesNumber();
            labTitle.setText("Lot n°" + Integer.toString(currentBatch.getId()));
            labBatchPiece.setText("Presse n°" + Integer.toString(dao.PressManager.getOne(currentBatch).getId()));
            labModel.setText("Modèle de pièce : " + currentBatch.getModel().getName());
            progress();
        }
    }

    /**
     * Méthode permettant de faire progresser le label d'avancement du controle.
     * La méthode isEnded() est appelée à la fin afin de vérifier si l'ensemble
     * des pièces n'a pas été controlé
     */
    public void progress() {

        counter = dao.BatchManager.getPieceNumber(currentBatch);
        labProgressing.setText(counter + " pièce controlée(s) sur " + goal);
        isEnded();

    }

    /**
     * Méthode indiquant l'état de controle du lot. Si l'état de controle arrive
     * à son terme, la méthode changera l'état du lot et terminera toute
     * possibilité de controle dessus
     *
     * @return un booléen indiquant si le controle du lot est terminé en
     * s'appuyant sur le nombre de pièce limite à controler
     */
    public boolean isEnded() {

        boolean maxReached = false;

        // Si l'avancement du controle est inférieur au nombre de pièce du lot et 
        //que la presse a bien été libéré par le responsable de production, on termine le controle et passe le lot en état 4
        if (counter >= goal) {
            maxReached = true;
            if (currentBatch.getState() == 3) {
                JOptionPane.showMessageDialog(null, "La saisie du lot est terminée.");
                dao.BatchManager.setStateFour(currentBatch);
                parent.changePanel(new ControlChoosePressPanel(parent));

            } // Si le lot n'est pas encore en état 3, un message demande au controleur de soliciter son supérieur afin de libérer informatiquement la presse
            else {

                JOptionPane.showMessageDialog(null, "Attention, la presse n'a pas été libérée correctement. Veuillez en référer à votre supérieur. "
                        + "Attendez son signal avant de terminer le lot");
                buttonValidate.setEnabled(false);
            }
        } // si le controle a été terminé par un autre controleur, il faut également terminer le controle
        else if (currentBatch.getState() == 4) {
            JOptionPane.showMessageDialog(null, "Le lot a déja été cloturé, sortie", "Controle panel", JOptionPane.WARNING_MESSAGE);
            maxReached = true;
        }

        return maxReached;
    }

    public void setCurrentBatch(Batch batch) {
        this.currentBatch = batch;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labHL = new javax.swing.JLabel();
        labHT = new javax.swing.JLabel();
        labBL = new javax.swing.JLabel();
        labBT = new javax.swing.JLabel();
        cbBrokenPiece = new javax.swing.JCheckBox();
        buttonValidate = new javax.swing.JButton();
        buttonStopBatch = new javax.swing.JButton();
        labTitle = new javax.swing.JLabel();
        labBatchPiece = new javax.swing.JLabel();
        buttonBreak = new javax.swing.JButton();
        labModel = new javax.swing.JLabel();
        labProgressing = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfHL = new javax.swing.JFormattedTextField();
        tfHT = new javax.swing.JFormattedTextField();
        tfBL = new javax.swing.JFormattedTextField();
        tfBT = new javax.swing.JFormattedTextField();

        labHL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labHL.setText("HL");

        labHT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labHT.setText("HT");

        labBL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labBL.setText("BL");

        labBT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labBT.setText("BT");

        cbBrokenPiece.setBackground(getBackground());
        cbBrokenPiece.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBrokenPiece.setText("Pièce cassée");
        cbBrokenPiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBrokenPieceActionPerformed(evt);
            }
        });

        buttonValidate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonValidate.setText("Valider pièce");
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        buttonStopBatch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonStopBatch.setText("Fin du contröle");
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

        buttonBreak.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        tfHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHLActionPerformed(evt);
            }
        });

        tfHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labBatchPiece, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labModel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBrokenPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labHL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labHT)
                            .addComponent(labBL)
                            .addComponent(labBT))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHL)
                            .addComponent(tfHT)
                            .addComponent(tfBL)
                            .addComponent(tfBT))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonStopBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonBreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(labProgressing)))
                .addGap(0, 238, Short.MAX_VALUE))
            .addComponent(jSeparator1)
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
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labHL, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(tfHL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labHT)
                        .addComponent(labProgressing, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfBL))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfBT))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBrokenPiece)
                    .addComponent(buttonBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStopBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Lorsque le controleur appuie sur le bouton valider pièce, de nombreux
     * controles seront effectués afin de créer la bonne pièce
     *
     * @param evt
     */
    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed

        // si le lot est déja en état terminé, le controleur est automatiquement sorti de la fenetre
        if (currentBatch.getState() == 4) {
            JOptionPane.showMessageDialog(this, "Le lot a déja été cloturé", "Controle de pièce", JOptionPane.WARNING_MESSAGE);
            parent.changePanel(new ControlChoosePressPanel(parent));
        } else {
            // si le lot n'était pas terminé, nous devons regarder si la pièce est déclarée comme cassée. 
            //Si c'est le cas, nous lancons la procédure de validation de pièce sans effectuer de controles sur les champs de texte
            if (cbBrokenPiece.isSelected()) {
                confirmStart();

            } // Si la pièce a été mesurée, nous vérifions l'intégrité de toutes les données saisies avant de lancer la procédure de validation de la pièce
            else if ((!"0".equals(tfHT.getText())) && (!"0".equals(tfHL.getText())) && (!"0".equals(tfBT.getText())) && (!"0".equals(tfBL.getText()))) {
                if ((tool.CommonTools.isFloatPositive(tfHT.getText())) && (tool.CommonTools.isFloatPositive(tfHL.getText()))
                        && (tool.CommonTools.isFloatPositive(tfBT.getText())) && (tool.CommonTools.isFloatPositive(tfBL.getText()) && (!cbBrokenPiece.isSelected()))) {

                    confirmStart();

                } else {

                    JOptionPane.showMessageDialog(null, "Veuillez vérifier que les 4 champs de saisie soient bien des entiers positifs", "Controle de pièce", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erreur : au moins un des champs est à zéro.", "Controle de pièce", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonValidateActionPerformed

    /**
     * Si la checkbox cassée a été cochée, tous les champs de saisie sont
     * désactivés
     *
     * @param evt
     */
    private void cbBrokenPieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBrokenPieceActionPerformed
        if (cbBrokenPiece.isSelected()) {
            tfHT.setEnabled(false);
            tfHL.setEnabled(false);
            tfBT.setEnabled(false);
            tfBL.setEnabled(false);
        }
    }//GEN-LAST:event_cbBrokenPieceActionPerformed

    /**
     * Le bouton arreter le lot permet de casser le lot directement en état 4,
     * sans vue sur l'état du controle des pieces
     *
     * @param evt
     */
    private void buttonStopBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopBatchActionPerformed
        if (currentBatch.getState() == 3) {
            confirmStop();
        } else {
            JOptionPane.showMessageDialog(null, "Attention, la presse n'a pas été libérée correctement. Veuillez en référer à votre supérieur.",
                    "Controle de pièce", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonStopBatchActionPerformed

    // le bouton pause permet au controleur de revenir a l'écran de selection des lots, 
    //tout en gardant en mémoire l'état d'avancement du controle afin de pouvoir le reprendre au meme moment
    private void buttonBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBreakActionPerformed
        parent.changePanel(new ControlChoosePressPanel(parent));
    }//GEN-LAST:event_buttonBreakActionPerformed

    private void tfHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHLActionPerformed

    private void tfHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHTActionPerformed

    /**
     * Cette méthode demandera au controleur s'il est parfaitement certain de
     * vouloir stopper le lot
     */
    private void confirmStop() {
        if (JOptionPane.showConfirmDialog(null, "Arrêter le lot ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dao.BatchManager.setStateFour(currentBatch);
            JOptionPane.showMessageDialog(null, "Le lot a bien été stoppé.");
            parent.changePanel(new ControlChoosePressPanel(parent));
        }
    }

    /**
     * Cette méthode demandera au controleur s'il est certain de vouloir créer
     * la pièce.
     */
    private void confirmStart() {

        if (JOptionPane.showConfirmDialog(null, "Valider la pièce ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // Si le controleur souhaite valider la pièce, nous regardons si le controle est bien toujours en cours
            if (!isEnded()) {
                // Si le lot est toujours en cours, nous regardons si la case pièce cassée a été cochée. 
                //Si c'est le cas, nous créons une pièce avec 0 dans toutes les mesure ce qui l'enverra directement dans les rebuts
                if (cbBrokenPiece.isSelected()) {
                    if (JOptionPane.showConfirmDialog(null, "Attention, vous allez envoyer la pièce au rebut. Continuer ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        if (dao.PieceManager.create(0, 0, 0, 0, currentBatch.getId()) >= 0) {
                            tfHT.setEnabled(true);
                            tfHL.setEnabled(true);
                            tfBT.setEnabled(true);
                            tfBL.setEnabled(true);
                            cbBrokenPiece.setSelected(false);
                            progress();
                        }

                    }
                } // Si la pièce a été mesurée, nous récupérons toutes les mesures afin de créer 
                //une nouvelle pièce et de calculer sa catégorie, afin que le controleur puisse la mettre dans la bonne caisse
                else {
                    if (dao.PieceManager.create(
                            Float.parseFloat(tfHT.getText()),
                            Float.parseFloat(tfHL.getText()),
                            Float.parseFloat(tfBT.getText()),
                            Float.parseFloat(tfBL.getText()),
                            currentBatch.getId()
                    ) == 0) {
                        Piece p = new Piece(Float.parseFloat(tfHT.getText()), Float.parseFloat(tfHL.getText()),
                                Float.parseFloat(tfBT.getText()), Float.parseFloat(tfBL.getText()), currentBatch);

                        JOptionPane.showMessageDialog(this, "Catégorie : " + p.getCategory().toString());

                        tfHT.setText("");
                        tfHL.setText("");
                        tfBT.setText("");
                        tfBL.setText("");
                        progress();

                    }

                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBreak;
    private javax.swing.JButton buttonStopBatch;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JCheckBox cbBrokenPiece;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labBL;
    private javax.swing.JLabel labBT;
    private javax.swing.JLabel labBatchPiece;
    private javax.swing.JLabel labHL;
    private javax.swing.JLabel labHT;
    private javax.swing.JLabel labModel;
    private javax.swing.JLabel labProgressing;
    private javax.swing.JLabel labTitle;
    private javax.swing.JFormattedTextField tfBL;
    private javax.swing.JFormattedTextField tfBT;
    private javax.swing.JFormattedTextField tfHL;
    private javax.swing.JFormattedTextField tfHT;
    // End of variables declaration//GEN-END:variables
}
