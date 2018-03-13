package model;

import dao.ModelManager;
import entity.Model;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *  permet de créer un modèle de liste d'objets Model
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
   
    /**
     * Ajoute un modèle à la liste et le crée en bdd
     * @param model 
     */
    public void addModel(Model model)
    {
        ModelManager.add(model);
        this.mList.add(model);
        this.fireIntervalAdded(this, 0, this.mList.size());
    }

    public void removeModel(Model model) 
    {
        // à faire : si on n'a pas d'erreur ici, on fait le reste, sinon on affiche un message d'erreur
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
