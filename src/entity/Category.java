/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.swing.JOptionPane;
import tool.CommonTools;

/**
 *
 * @author MATTAR
 */
public class Category {
    
   private String name;
    private float minTolerance;
    private float maxTolerance;
    
    public Category (String name, float min, float max)
    {
        this.name = name;
        setMinTolerance(min);
        setMaxTolerance(max);   
    }
    

    public Category set(Piece p, Batch b)
    {
        return null;
    }

    
    public String getName()
    {
        return name;
    }
    
    private void setName(String name)
    {
        if (CommonTools.isAlphabetical(name))
        {
            this.name = name;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erreur dans la saisie du nom de catégorie.");
        }
    }
    
    private void setMinTolerance(float min)
    {
        this.minTolerance = min;
    }
    
    private void setMaxTolerance (float max)
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
    
}
