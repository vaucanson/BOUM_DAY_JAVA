package model;

import dao.ModelManager;
import entity.Model;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *  permet de créer un modèle de liste d'objets Model
 * @author mattar
 */
public class ModelActivelListModel extends AbstractListModel<Model> {
    
    private ArrayList<Model> mList;

    public ModelActivelListModel()
    {
        mList = ModelManager.loadActive();
    }
    
    @Override
    public int getSize() {
       return mList.size();
    }

    @Override
    public Model getElementAt(int index) {
        return mList.get(index);
    }
   
    /**
     * Ajoute un modèle à la liste et le crée en bdd
     * @param model 
     */
    public void addModel(Model model)
    {
        this.mList.add(model);
        this.fireIntervalAdded(this, 0, this.mList.size());
        ModelManager.add(model);
    }

    public void removeModel(Model model) 
    {
        this.mList.remove(model);
        ModelManager.delete(model);
        this.fireIntervalRemoved(this, 0, this.mList.size());
    }
}
