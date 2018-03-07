package model;

import entity.Stock;
import java.util.List;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author boilleau
 */
public class StockTableModel extends AbstractTableModel implements ListDataListener
{
    private List<Stock> stockList;  // la liste de stocks
    private List<String> columnNames; // la liste des noms de colonnes
    
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
        return this.columnNames.size();
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

    /**
     * Sur événement d'ajout d'un intervalle.
     * Déclenche l'événement lignes insérées
     * @param e un ListDataEvent
     */
    @Override
    public void intervalAdded(ListDataEvent e) {
	this.fireTableRowsInserted(0, this.getRowCount());
    }

    /**
     * Sur événement de suppression d'un intervalle.
     * Déclenche l'événement lignes supprimées.
     * @param e 
     */
    @Override
    public void intervalRemoved(ListDataEvent e) {
	this.fireTableRowsDeleted(0, this.getRowCount());
    }

    /**
     * Sur événement de changement de contenu.
     * Déclenche l'événement lignes modifiées
     * @param e 
     */
    @Override
    public void contentsChanged(ListDataEvent e) {
	this.fireTableRowsUpdated(0, this.getRowCount());
    }

   
}
