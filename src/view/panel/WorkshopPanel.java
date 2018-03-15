/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.BatchManager;
import dao.StockManager;
import entity.Category;
import entity.Model;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.CategoryComboModel;
import model.StockUnderLimitTableModel;
import renderer.CategoryComboRenderer;
import renderer.ModelComboRenderer;
import renderer.StockUnderLimitButtonRenderer;
import renderer.StockUnderLimitTableRenderer;
import view.panel.StylePanel;
import view.frame.MainFrame;

/**
 *
 * @author badaroux
 */
public class WorkshopPanel extends StylePanel {

   private MainFrame parent;    // il s'agit de la frame sur laquelle s'affiche le panel
   private String nomModel; 
   private String nomCategory;
   private Model model;
   private StockUnderLimitTableModel tab = new StockUnderLimitTableModel();
   
   
   
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
        butLaunchBatch = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        labQuantityBatch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        buttonRefresh = new javax.swing.JButton();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("PIECE EN QUANTITE INSUFFISANTE");

        tableStockUnderLimit.setModel(tab);
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

        labQuantity.setText("(quantité)");

        labLimits.setText("(seuil limite)");

        buttonResearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonResearch.setText("Rechercher");
        buttonResearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResearchActionPerformed(evt);
            }
        });

        comboModel.setRenderer(new ModelComboRenderer());
        comboModel.setModel(new model.ModelActiveComboModel());
        comboModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelActionPerformed(evt);
            }
        });

        butLaunchBatch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        butLaunchBatch.setText("Lancer Lot");
        butLaunchBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLaunchBatchActionPerformed(evt);
            }
        });

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        labQuantityBatch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labQuantityBatch.setText("Nombre de pièces à créer :");

        buttonRefresh.setText("Rafraîchir");
        buttonRefresh.setToolTipText("<html>Mettre à jour la liste des pièces</html>");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(buttonRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonResearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(labQuantityBatch)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labLimits)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labQuantitytitle)
                                    .addComponent(labLimitsTitle))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butLaunchBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butLaunchBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labQuantitytitle)
                                    .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(buttonResearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labLimits, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labLimitsTitle))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labQuantityBatch)
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResearchActionPerformed
        
        // oblige a selectionner un modèle et une catégorie
         if ((comboModel.getSelectedIndex() > -1) && (comboCategory.getSelectedIndex() > -1))
        {
        // appel la fonction getQuantity qui renvoie la quantité de pièces pour un modèle et une catégorie donnée
        labQuantity.setText(Integer.toString(StockManager.getQuantity(nomModel, nomCategory)));
        
        // appel la fonction getLimit qui renvoie le seuil limite de pièces en stock pour un modèle et une catégorie donnée
        labLimits.setText(Integer.toString(StockManager.getLimit(nomModel, nomCategory)));
        }
         else
         {
             JOptionPane.showMessageDialog(this, "Veuillez selectionner un modèle et une catégorie", "Recherche de stock", JOptionPane.OK_OPTION);

         }
        
    }//GEN-LAST:event_buttonResearchActionPerformed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        
        // permet de relever le String de l'objet Category ciblé par la ComboBox
        Category cat = (Category) comboCategory.getSelectedItem();
        nomCategory = cat.toString();
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void comboModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelActionPerformed
        
        // permet de relever le String de l'objet Model ciblé par la ComboBox
        model = (Model) comboModel.getSelectedItem();
        nomModel = model.getName();
      
    }//GEN-LAST:event_comboModelActionPerformed

    private void butLaunchBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLaunchBatchActionPerformed
       
        // si aucun modèle n'a été saisie dans la comboBox
        if (comboModel.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(null, "Veuillez saisir un modèle.", "Lancement de lot", JOptionPane.OK_OPTION);
        }
        else if (((int)quantitySpinner.getValue() == 0) || ((int)quantitySpinner.getValue() < 0))        // permet d'informer l'utilisateur qu'il ne peut lancer un lot de 0 pièces
       {
           JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité supérieure à zéro.", "Lancement de lot", JOptionPane.OK_OPTION);
       }
       
       //demande de confirmation pour éviter les erreurs de manipulation
       else if (JOptionPane.showConfirmDialog(null,"Lancer le lot ? ", "Confirmation de lancement de lot", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
       {
          BatchManager.setStateOne(model, (int)quantitySpinner.getValue());
          JOptionPane.showMessageDialog(null, "Un lot contenant " + quantitySpinner.getValue() + " pièces de modèle " + model.getName() + " a bien été lancé.");         
       }
        buttonRefreshActionPerformed(evt);
    }//GEN-LAST:event_butLaunchBatchActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        //rafraichi le panel
        tab = new StockUnderLimitTableModel();
        tableStockUnderLimit.setModel(tab); 
       

        tableStockUnderLimit.getColumn("Action").setCellEditor(new StockUnderLimitButtonRenderer(new JCheckBox()));
       
        
        
    }//GEN-LAST:event_buttonRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLaunchBatch;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonResearch;
    private javax.swing.JComboBox<Category> comboCategory;
    private javax.swing.JComboBox<Model> comboModel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labLimits;
    private javax.swing.JLabel labLimitsTitle;
    private javax.swing.JLabel labQuantity;
    private javax.swing.JLabel labQuantityBatch;
    private javax.swing.JLabel labQuantitytitle;
    private javax.swing.JLabel labTitle;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTable tableStockUnderLimit;
    // End of variables declaration//GEN-END:variables
}
