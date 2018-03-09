package dao;

import entity.Piece;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Connexion;

/**
 * Classe de dialogue avec la BDD servant à enregistrer une pièce ou la charger
 */
public abstract class PieceManager {
    
    /**
     * Ajoute la pièce donnée dans la base de données
     */
    public static void insert(Piece piece)
    {
        
        try {
            Connection c = Connexion.getInstance("boilleau", "boilleau");
            String outMessage = "";
            int newId = 0;
            CallableStatement myStatement = c.prepareCall("{call setDimensions(?, ?, ?, ?, ?, ?, ?)}");
//            myStatement.setFloat(1, piece.getHt());
//            myStatement.setFloat(2, piece.getHl());
//            myStatement.setFloat(3, piece.getBt());
//            myStatement.setFloat(4, piece.getBl());
//            myStatement.setInt(5, piece.getBatch());
//            myStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
//            myStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            
            // à enlever, c'est une pièce de test
            myStatement.setFloat(1, 5);
            myStatement.setFloat(2, 5);
            myStatement.setFloat(3, 5);
            myStatement.setFloat(4, 5);
            myStatement.setInt(5, 1);
            myStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            myStatement.registerOutParameter(7, java.sql.Types.INTEGER);
         
            myStatement.executeUpdate();
            
            System.out.println(myStatement.getInt(6) + "  id : " + myStatement.getString(7));

        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
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
