package entity;

import dao.CategoryManager;
import java.util.ArrayList;

public enum Category 
{
    PETIT,
    MOYEN,
    GRAND,
    REBUT;
    
    private void setMinTolerance(float min)
    {
        // on enregistre en base de données
        CategoryManager.changeTolerance(this.toString(), this.getMinTolerance(), this.getMaxTolerance());
    }
    
    private void setMaxTolerance (float max)
    {
        CategoryManager.changeTolerance(this.toString(), this.getMinTolerance(), this.getMaxTolerance());
    }
    
    public float getMinTolerance()
    {
        return CategoryManager.getTolerance(this.toString())[0];
    }
    
    public float getMaxTolerance()
    {
        return CategoryManager.getTolerance(this.toString())[1];
    }
    
    /**
     * Donne la catégorie d'une mesure, d'après l'intervalle donné
     * @param interval un float
     * @return la catégorie correspondante
     */
    public static Category getCorrespondant(float interval)
    {
    	Category cat = Category.REBUT;
    	
    	if (interval < PETIT.getMinTolerance()) // si inférieur à small.min
    	{
    		cat = REBUT;
    	}
    	else if (interval < MOYEN.getMinTolerance()) // si entre small.min et medium.min
    	{
    		cat = PETIT;
    	}
    	else if (interval < MOYEN.getMaxTolerance()) // si entre medium.min et medium.max
    	{
    		cat = MOYEN;
    	}
    	else if (interval < GRAND.getMaxTolerance()) // si entre medium.max et big.max	
    	{
    		cat = GRAND;
    	}
    	else // si supérieur à big.max
    	{
    		cat = REBUT;
    	}
    	
	return cat;
    }
    
    
    public static ArrayList<Category> getCategory(float interval)
    {
    	ArrayList<Category> cat = new ArrayList<>();
    	
    	if (interval < PETIT.getMinTolerance()) // si inférieur à small.min
    	{
                cat.add(REBUT);
    	}
    	else if (interval < MOYEN.getMinTolerance()) // si entre small.min et medium.min
    	{
    		cat.add(PETIT);
    	}
        else if (interval < PETIT.getMaxTolerance()) // si entre medium.min et small.max
        {
            cat.add(PETIT);
            cat.add(MOYEN);
        }
        else if (interval < GRAND.getMinTolerance()) // si entre small.max et big.min
        {
            cat.add(MOYEN);
        }
    	else if (interval < MOYEN.getMaxTolerance()) // si entre bix.min et medium.max
    	{
    		cat.add(MOYEN);
                cat.add(GRAND);
    	}
    	else if (interval < GRAND.getMaxTolerance()) // si entre medium.max et big.max	
    	{
    		cat.add(GRAND);
    	}
    	else // si supérieur à big.max
    	{
    		cat.add(REBUT);
    	}
    	
	return cat;
    }
    
    
    /**
     * Donne la catégorie d'une pièce, d'après les deltas des quatre mesures
     * @param htInterval
     * @param hlInterval
     * @param btInterval
     * @param blInterval
     * @return une catégorie
     */
    public static Category get(float htInterval, float hlInterval, float btInterval, float blInterval)
    {
        Category cat = Category.REBUT;

        ArrayList<Category> htCat = Category.getCategory(htInterval);
        ArrayList<Category> hlCat = Category.getCategory(hlInterval);
        ArrayList<Category> btCat = Category.getCategory(btInterval);
        ArrayList<Category> blCat = Category.getCategory(blInterval);

//        if (htCat == hlCat && hlCat == btCat && btCat == blCat)
//        {
//            cat = htCat;
//        }
        
        // on ne retient dans htCat que les éléments communs à tous les autres
        htCat.retainAll(hlCat);
        htCat.retainAll(blCat);
        htCat.retainAll(btCat);
        
        // s'il ne reste rien, c'est qu'aucune catégorie n'était partagée par les quatre mesures
        if (htCat.isEmpty())
        {
            cat = Category.REBUT;
        }
        // s'il reste deux catégories, ça ne peut être que moyen et une autre, auquel cas notre pièce est moyen.
        else if (htCat.size() == 2)
        {
            cat = Category.MOYEN;
        }
        // s'il reste une seule catégorie, notre pièce est de celle-là.
        else cat = htCat.get(0);
        
        
        return cat;
    }
    
}