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
 * permet de créer un modèle de liste d'objets Stock
 * les objets Stock contenus dans cette liste sont issus de la view BDD "StockUnderLimit"
 * Il ne s'agit pas de tout ce qui est contenu dans la table Stock, seulement ce qui est en quantité insuffisante
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
