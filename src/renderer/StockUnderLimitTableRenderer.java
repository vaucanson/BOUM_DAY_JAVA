/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author MATTAR
 */
public class StockUnderLimitTableRenderer implements TableCellRenderer{
    
    private JButton button;
    private JButton state;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lab = new JLabel(value.toString());
        lab.setOpaque(true);
        
        /**
         * le bouton n'apparait que si la colonne état est à false (en rouge)
         */
        if ( column == 4 && table.getModel().getValueAt(row, 5)== Boolean.FALSE)
        {
            button = new JButton("Lancer Lot");
            return button;
            
        }
        // défini la couleur des cellules de colonne État
        else if (column == 5)
        {
            state = new JButton("");
            
            if (value.toString().equalsIgnoreCase("true"))
            {
                state.setBackground(Color.green);                   // vert si un lot a été lancé pour le modèle associé
                
            }
            else
            {
                state.setBackground(Color.red);                     // rouge si aucun lot n'a été lancé pour le modèle associé
            }
            return state;
        }
        
        
        return lab;
    }
}

