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

/**
 *
 * @author badaroux
 */
public class BatchStateTwoOrThreeListModel extends AbstractListModel<Batch> {
    protected ArrayList<Batch> batchList;

    public BatchStateTwoOrThreeListModel() {
        
        batchList = BatchManager.fillListStopBatch();


    }  

    @Override
    public int getSize() {
        return batchList.size();
    }

    @Override
    public Batch getElementAt(int i) {
       return batchList.get(i);
    }

}
