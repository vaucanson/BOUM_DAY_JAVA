package model;

import dao.CategoryManager;
import entity.Category;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *  permet de créer un modèle de liste pour l'objet Category
 * @author mattar
 */
public class CategoryListModel extends AbstractListModel<Category> {
    ArrayList<Category> cList = new ArrayList<>();
    
    public CategoryListModel()
    {
        cList = CategoryManager.load();
    }

    @Override
    public int getSize() {
        return cList.size();
    }

    @Override
    public Category getElementAt(int index) {
        return cList.get(index);
    }
    
    
}
