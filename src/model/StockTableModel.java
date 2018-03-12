package model;

import dao.StockManager;
import entity.Stock;
import java.util.Collections;
import java.util.List;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import tool.StockComparator;

/**
 * Modèle pour table de caisse
 * @author boilleau
 */
public class StockTableModel extends AbstractTableModel implements ListDataListener
{
    private List<Stock> stockList;  // la liste de stocks
    private List<String> columnNames; // la liste des noms de colonnes
    
    /**
     * Constructeur
     */
    public StockTableModel()
    {
        super();
        this.fillStockList();
        
        // on trie par ordre alphabétique des noms de modèle, puis des noms de catégorie
        Collections.sort(this.stockList, new StockComparator());
        
        this.columnNames = StockManager.colonnesStock();
        
    }
    
    /**
     * 
     */
    private void fillStockList()
    {
        this.stockList = StockManager.getAllStocks();
    }
    
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
     * Renvoie les classes des colonnes
     * @params columnIndex l'index de la colonne voulue
     * @return la classe de la colonne
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) 
    {
        Class clas = String.class;
        switch (columnIndex)
        {
            case 2: clas = Integer.class;
            break;
            case 3: clas = Integer.class;
            break;
        }
        return clas;
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
                valeur = stock.getModel().getName();
                break;
            case 1:
                valeur = stock.getCategory().toString();
                break;
            case 2:
                valeur = stock.getQuantity();
                break;
            case 3:
                valeur = stock.getLimit();
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

    /**
     * Change la quantité du stock ayant le modèle et la catégorie donnés
     * @param model
     * @param category
     * @param quantity 
     */
    public void changeQuantity(String model, String category, int quantity)
    {
        StockManager.changeQuantity(model, category, quantity);
        this.fillStockList();
	this.fireTableRowsUpdated(0, this.getRowCount());
    }
   
    
    	/**
	 * Renvoie le nom d'une colonne
	 * 
	 * @params i l'indice d'une colonne
	 * @return un string représentant le nom de la colonne i
	 */
	@Override
	public String getColumnName(int i)
	{
		return this.columnNames.get(i);
	}
}
