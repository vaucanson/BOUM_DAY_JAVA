/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import dao.BatchManager;
import dao.StockManager;
import entity.Stock;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MATTAR
 */

/**
 * création d'un tableau de StockUnderLimit 
 */
public class StockUnderLimitTableModel extends AbstractTableModel{
    
    ArrayList<Stock> sList = StockManager.loadStockUnderLimit();
    ArrayList<String> nomColonnes = StockManager.colonnesStock();
    
    public StockUnderLimitTableModel()
    {
        /**
         * ajout de colonnes non présentes dans l'ArrayList<String>
         * la colonne Action permet au responsable d'Atelier de lancer un lot
         * la colonne Etat permet au responsable d'Atelier de savoir si un lot a deja été lancé pour le modèle de la ligne
         */
        nomColonnes.add("Action");      
        nomColonnes.add("Etat");
    }
    
    
    // rempli les noms des colonnes grace à l'ArrayList<String> et aux deux colonnes ajoutées dans le constructeur
    @Override
    public String getColumnName(int column) {
        return nomColonnes.get(column);
    }
    
    // permet de connaitre le nombre de lignes du tableau
    @Override
    public int getRowCount() {
        return sList.size();
    }
    
    // permet de connaitre le nombre de colonnes du tableau
    @Override
    public int getColumnCount() {
        return nomColonnes.size();
    }
    
    /**
     * cette fonction permet de remplir le tableau selon la ligne et la colonnes
     * @param rowIndex      est la ligne sur laquelle se trouve la cellule à remplir
     * @param columnIndex   est la colonne sur laquelle se trouve la cellule à rempir
     * @return              renvoie les Objets propres à chaque cellule pour les remplir
     */
        
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = "";
        Stock s = sList.get(rowIndex);
        
        
        switch (columnIndex)
        {
            case 0 : o = s.getModel().getName();            // la colonne concerne les modèles, la fonction récupère l'attribut "name" du Model ciblé
            break;
            case 1 : o = s.getCategory().toString();         // la colonne concerne la catégorie, la fonction récupère l'attribut "name" de la Category ciblée
            break;
            case 2 : o = s.getQuantity();                   // la colonne concerne la quantité de pièces en stock pour un modèle et une catégorie, renvoie un int
            break;
            case 3 : o = s.getLimit();                    // la colonne concerne le seuil pour un modèle et une catégorie, renvoie un int
            break;
            case 5 : o = BatchManager.isLaunched(s.getModel().getName());      // la colonne renvoie un boolean afin de savoir si un lot a deja été lancé pour le modèle concerné par la ligne
            break;
            
            default:;
            
        }
        return o;

    }
    
    /**
     *  permet de dire que la 4e colonne (qui sera composée de bouton) sera éditable
     * @param rowIndex      est la ligne sur laquelle se trouve la cellule concernée
     * @param columnIndex   est la colonne sur laquelle se trouve la cellule concernée
     * @return              renvoie un boolean qui détermine si la cellule est éditable
     */
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        // colonne 4 éditable que si - pour la même ligne - la colonne 5 renvoie un boolean false (aucun lot lancé)
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
