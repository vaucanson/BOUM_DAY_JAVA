package renderer;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author boilleau
 */
public class CrateTableBooleanRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, 
                                                    Object value, 
                                                    boolean isSelected, 
                                                    boolean hasFocus, 
                                                    int row, 
                                                    int column) 
    {
        JCheckBox cb = new JCheckBox();
        
        
        
        return cb;
    }
    
}
