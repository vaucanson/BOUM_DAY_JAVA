package entity;

import dao.CategoryManager;

public enum Category 
{
    PETIT(CategoryManager.getTolerance("PETIT")[0], CategoryManager.getTolerance("PETIT")[1]),
    MOYEN(CategoryManager.getTolerance("MOYEN")[0], CategoryManager.getTolerance("MOYEN")[1]),
    GRAND(CategoryManager.getTolerance("GRAND")[0], CategoryManager.getTolerance("GRAND")[1]),
    REBUT(0, 0);
    
    private float minTolerance;
    private float maxTolerance;
    
    private Category (float min, float max)
    {
        this.minTolerance = min;
        this.maxTolerance = max;
    }
    
    private void setMinTolerance(float min)
    {
        // on change la valeur dans l'instance
        this.minTolerance = min;
        // on enregistre en base de données
        CategoryManager.changeTolerance(this.toString(), this.getMinTolerance(), this.getMaxTolerance());
    }
    
    private void setMaxTolerance (float max)
    {
        this.maxTolerance = max;
        CategoryManager.changeTolerance(this.toString(), this.getMinTolerance(), this.getMaxTolerance());
    }
    
    public float getMinTolerance()
    {
        return minTolerance;
    }
    
    public float getMaxTolerance()
    {
        return maxTolerance;
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

        Category htCat = Category.getCorrespondant(htInterval);
        Category hlCat = Category.getCorrespondant(hlInterval);
        Category btCat = Category.getCorrespondant(btInterval);
        Category blCat = Category.getCorrespondant(blInterval);

        if (htCat == hlCat && hlCat == btCat && btCat == blCat)
        {
            cat = htCat;
        }

        return cat;
    }
    
}