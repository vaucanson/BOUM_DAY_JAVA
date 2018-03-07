package entity;

/**
 * Classe représentant une pièce.
 */
public class Piece {
    
    private int id; // l'id correspondant à celui en BDD
    private float ht; // le diamètre haut transversal
    private float hl; // le diamètre haut longitudinal
    private float bt; // le diamètre bas transversal
    private float bl; // le diamètre bas longitudinal
    private int batch;  // le lot auquel la pièce appartient

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
//        this.batch = batch;
        // TODO
    }
    
    /**
     * Constructeur
     */
        public Piece(float ht, float hl, float bt, float bl, int batch)
    {
        this.setHt(ht);
        this.setHl(hl);
        this.setBt(bt);
        this.setBl(bl);
        this.setBatch(batch);
    }
}
