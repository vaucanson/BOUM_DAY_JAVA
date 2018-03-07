/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package renderer;

import dao.BatchManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
        
        
        if ( column == 4 && table.getModel().getValueAt(row, 5)== Boolean.FALSE)
        {
            button = new JButton("Lancer Lot");
            return button;
            
        }
        else if (column == 5)
        {
            state = new JButton("");
            
            if (value.toString().equalsIgnoreCase("true"))
            {
                state.setBackground(Color.green);
                
            }
            else
            {
                state.setBackground(Color.red);
            }
            return state;
        }
        
        
        return lab;
    }
}

