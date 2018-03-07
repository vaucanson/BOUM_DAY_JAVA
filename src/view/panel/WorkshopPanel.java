/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import entity.Model;
import javax.swing.JCheckBox;
import model.ListPressModel;
import model.AllBatchListModel;
import model.ModelComboModel;
import model.StockUnderLimitTableModel;
import renderer.ModelComboRenderer;
import renderer.StockUnderLimitButtonRenderer;
import view.frame.popup.LaunchBatchWorkshopPopUpFrame;
import view.panel.StylePanel;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */
public class WorkshopPanel extends StylePanel {

   private MainFrame parent;
   private final model.AllBatchListModel blm = new AllBatchListModel();
   
    public WorkshopPanel(MainFrame parent) {
         initComponents();
        setVisible(true);
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStockUnderLimit = new javax.swing.JTable();
        javax.swing.JComboBox<Model> comboModel = new javax.swing.JComboBox<>();
        comboCategory = new javax.swing.JComboBox();
        labQuantitytitle = new javax.swing.JLabel();
        labLimitsTitle = new javax.swing.JLabel();
        labQuantity = new javax.swing.JLabel();
        labLimits = new javax.swing.JLabel();
        buttonResearch = new javax.swing.JButton();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("Pièces en quantité insuffisante :");

        tableStockUnderLimit.setModel(new StockUnderLimitTableModel());
        tableStockUnderLimit.setDefaultRenderer(Object.class, new renderer.StockUnderLimitTableRenderer());
        tableStockUnderLimit.setDefaultRenderer(Boolean.class, new renderer.StockUnderLimitTableRenderer());
        tableStockUnderLimit.getColumn("Action").setCellEditor(new StockUnderLimitButtonRenderer(new JCheckBox()));
        jScrollPane1.setViewportView(tableStockUnderLimit);

        comboModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboModel.setModel(new ModelComboModel());
        comboModel.setPreferredSize(new java.awt.Dimension(32, 60));
        comboModel.setRenderer(new ModelComboRenderer());
        comboModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelActionPerformed(evt);
            }
        });

        comboCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "catégorie" }));

        labQuantitytitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labQuantitytitle.setText("Quantité en stock :");

        labLimitsTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labLimitsTitle.setText("Seuil :");

        labQuantity.setText("XXX");

        labLimits.setText("XXX");

        buttonResearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonResearch.setText("Rechercher");
        buttonResearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboModel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCategory, 0, 161, Short.MAX_VALUE))
                        .addGap(316, 316, 316)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labQuantitytitle))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labLimitsTitle)
                            .addComponent(labLimits, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonResearch, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labQuantitytitle)
                    .addComponent(labLimitsTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labQuantity)
                        .addComponent(labLimits))
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(buttonResearch)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonResearch;
    private javax.swing.JComboBox comboCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLimits;
    private javax.swing.JLabel labLimitsTitle;
    private javax.swing.JLabel labQuantity;
    private javax.swing.JLabel labQuantitytitle;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTable tableStockUnderLimit;
    // End of variables declaration//GEN-END:variables
}
