package renderer;

import entity.Model;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author mattar
 */
public class ModelComboRenderer extends ModelListRenderer
{
    @Override
    public Component getListCellRendererComponent(JList<? extends Model> list, Model mod, int index, boolean isSelected, boolean cellHasFocus) {
        if ( mod == null)
        {
            JLabel lab = new JLabel("choisissez un modèle");
            lab.setOpaque(true);
            
            
            return lab;
        }
        else
            return super.getListCellRendererComponent(list, mod, index, isSelected, cellHasFocus);
    }
}