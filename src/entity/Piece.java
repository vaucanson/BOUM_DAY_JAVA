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
        setHt(ht);
        setHl(hl);
        setBt(bt);
        setBl(bl);
        setBatch(batch);
        
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

    private void setBroken(boolean broken) {
        this.broken = broken;
    }
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;     
    }

    public float getHt() {
        return ht;
    }

    private void setHt(float ht) 
    {
        this.ht = ht;
    }

    public float getHl() {
        return hl;
    }

    private void setHl(float hl) {
 
        this.hl = hl;
    }

    public float getBt() {
        return bt;
    }

    private void setBt(float bt) {
 
        this.bt = bt;
    }

    public float getBl() {
        return bl;
    }

    private void setBl(float bl) {

        this.bl = bl;
       
    }

    public Batch getBatch() {
        return batch;
    }

    private void setBatch(Batch batch) {
       this.batch = batch;
    }
    
    
    /**
     * Détermine la catégorie d'une pièce d'après ses quatre mesures et son modèle
     * @return une valeur de l'enum Category
     */
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
