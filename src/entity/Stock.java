/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author mattar
 */
public class Stock {
    
    private Category category;
    private Model model;
    private int limit;
    private int quantity;
    
    /**
     * Constructeur 
     * @param model
     * @param category
     * @param quantity
     * @param limit 
     */
    public Stock (Model model, Category category, int quantity, int limit)
    {
        this.category = category;
        this.model = model;
        setLimit(limit);
        this.quantity = quantity;
    }
   
    @Override
    public String toString() {
        return getModel().getName() + getCategory().getName() + getQuantity() + getLimit();
    }

    public Category getCategory() {
        return category;
    }

    public Model getModel() {
        return model;
       
    }

    public int getLimit() {
        return limit;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public boolean isLimitReached()
    {
        return (this.getQuantity() < this.getLimit());
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }
    
}
