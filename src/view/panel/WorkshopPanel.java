/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.StockManager;
import entity.Category;
import entity.Model;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import model.AllBatchListModel;
import model.CategoryComboModel;
import model.ModelComboModel;
import model.StockUnderLimitTableModel;
import renderer.CategoryComboRenderer;
import renderer.ModelComboRenderer;
import renderer.StockUnderLimitButtonRenderer;
import view.panel.StylePanel;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */
public class WorkshopPanel extends StylePanel {

   private MainFrame parent;
   private String nomModel;
   private String nomCategory;
   
   
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
        comboCategory = new javax.swing.JComboBox<Category>();
        labQuantitytitle = new javax.swing.JLabel();
        labLimitsTitle = new javax.swing.JLabel();
        labQuantity = new javax.swing.JLabel();
        labLimits = new javax.swing.JLabel();
        buttonResearch = new javax.swing.JButton();
        comboModel = new javax.swing.JComboBox<Model>();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("Pièces en quantité insuffisante :");

        tableStockUnderLimit.setModel(new StockUnderLimitTableModel());
        tableStockUnderLimit.setDefaultRenderer(Object.class, new renderer.StockUnderLimitTableRenderer());
        tableStockUnderLimit.setDefaultRenderer(Boolean.class, new renderer.StockUnderLimitTableRenderer());
        tableStockUnderLimit.getTableHeader().setReorderingAllowed(false);
        tableStockUnderLimit.getColumn("Action").setCellEditor(new StockUnderLimitButtonRenderer(new JCheckBox()));
        jScrollPane1.setViewportView(tableStockUnderLimit);

        comboCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCategory.setModel(new CategoryComboModel());
        comboCategory.setRenderer(new CategoryComboRenderer());
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        labQuantitytitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labQuantitytitle.setText("Quantité en stock :");

        labLimitsTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labLimitsTitle.setText("Seuil :");

        buttonResearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonResearch.setText("Rechercher");
        buttonResearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buttonResearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResearchActionPerformed(evt);
            }
        });

        comboModel.setRenderer(new ModelComboRenderer());
        comboModel.setModel(new ModelComboModel());
        comboModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelActionPerformed(evt);
            }
        });

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
                            .addComponent(comboCategory, 0, 228, Short.MAX_VALUE)
                            .addComponent(comboModel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(223, 223, 223)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labLimitsTitle)
                            .addComponent(labQuantitytitle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labQuantitytitle)
                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labLimitsTitle)
                        .addComponent(labLimits, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(buttonResearch)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResearchActionPerformed
 
        labQuantity.setText("");
        labLimits.setText("");
        
        labQuantity.setText(Integer.toString(StockManager.getQuantity(nomModel, nomCategory)));
        labLimits.setText(Integer.toString(StockManager.getLimit(nomModel, nomCategory)));
    }//GEN-LAST:event_buttonResearchActionPerformed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        Category cat = (Category) comboCategory.getSelectedItem();
        nomCategory = cat.getName();
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void comboModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelActionPerformed
        Model mod = (Model) comboModel.getSelectedItem();
        nomModel = mod.getName();
      
    }//GEN-LAST:event_comboModelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonResearch;
    private javax.swing.JComboBox<Category> comboCategory;
    private javax.swing.JComboBox<Model> comboModel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLimits;
    private javax.swing.JLabel labLimitsTitle;
    private javax.swing.JLabel labQuantity;
    private javax.swing.JLabel labQuantitytitle;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTable tableStockUnderLimit;
    // End of variables declaration//GEN-END:variables
}
