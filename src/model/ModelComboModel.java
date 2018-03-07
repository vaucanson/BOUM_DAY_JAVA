package model;

import entity.Model;
import javax.swing.ComboBoxModel;

/**
 *
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
    
     @Override
    public void remove(Model mod) {
        super.remove(mod); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void add(Model mod) {
        super.add(mod); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
