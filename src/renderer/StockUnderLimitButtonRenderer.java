/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package renderer;

import dao.ModelManager;
import entity.Model;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import view.frame.popup.LaunchBatchWorkshopPopUpFrame;

/**
 *
 * @author MATTAR
 */
public class StockUnderLimitButtonRenderer extends DefaultCellEditor{
    
    private JButton button;
    private final ButtonListener bListener = new ButtonListener();
    private String nomModel;
    private Model model;
    private LaunchBatchWorkshopPopUpFrame instance;
    
   
    public StockUnderLimitButtonRenderer(JCheckBox checkBox)
    {
        super(checkBox);
        
        
        button = new JButton("Lancer Lot");
        
        button.setOpaque(true);
        
        button.addActionListener(bListener);       
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column)
    {
        //On définit le numéro de ligne à notre listener
        bListener.setRow(row);
        
        
        //On passe aussi le tableau pour des actions potentielles
        bListener.setTable(table);
        
        return button;
    }
    
    
    // écouteur qui nous donne ce qu’il faut faire quand le bouton est appuyé
    class ButtonListener implements ActionListener
    {
        private int row;
        private JTable table;
        
        public void setRow(int row)
        {
            this.row = row;
        }
        
        public void setTable(JTable table)
        {
            this.table = table;
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            nomModel =  (String) table.getModel().getValueAt(row, 0);
            model = ModelManager.getModel(nomModel);
            
            // vérifie qu'un popup n'a pas deja été ouvert pour éviter les doublons
            if (instance == null || !instance.isVisible())
            {
                synchronized (LaunchBatchWorkshopPopUpFrame.class)
                {
                    if (instance == null || !instance.isVisible())
                    {
                        instance = new LaunchBatchWorkshopPopUpFrame(model, table);
                    }
                }
                stopCellEditing();
            }
        }
        
        
    }
}
