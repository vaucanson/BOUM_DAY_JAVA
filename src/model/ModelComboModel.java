package model;

import entity.Model;
import javax.swing.ComboBoxModel;

/**
 * permet de créer un modèle de ComboBox à partir d'une liste de Model
 * @author mattar
 */
public class ModelComboModel extends ModelListModel implements ComboBoxModel<Model> {

    private Model selected = null;
    
    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Model) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }    
}
