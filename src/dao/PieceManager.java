package dao;

import entity.Batch;
import entity.Piece;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tool.Connexion;

/**
 * Classe servant à enregistrer et lire en bdd les données concernant la Piece
 * @see entity.Piece
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
    public static int create(float ht, float hl, float bt, float bl, int batchId)
    {
        int ret = 0;
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

                ret = cs.getInt(1);


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
        return ret; 
    }
    
    
    
    /**
     * Instancie un objet Pièce d'après ses infos en bdd
     * @params id int représentant l'id de la pièce à instancier
     * @return une pièce
     */
    private static Piece fetch(int id)
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
              //  Batch batch = BatchManager.get(rs.getInt("batch"));
                Batch batch = null;
                newPiece = new Piece(rs.getFloat("ht"), rs.getFloat("hl"), rs.getFloat("bt"), rs.getFloat("bl"), batch);
            }
            st.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return newPiece;
    }
    
    public static void purge()
    {
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call piecesPurge (?)}");
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(2, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(2);
                
                if (ret == 0)
                {
                    System.out.println(msg);
                }
                else
                {
    
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
     * permet de savoir combien de pièces sont à effacer de la base de donnée
     * @return int renvoi le nombre de pièces en base de donnée datant de plus d'un an
     */
    public static int getNbPurge()
    {
        int number = 0;
        
        try 
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            // on récupère la connexion courante
            c = Connexion.getInstance();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT PIECE.id  FROM PIECE "
                                          + "JOIN BATCH on BATCH.id = PIECE.batch "
                                          + "WHERE DATEDIFF(DAY, BATCH.date, GETDATE()) > 365");
            
            if (rs.next())
            {
                while (rs.next())
                {
                    number += (rs.getInt(1));
                }
            }
            st.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return number;
    }
    
    
}
