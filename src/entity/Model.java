package entity;

/**
 *
 * @author boilleau
 */
public class Model {
    
    private String name; // le nom, qui est l'identifiant
    private float diameter; // le diamètre théorique
    
    // le minimum de stock autorisé pour les pièces de ce modèle, par catégorie
    private int smallLimit; // en catégorie petit
    private int mediumLimit;  // en catégorie moyen
    private int bigLimit;  // en catégorie grand

    public int getSmallLimit() {
        return smallLimit;
    }

    public int getMediumLimit() {
        return mediumLimit;
    }

    public int getBigLimit() {
        return bigLimit;
    }

     /**
     * Constructeur
     */
    public Model(String name, float diameter)
    {
        // appel du constructeur à limites avec des valeurs à 0
        this(name, diameter, 0, 0, 0);
    }
    
    /**
     * Constructeur à limites
     */
    public Model(String name, float diameter, int smallLimit, int mediumLimit, int bigLimit)
    {
        setName(name);
        setDiameter(diameter);
        this.smallLimit = smallLimit;
        this.mediumLimit = mediumLimit;
        this.bigLimit = bigLimit;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }
    
   
}
