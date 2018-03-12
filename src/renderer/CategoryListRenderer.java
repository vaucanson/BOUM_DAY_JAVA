package renderer;

import entity.Category;
import entity.Model;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author mattar
 */
public class CategoryListRenderer implements ListCellRenderer<Category> {

   
    public Component getListCellRendererComponent(JList<? extends Category> list, Category cat, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel lab = new JLabel(cat.toString());
        lab.setOpaque(true);
       
        if (isSelected)
       {
           lab.setForeground(Color.red);
       }
        
        return lab;
    }  
}
