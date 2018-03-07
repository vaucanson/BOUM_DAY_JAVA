package renderer;

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
public class ModelListRenderer implements ListCellRenderer<Model>{
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Model> list, Model mod, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel lab = new JLabel(mod.getName());
        lab.setOpaque(true);
        
        
        return lab;
    }
}
