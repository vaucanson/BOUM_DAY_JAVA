package renderer;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author boilleau
 */
public class CrateTableIntegerRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, 
                                                    Object value, 
                                                    boolean isSelected, 
                                                    boolean hasFocus, 
                                                    int row, 
                                                    int column) 
    {
        JLabel lab = new JLabel(value.toString());
        lab.setOpaque(true);
        
        return lab;
    }
    
}
