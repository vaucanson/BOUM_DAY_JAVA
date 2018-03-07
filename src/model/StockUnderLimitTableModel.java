/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import dao.BatchManager;
import dao.StockManager;
import entity.Stock;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MATTAR
 */
public class StockUnderLimitTableModel extends AbstractTableModel{
    
    ArrayList<Stock> sList = StockManager.loadStockUnderLimit();
    ArrayList<String> nomColonnes = StockManager.colonnesStock();
    
    public StockUnderLimitTableModel()
    {
        nomColonnes.add("Action");
        nomColonnes.add("Etat");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return nomColonnes.get(column);
    }
    
      
    @Override
    public int getRowCount() {
        return sList.size();
    }
    
    @Override
    public int getColumnCount() {
        return nomColonnes.size();
    }
    
   
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = "";
        Stock s = sList.get(rowIndex);
        
        
        switch (columnIndex)
        {
            case 0 : o = s.getModel().getName();
            break;
            case 1 : o = s.getCategory().getName();
            break;
            case 2 : o = s.getLimit();
            break;
            case 3 : o = s.getQuantity();
            break;
            case 5 : o = BatchManager.isLaunched(s.getModel().getName());
            break;
            
            default:;
            
        }
        return o;

    }
    
    // permet de dire que la 4e colonne (qui sera composée de bouton) sera éditable
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return (columnIndex==4 && getValueAt(rowIndex, 5)== Boolean.FALSE);
    }
    
    // permet de transformer la colonne concernant l'état du lot en classe Boolean
    // afin de préciser si le lot a deja été lancé
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clas = String.class;
        
        if (columnIndex == 5)
        {
            clas = Boolean.class;
        }
        return clas;
    }

}
