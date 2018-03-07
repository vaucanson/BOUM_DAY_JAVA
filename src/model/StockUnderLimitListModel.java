/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.StockManager;
import entity.Batch;
import entity.Stock;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author mattar
 */
public class StockUnderLimitListModel extends AbstractListModel<Stock> {
    private ArrayList<Stock> sList;
    
    public StockUnderLimitListModel()
    {
        sList = StockManager.loadStockUnderLimit();
    }


    public int getSize() {
       return sList.size();
    }


    public Stock getElementAt(int index) {
        return sList.get(index);
    }

}
