package renderer;

import entity.Category;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author mattar
 */
public class CategoryComboRenderer extends CategoryListRenderer
{
    public Component getListCellRendererComponent(JList<? extends Category> list, Category cat, int index, boolean isSelected, boolean cellHasFocus) {
        if ( cat == null)
        {
            JLabel lab = new JLabel("choisissez une catégorie");
            lab.setOpaque(true);
            
            
            return lab;
        }
        else
            return super.getListCellRendererComponent(list, cat, index, isSelected, cellHasFocus);
    }
}
