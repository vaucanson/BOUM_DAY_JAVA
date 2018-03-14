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
        mList = ModelManager.loadAll();
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
        if (ModelManager.add(model) == 0)
        {
            this.mList.add(model);
        }
        else
        {
            this.mList = ModelManager.load();
        }
        this.fireIntervalAdded(this, 0, this.mList.size());
    }

    /**
     * Supprime le modèle donné de la bdd et de la liste
     * @param model 
     */
    public void removeModel(Model model) 
    {
        if (ModelManager.delete(model) == 0)
        {
            this.mList.remove(model); 
        }
        else
        {
            this.mList = ModelManager.load();
        }
        this.fireIntervalRemoved(this, 0, this.mList.size());
    }
    
}
