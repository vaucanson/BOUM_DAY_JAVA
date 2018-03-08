/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PressManager;
import entity.Press;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author badaroux
 */
public class ListBusyPressModel extends AbstractListModel<Press> {
    protected ArrayList<Press> pressList;

    public ListBusyPressModel() {
        pressList = PressManager.fillBusyPressList();

    }  
    
    public void addPress()
    {
        int i = dao.PressManager.add();
        
        Press press = new Press(i);
        pressList.add(press);
        fireIntervalAdded(pressList, pressList.size() - 1, pressList.size() - 1);
    }
    
    public void removePress(Press press)
    {
        dao.PressManager.remove(press.getId());
        pressList.remove(press);
        fireIntervalAdded(pressList, pressList.size() - 1, pressList.size() - 1);
    }
    
    @Override
    public int getSize() {
        return pressList.size();
    }

    @Override
    public Press getElementAt(int i) {
       return pressList.get(i);
    }

}
