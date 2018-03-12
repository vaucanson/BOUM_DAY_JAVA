package entity;

import javax.swing.JOptionPane;

/**
 * Classe représentant une pièce.
 */
public class Piece {
    
    private int id; // l'id correspondant à celui en BDD
    private float ht; // le diamètre haut transversal
    private float hl; // le diamètre haut longitudinal
    private float bt; // le diamètre bas transversal
    private float bl; // le diamètre bas longitudinal
    private Batch batch;  // le lot auquel la pièce appartient
    private boolean broken;

    
     public Piece(float ht, float hl, float bt, float bl, Batch batch)
    {
        if (!setHt(ht))
        {
            JOptionPane.showMessageDialog(null, "Erreur : le nombre HT doit être positif.");
        }
        else if (!setHl(hl))
        {
            JOptionPane.showMessageDialog(null, "Erreur : le nombre HL doit être positif.");
        }
        else if (!setBt(bt))
        {
            JOptionPane.showMessageDialog(null, "Erreur : le nombre BT doit être positif.");
        }
        else if (!setBl(bl))
        {
            JOptionPane.showMessageDialog(null, "Erreur : le nombre BL doit être positif.");
        }
        
        this.setBatch(batch);
        
        if ((ht != 0) && (hl !=0) && (bt != 0) && (bl != 0))
        {
            setBroken(false);
        }
        else
        {
            setBroken(true);
        }
    }
    
    public boolean isBroken() 
    {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }
    
    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        boolean ok = false;
        
        if (id >= 0)
        {
            this.id = id;
            ok = true;
        }
        return ok;        
    }

    public float getHt() {
        return ht;
    }

    public boolean setHt(float ht) 
    {
        boolean ok = false;
        if (ht >= 0)
        {
            this.ht = ht;
            ok =true;
        }
        return ok;
        
    }

    public float getHl() {
        return hl;
    }

    public boolean setHl(float hl) {
        boolean ok = false;
        if (hl >= 0)
        {
           this.hl = hl;
            ok =true;
        }
        return ok;
        
    }

    public float getBt() {
        return bt;
    }

    public boolean setBt(float bt) {
        boolean ok = false;
        if (bt >= 0)
        {
           this.bt = bt;
            ok =true;
        }
        return ok;
        
    }

    public float getBl() {
        return bl;
    }

    public boolean setBl(float bl) {
        boolean ok = false;
        if (bl >= 0)
        {
            this.bl = bl;
            ok =true;
        }
        return ok;
       
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
       this.batch = batch;
    }
    
    public entity.Category getCategory()
    {
        entity.Category cat = entity.Category.REBUT;
        
        float htInterval = this.ht - this.getBatch().getModel().getDiameter();
        float hlInterval = this.hl - this.getBatch().getModel().getDiameter();
        float btInterval = this.bt - this.getBatch().getModel().getDiameter();
        float blInterval = this.bl - this.getBatch().getModel().getDiameter();
        
        cat = entity.Category.get(htInterval, hlInterval, btInterval, blInterval);
        return cat;
    }
    
       
}
