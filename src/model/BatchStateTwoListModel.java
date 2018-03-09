package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.BatchManager;
import entity.Batch;
import entity.Press;
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class BatchStateTwoListModel extends AbstractListModel<Batch> {
    private ArrayList<Batch> bList;
    
    public BatchStateTwoListModel()
    {
        bList = BatchManager.fillListStartBatch();
    }

    @Override
    public int getSize() {
       return bList.size();
    }

    @Override
    public Batch getElementAt(int index) {
        return bList.get(index);
    }
    
    public void launch(Batch batch, Press press)
    {
        dao.BatchManager.setStateTwo(batch, press);   
        bList.remove(batch);

        //TODO NE MARCHE PAS AVEC> UN SUEL
        fireIntervalAdded(bList, bList.size() - 1, bList.size() - 1);
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
