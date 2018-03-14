/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import dao.StockManager;
import entity.Category;
import entity.Model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.CategoryComboModel;
import model.StockTableModel;
import renderer.CategoryComboRenderer;
import renderer.ModelComboRenderer;
import tool.MessageTool;
import view.frame.MainFrame;

/**
 *
 * @author mattar
 */
public class ShopPanel extends StylePanel {

    private MainFrame parent;
    private String logFileName;
    private StockTableModel tab = new StockTableModel();
    
    public ShopPanel(MainFrame parent) {
        initComponents();
        setVisible(true);
        this.parent = parent;
        
        this.logFileName = "stock_movements.log";
    }
    
    /**
     * Récupère les valeurs entrées par l'utilisateur et met à jour la quantité.
     */
    private void changeStock()
    {
        if (JOptionPane.showConfirmDialog(null,"Confirmez-vous ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
       {
            int quantity = (int) this.crateNumberSpinner.getValue();
            String model = ((Model) this.comboModel.getSelectedItem()).getName();
            String category = ((Category) this.comboCategory.getSelectedItem()).toString();
            
            if ((dao.StockManager.getQuantity(model, category) + quantity) < 0)
            {
                String message = String.format("Seulement %s caisses sont en stock, vous ne pouvez pas en supprimer %d", 
                                                    StockManager.getQuantity(model, category), 
                                                    -quantity); 
                
                MessageTool.popup("titre", message, 11);
                MessageTool.popup("Avertissement", message, 12);
                MessageTool.popup("Avertissement", message, 13);
                MessageTool.popup("Avertissement", message, 14);
                MessageTool.popup("Avertissement", message, 15);
                MessageTool.popup("Avertissement", message, 21);
                MessageTool.popup("Avertissement", message, 22);
                MessageTool.popup("Avertissement", message, 23);
                MessageTool.popup("Avertissement", message, 24);
                MessageTool.popup("Avertissement", message, 25);
                MessageTool.popup("Avertissement", message, 37);
                
//                JOptionPane.showMessageDialog(parent, "Seulement " + dao.StockManager.getQuantity(model, category) 
//                        + " caisses sont en stock, vous ne pouvez pas en supprimer " + -quantity);
            }
            else
            {
                ((StockTableModel) this.tabStock.getModel()).changeQuantity(model, category, quantity); 
            }
             

            // écriture dans l'historique

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String record = String.format("%s\t%s\t%s\t%d\n", dateFormat.format(date), model, category, quantity);
            
            this.writeHistory(record);
       }
    }
    
    
    private void showHistory()
    {
        FileInputStream fis = null;
        try 
        {
            fis = new FileInputStream(this.logFileName);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(ShopPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {  
            ObjectInputStream ois = new ObjectInputStream(fis);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ShopPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    private void writeHistory(String record)
    {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(this.logFileName);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(record);
          
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                // Close the writer regardless of what happens...
                writer.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
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

        comboCategory = new javax.swing.JComboBox<Category>();
        buttonOK = new javax.swing.JButton();
        comboModel = new javax.swing.JComboBox<Model>();
        crateNumberSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        buttonHistory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabStock = new javax.swing.JTable();
        labTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonRefresh = new javax.swing.JButton();

        comboCategory.setModel(new CategoryComboModel());
        comboCategory.setRenderer(new CategoryComboRenderer());

        buttonOK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonOK.setText("Valider");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        comboModel.setModel(new model.ModelComboModel());
        comboModel.setRenderer(new ModelComboRenderer());
        comboModel.setSelectedItem(new model.ModelComboModel());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de Caisses");

        buttonHistory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonHistory.setText("Historique des Entrées / Sorties");
        buttonHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHistoryActionPerformed(evt);
            }
        });

        tabStock.setModel(tab);
        tabStock.setDefaultRenderer(String.class, new renderer.CrateTableStringRenderer());

        tabStock.setDefaultRenderer(Integer.class, new renderer.StockTableIntegerRenderer());

        tabStock.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer()
            {
                {
                    setOpaque(true);
                }

                @Override
                public Component getTableCellRendererComponent(
                    final JTable table,
                    final Object value,
                    final boolean isSelected,
                    final boolean hasFocus,
                    final int row,
                    final int column)
                {
                    JLabel lab = new JLabel();
                    lab.setOpaque(true);

                    // la font
                    lab.setFont(lab.getFont().deriveFont(Font.BOLD));

                    // centrer le texte
                    lab.setHorizontalAlignment(SwingConstants.CENTER);

                    // le texte à afficher
                    String texte = String.format("%s", value.toString());
                    texte = texte.toUpperCase();

                    lab.setText(texte);
                    lab.setForeground(Color.WHITE);
                    lab.setBackground(Color.GRAY);

                    // renvoie le label
                    return lab;
                }
            });
            jScrollPane1.setViewportView(tabStock);

            labTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            labTitle.setText("GESTION DES STOCKS");

            buttonRefresh.setText("Rafraîchir");
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
                    .addContainerGap(52, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(crateNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(buttonOK)
                            .addGap(43, 43, 43)
                            .addComponent(buttonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(39, 39, 39))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(buttonRefresh)
                            .addGap(75, 75, 75)
                            .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(jSeparator1))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(crateNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE))
            );
        }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        this.changeStock(); 
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistoryActionPerformed
//        ShopHistoryPopUpFrame.getInstance();
        this.showHistory();
    }//GEN-LAST:event_buttonHistoryActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        tab = new StockTableModel();
        tabStock.setModel(tab);
    }//GEN-LAST:event_buttonRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHistory;
    private javax.swing.JButton buttonOK;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JComboBox<Category> comboCategory;
    private javax.swing.JComboBox<Model> comboModel;
    private javax.swing.JSpinner crateNumberSpinner;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTable tabStock;
    // End of variables declaration//GEN-END:variables
}
