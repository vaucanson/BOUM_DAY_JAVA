package entity;

import dao.BatchManager;

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

    
     public Piece(float ht, float hl, float bt, float bl, int batch)
    {
        this.setHt(ht);
        this.setHl(hl);
        this.setBt(bt);
        this.setBl(bl);
        this.setBatch(BatchManager.get(batch));
        
        if ((ht != 0) && (hl !=0) && (bt != 0) && (bl != 0))
        {
            setBroken(false);
        }
        else
        {
            setBroken(true);
        }
    }
     
    
    
    public boolean isBroken() {
    return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        
       //TODO VERIFICATION
        
        this.id = id;
    }

    public float getHt() {
        return ht;
    }

    public void setHt(float ht) {
        this.ht = ht;
    }

    public float getHl() {
        return hl;
    }

    public void setHl(float hl) {
        this.hl = hl;
    }

    public float getBt() {
        return bt;
    }

    public void setBt(float bt) {
        this.bt = bt;
    }

    public float getBl() {
        return bl;
    }

    public void setBl(float bl) {
        this.bl = bl;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
       this.batch = batch;
        
    }
    
    public tool.Category getCategory()
    {
        tool.Category cat = tool.Category.WASTE;
        
        float htInterval = this.ht - this.getBatch().getModel().getDiameter();
        float hlInterval = this.hl - this.getBatch().getModel().getDiameter();
        float btInterval = this.bt - this.getBatch().getModel().getDiameter();
        float blInterval = this.bl - this.getBatch().getModel().getDiameter();
        
        cat = tool.Category.get(htInterval, hlInterval, btInterval, blInterval);
        return cat;
    }
       
}
