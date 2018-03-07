/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author badaroux
 */
public class Press {
    
    private int id;
    private boolean isFree;

    public Press(int i) 
    {
        id = i;
        setIsFree(true);
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public boolean GetisFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
    
    @Override
    public String toString() {
        return "Presse numéro " + id;
    }
}
