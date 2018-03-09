package dao;

import entity.Piece;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tool.Connexion;

/**
 * Classe de dialogue avec la BDD servant à enregistrer une pièce ou la charger
 */
public abstract class PieceManager {
    
    /**
     * Ajoute la pièce donnée dans la base de données
     * @param ht
     * @param hl
     * @param bt
     * @param bl
     * @param batchId
     */
    public static void create(float ht, float hl, float bt, float bl, int batchId)
    {
        String msg = "";
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call createPiece (?, ?, ?, ?, ?, ?)}");

                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(7, java.sql.Types.VARCHAR);
                cs.setFloat(2, ht);
                cs.setFloat(3, hl);
                cs.setFloat(4, bt);
                cs.setFloat(5, bl);
                cs.setInt(6, batchId);
                cs.setString(7, msg);

                cs.execute();

                int resultat = cs.getInt(1);

                if (resultat == 0) {
                    System.out.println(cs.getString(7));
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
         
    }
    
    
    
    /**
     * Instancie un objet Pièce d'après ses infos en bdd
     * @params id int représentant l'id de la pièce à instancier
     * @return une pièce
     */
    private static Piece fetchPiece(int id)
    {
        Piece newPiece = null; // la nouvelle pièce à créer
        try 
        {
            // on récupère la connexion courante
            Connection c = Connexion.getInstance();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from piece where id = " + id); // TODO : une vue
            // on n'est censés avoir qu'un seul résultat
            if (rs.next())
            {
                // création d'une pièce avec les données trouvées
                newPiece = new Piece(rs.getFloat("ht"), rs.getFloat("hl"), rs.getFloat("bt"), rs.getFloat("bl"), rs.getInt("batch"));
            }
            st.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return newPiece;
    }
}
