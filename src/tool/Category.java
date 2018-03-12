package tool;

import dao.CategoryManager;

public enum Category 
{
//    SMALL((float) -0.1, (float) -0.01),
    SMALL(CategoryManager.getTolerance("small")[0], CategoryManager.getTolerance("small")[1]),
    MEDIUM(CategoryManager.getTolerance("medium")[0], CategoryManager.getTolerance("medium")[1]),
    BIG(CategoryManager.getTolerance("big")[0], CategoryManager.getTolerance("big")[1]),
    WASTE(0, 0);
    
    private float minTolerance;
    private float maxTolerance;
    
    private Category (float min, float max)
    {
        setMinTolerance(min);
        setMaxTolerance(max);   
    }
    
    public void setMinTolerance(float min)
    {
        this.minTolerance = min;
    }
    
    public void setMaxTolerance (float max)
    {
        this.maxTolerance = max;
    }
    
    public float getMinTolerance()
    {
        return minTolerance;
    }
    
    public float getMaxTolerance()
    {
        return maxTolerance;
    }
    
    public static Category getCorrespondant(float interval)
    {
    	Category cat = Category.WASTE;
    	
    	if (interval < SMALL.getMinTolerance()) // si inférieur à small.min
    	{
    		cat = WASTE;
    	}
    	else if (interval < MEDIUM.getMinTolerance()) // si entre small.min et medium.min
    	{
    		cat = SMALL;
    	}
    	else if (interval < MEDIUM.getMaxTolerance()) // si entre medium.min et medium.max
    	{
    		cat = MEDIUM;
    	}
    	else if (interval < BIG.getMaxTolerance()) // si entre medium.max et big.max	
    	{
    		cat = BIG;
    	}
    	else // si supérieur à big.max
    	{
    		cat = WASTE;
    	}
    	
		return cat;
    }
    
    
	public static Category get(float htInterval, float hlInterval, float btInterval, float blInterval)
	{
            Category cat = Category.WASTE;
	    
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