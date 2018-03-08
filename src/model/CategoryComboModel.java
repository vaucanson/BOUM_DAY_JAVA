package model;

import entity.Category;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 * permet de créer un modèle de ComboBox à partir de la liste de Category
 * @author mattar
 */
public class CategoryComboModel extends CategoryListModel implements ComboBoxModel<Category>
{
    private Category selected = null;

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Category) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
}
