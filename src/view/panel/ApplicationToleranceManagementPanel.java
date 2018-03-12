/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package view.panel;

import dao.CategoryManager;
import javax.swing.JOptionPane;
import tool.CommonTools;

/**
 *
 * @author boilleau
 */
public class ApplicationToleranceManagementPanel extends StylePanel {
    
    /**
     * Creates new form TolerancePanel
     */
    
    private float[] smallTolerance = new float[2];
    private float[] mediumTolerance = new float[2];
    private float[] bigTolerance = new float[2];
    
    public ApplicationToleranceManagementPanel() {
        initComponents();
        initFields();
        
    }
    
    private void initFields()
    {
        smallTolerance = CategoryManager.getTolerance(labelSmall.getText());
        mediumTolerance = CategoryManager.getTolerance(labelMedium.getText());
        bigTolerance = CategoryManager.getTolerance(labelBig.getText());
        
        textLittleMin.setText(Float.toString(smallTolerance[0]));
        textLittleMax.setText(Float.toString(smallTolerance[1]));
        if (buttonChangeLittle.getText().equalsIgnoreCase("Modifier"))
        {
            textLittleMin.setEditable(false);
            textLittleMax.setEditable(false);
        }
        
        textMediumMin.setText(Float.toString(mediumTolerance[0]));
        textMediumMax.setText(Float.toString(mediumTolerance[1]));
        
        if (buttonChangeMedium.getText().equalsIgnoreCase("Modifier"))
        {
            textMediumMin.setEditable(false);
            textMediumMax.setEditable(false);
        }
        
        textBigMin.setText(Float.toString(bigTolerance[0]));
        textBigMax.setText(Float.toString(bigTolerance[1]));
        
        if (buttonChangeBig.getText().equalsIgnoreCase("Modifier"))
        {
            textBigMin.setEditable(false);
            textBigMax.setEditable(false);
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

        labelPresentation = new javax.swing.JLabel();
        labelSmall = new javax.swing.JLabel();
        labelMedium = new javax.swing.JLabel();
        labelBig = new javax.swing.JLabel();
        textLittleMin = new javax.swing.JTextField();
        textMediumMin = new javax.swing.JTextField();
        textBigMin = new javax.swing.JTextField();
        textLittleMax = new javax.swing.JTextField();
        textMediumMax = new javax.swing.JTextField();
        textBigMax = new javax.swing.JTextField();
        buttonChangeLittle = new javax.swing.JButton();
        buttonChangeMedium = new javax.swing.JButton();
        buttonChangeBig = new javax.swing.JButton();
        labMinTolerance = new javax.swing.JLabel();
        labMaxTolerance = new javax.swing.JLabel();

        labelPresentation.setText("Intervalles de tolérance par catégories :");

        labelSmall.setText("Petit");

        labelMedium.setText("Moyen");

        labelBig.setText("Grand");

        textLittleMin.setText(Float.toString(smallTolerance[1]));
        textLittleMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLittleMinActionPerformed(evt);
            }
        });

        textLittleMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLittleMaxActionPerformed(evt);
            }
        });

        buttonChangeLittle.setText("Modifier");
        buttonChangeLittle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeLittleActionPerformed(evt);
            }
        });

        buttonChangeMedium.setText("Modifier");
        buttonChangeMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeMediumActionPerformed(evt);
            }
        });

        buttonChangeBig.setText("Modifier");
        buttonChangeBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeBigActionPerformed(evt);
            }
        });

        labMinTolerance.setText("Tolérance Minimale");

        labMaxTolerance.setText("Tolérance Maximale");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPresentation)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labMinTolerance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labMaxTolerance))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelSmall)
                                .addComponent(labelMedium))
                            .addComponent(labelBig))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textMediumMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textLittleMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBigMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBigMax, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textMediumMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(textLittleMax, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(11, 11, 11)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChangeMedium, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonChangeLittle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonChangeBig, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(labelPresentation)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labMinTolerance)
                    .addComponent(labMaxTolerance))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLittleMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLittleMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeLittle)
                    .addComponent(labelSmall))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMediumMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMediumMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeMedium)
                    .addComponent(labelMedium))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBig)
                    .addComponent(textBigMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBigMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeBig))
                .addGap(131, 131, 131))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void textLittleMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLittleMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLittleMinActionPerformed
    
    private void textLittleMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLittleMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLittleMaxActionPerformed
    
    private void buttonChangeLittleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeLittleActionPerformed
        
        if (buttonChangeLittle.getText().equalsIgnoreCase("Modifier"))
        {
            textLittleMin.setEditable(true);
            textLittleMax.setEditable(true);
            
            buttonChangeLittle.setText("Valider");
        }
        else
        {
            if (JOptionPane.showConfirmDialog(null,"Valider les changements d'intervalles ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                if (CommonTools.isFloatNegative(textLittleMin.getText()) && CommonTools.isFloatNegative(textLittleMax.getText()) && (Float.parseFloat(textLittleMin.getText()) > Float.parseFloat(textLittleMax.getText())))
                {
                    CategoryManager.changeTolerance(labelSmall.getText(), Float.parseFloat(textLittleMin.getText()), Float.parseFloat(textLittleMax.getText()));
                    buttonChangeLittle.setText("Modifier");
                    initFields();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Erreur : veuillez entrer des nombres décimaux et négatifs. Assurez-vous que la valeur maximale soit supérieure à la valeur minimale.");
                }
            }
        }
        
    }//GEN-LAST:event_buttonChangeLittleActionPerformed
    
    private void buttonChangeMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeMediumActionPerformed
        
        if (buttonChangeMedium.getText().equalsIgnoreCase("Modifier"))
        {
            textMediumMin.setEditable(true);
            textMediumMax.setEditable(true);
            
            buttonChangeMedium.setText("Valider");
        }
        else
        {
            
            if (JOptionPane.showConfirmDialog(null,"Valider les changements d'intervalles ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                
                if (CommonTools.isFloatNegative(textMediumMin.getText()) && CommonTools.isFloatPositive(textMediumMax.getText()) && (Float.parseFloat(textMediumMin.getText()) < Float.parseFloat(textMediumMax.getText())))
                {
                    
                    CategoryManager.changeTolerance(labelMedium.getText(), Float.parseFloat(textMediumMin.getText()), Float.parseFloat(textMediumMax.getText()));
                    buttonChangeMedium.setText("Modifier");
                    initFields();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Erreur : veuillez entrer des nombres décimaux. Entrer un nombre négatif pour le minimum, et positif pour le maximum.");
                }
            }
        }
    }//GEN-LAST:event_buttonChangeMediumActionPerformed
    
    private void buttonChangeBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeBigActionPerformed
         if (buttonChangeBig.getText().equalsIgnoreCase("Modifier"))
            {
                textBigMin.setEditable(true);
                textBigMax.setEditable(true);
                
                buttonChangeBig.setText("Valider");
            }
            else
            {
                if (JOptionPane.showConfirmDialog(null,"Valider les changements d'intervalles ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    if (CommonTools.isFloatPositive(textBigMin.getText()) && CommonTools.isFloatPositive(textBigMax.getText()) && (Float.parseFloat(textBigMin.getText()) < Float.parseFloat(textBigMax.getText())) )
                    {
                        CategoryManager.changeTolerance(labelBig.getText(), Float.parseFloat(textBigMin.getText()), Float.parseFloat(textBigMax.getText()));
                        buttonChangeBig.setText("Modifier");
                        initFields();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Erreur : veuillez entrer des nombres décimaux positifs. Assurez-vous que la valeur maximale soit supérieure à la valeur minimale.");
                    }
                }
            }
    }//GEN-LAST:event_buttonChangeBigActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeBig;
    private javax.swing.JButton buttonChangeLittle;
    private javax.swing.JButton buttonChangeMedium;
    private javax.swing.JLabel labMaxTolerance;
    private javax.swing.JLabel labMinTolerance;
    private javax.swing.JLabel labelBig;
    private javax.swing.JLabel labelMedium;
    private javax.swing.JLabel labelPresentation;
    private javax.swing.JLabel labelSmall;
    private javax.swing.JTextField textBigMax;
    private javax.swing.JTextField textBigMin;
    private javax.swing.JTextField textLittleMax;
    private javax.swing.JTextField textLittleMin;
    private javax.swing.JTextField textMediumMax;
    private javax.swing.JTextField textMediumMin;
    // End of variables declaration//GEN-END:variables
}
