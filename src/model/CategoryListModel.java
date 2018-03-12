package model;

import entity.Category;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractListModel;

/**
 *  permet de créer un modèle de liste pour l'objet Category
 * @author mattar
 */
public class CategoryListModel extends AbstractListModel<Category> {
    ArrayList<Category> cList = new ArrayList<>();
    
    public CategoryListModel()
    {
        cList = new ArrayList<Category>(Arrays.asList(Category.values()));
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
