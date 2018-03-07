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
