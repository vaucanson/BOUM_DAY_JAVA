/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BatchManager;
import entity.Batch;
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class AllBatchListModel extends AbstractListModel<Batch> {
    private ArrayList<Batch> bList;
    
    public AllBatchListModel()
    {
        bList = BatchManager.fillList();
    }

    @Override
    public int getSize() {
       return bList.size();
    }

    @Override
    public Batch getElementAt(int index) {
        return bList.get(index);
    }
    
    
    
    public void add(Batch p)
    {
        if (p != null)
        {
            bList.add(p);
            fireIntervalAdded(bList, bList.size()-1, bList.size()-1);

        }
    }
  
    public void remove(Batch p)
    {
        if (p != null)
        {
            bList.remove(p);
            fireIntervalRemoved(bList, bList.size()-1, bList.size()-1);
        }
    }
}
