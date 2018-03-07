/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MATTAR
 */
public class Category {
    
   private String name;
    private float minTolerance;
    private float maxTolerance;
    
    //TODO LES SET AVEC VERIF
    public Category (String name, float min, float max)
    {
        this.name = name;
        setMinTolerance(min);
        setMaxTolerance(max);
        
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setMinTolerance(float min)
    {
        this.minTolerance = min;
    }
    
    public void setMaxTolerance (float max)
    {
        this.maxTolerance = max;
    }
    
    
}
