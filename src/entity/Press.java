/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.swing.JOptionPane;

/**
 *
 * @author badaroux
 */
public class Press {
    
    private int id;
    private boolean isFree;

    public Press(int i) 
    {
        setId(i);
        setIsFree(true);
    }
    
        public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

        public boolean GetisFree() {
        return isFree;
    }

    private void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
    
    @Override
    public String toString() {
        return "Presse numéro " + id;
    }
}
