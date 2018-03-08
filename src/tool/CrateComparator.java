package tool;

import entity.Stock;
import java.util.Comparator;

/**
 * Compare deux Stocks. 
 * On teste l'ordre alphabétique des noms de modèle, et en cas d'égalité l'ordre alphabétique des noms de catégorie. 
 * @author boilleau
 */
public class CrateComparator implements Comparator<Stock>
{

    @Override
    public int compare(Stock o1, Stock o2) 
    {
        int retour = -1;
        
        if (o1.getModel().getName().compareTo(o2.getModel().getName()) > 0)
        {
            retour = 2;  
        }
        else if ( o1.getModel().getName().compareTo(o2.getModel().getName()) == 0 && o1.getCategory().getName().compareTo(o2.getCategory().getName()) > 0 )
        {
           retour = 1;
        }
        
        return retour;
    }
    
}
