package model;

import dao.CategoryManagerOld;
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
        cList = new ArrayList(Category.values());
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
