package model;

import entity.Stock;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author boilleau
 */
public class StockTableModel extends AbstractTableModel
{
    private List<Stock> stockList;  // la liste de stocks
    
    /**
     * Nombre de lignes
     * @return un int donnant le nombre de lignes
     */
    @Override
    public int getRowCount() 
    {
        return this.stockList.size();
    }

    /**
     * Nombre de colonnes
     * @return un int donnant le nombre de colonnes
     */
    @Override
    public int getColumnCount() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Renvoie l'objet contenu à la case donnée
     * @param rowIndex l'index de la ligne
     * @param columnIndex l'index de la colonne
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object valeur = null;
        Stock stock = this.stockList.get(rowIndex);
        switch (columnIndex)
        {
        case 0:
                valeur = stock.getModel();
                break;
        case 1:
                valeur = stock.getCategory();
                break;
        case 2:
                valeur = stock.getQuantity();
                break;
        }
        return valeur;
    }
    
}
