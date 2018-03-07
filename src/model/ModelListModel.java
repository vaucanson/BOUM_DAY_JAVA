package model;

import dao.ModelManager;
import entity.Model;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author mattar
 */
public class ModelListModel extends AbstractListModel<Model> {
    
    private ArrayList<Model> mList;

    public ModelListModel()
    {
        mList = ModelManager.load();
    }
    
    @Override
    public int getSize() {
       return mList.size();
    }

    @Override
    public Model getElementAt(int index) {
        return mList.get(index);
    }
   
    
}
