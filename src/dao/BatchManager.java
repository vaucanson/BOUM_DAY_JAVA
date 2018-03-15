package dao;


import entity.Batch;
import entity.Model;
import entity.Press;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tool.Connexion;

/**
 * Classe servant à enregistrer et lire en bdd les données concernant le Batch
 * @see entity.Batch
 */
public abstract class BatchManager {
    /*
    procedure stopBatch
       
    */
    
    /**
     * Récupère le champ batch.state
     * @param batch le Batch dont on veut connaître le state
     * @return le state du Batch donné
     */
    public static int getState(Batch batch)
    {
        int result = 0;
        int id = batch.getId();
        
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("select batch.state from batch where batch.id = " + id);
                
                if (rs.next())
                {
                    result = rs.getInt(1);
                }
                
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
          
            ex.printStackTrace();
        }
        return result;
    }
    
    
    /**
     * récupère le nombre de pièces d'un batch donné
     * @param batch le Batch dont on veut connaître le nombre de pièces
     * @return le nombre de pièces du Batch donné
     */
    public static int getPieceNumber(Batch batch)
    {
       int result = 0;
        int id = batch.getId();
        
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("select COUNT(PIECE.id) from piece join batch on piece.batch = batch.id where batch.id = " + id);
                
                if (rs.next())
                {
                    result = rs.getInt(1);
                }
                
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
          
            ex.printStackTrace();
        }
        return result; 
    }
    
    
    /**
     * Crée un lot en mettant son état à 1, sa quantité à la quantité donnée, et lui affecte le modèle donné
     * @param model le Model à affecter
     * @param quantity la quantité à enregistrer
     */
    public static void setStateOne(Model model, int quantity)
    {
        
        try
        {
            Connection c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                CallableStatement cs = c.prepareCall("{?=call setBatchStateOne (?,?,?)}");
                
                cs.setInt(2, quantity);
                cs.setString(3, model.getName());
                
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(4, java.sql.Types.VARCHAR);
                
                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(4);
                
                if (ret == 0)
                {
                    System.out.println(msg);
                }
                else
                {
                    System.out.println("Erreur :" + msg);
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
     * Met à jour le lot donné : met son état à 2, et lui affecte la presse donnée
     * @param batch le Batch à mettre à jour
     * @param press la Press à lui affecter
     */
    public static void setStateTwo(Batch batch,Press press)
    {
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateTwo (?, ?, ?)}");
              
                System.out.println(batch.getId());
                System.out.println(press.getId());
                
                cs.setInt(2, batch.getId());
                cs.setInt(3, press.getId());

                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(4, java.sql.Types.VARCHAR);
                

                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(4);
                
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
     * Met à jour le lot donné : met son état à 3
     * @param batch le Batch à mettre à jour
     */
    public static void setStateThree(Batch batch)
    {
        
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateThree (?, ?)}");
              
                System.out.println(batch.getId());
         
                
                cs.setInt(2, batch.getId());

                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(3, java.sql.Types.VARCHAR);

                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(3);
                
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
     * Met à jour le modèle donné : met son état à 4
     * @param batch le Batch à
     */
    public static void setStateFour (Batch batch)
    {
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateFour (?, ?)}");
              
                cs.setInt(2, batch.getId());

                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(3, java.sql.Types.VARCHAR);

                cs.execute();
                
                int ret = cs.getInt(1);
                String msg = cs.getString(3);
                
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
     * Récupère la liste de tous les Batch existants en bdd
     * @return une Arraylist contenant tous les Batch
     */
    public static ArrayList<Batch> fillList()
    {
           ArrayList<Batch> liste = new ArrayList<>();
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM BATCH ORDER BY ID");
                
                while (rs.next())
                {
                    Model model = ModelManager.getModel(rs.getString(6));
                    liste.add(new Batch(rs.getShort(1), rs.getDate(2), rs.getShort(3), rs.getShort(4), rs.getShort(5), model));
                    
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
           
            ex.printStackTrace();
        }
        return liste;
    }
    
    
    /**
     * Récupère la liste de tous les Batch dont l'état est 1
     * @return une Arraylist
     */
    public static ArrayList<Batch> fillListStartBatch()
    {
           ArrayList<Batch> liste = new ArrayList<>();
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM BATCH  WHERE state = 1 ORDER BY ID");
                
                while (rs.next())
                {
                    Model model = ModelManager.getModel(rs.getString(6));
                    liste.add(new Batch(rs.getShort(1), rs.getDate(2), rs.getShort(3), rs.getShort(4), rs.getShort(5), model));
                    
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
           
            ex.printStackTrace();
        }
        return liste;
    }
    
    
    /**
     * Récupère la liste de tous les Batch en état 2
     * @return une Arraylist 
     */
    public static ArrayList<Batch> fillListEndBatch()
    {
           ArrayList<Batch> liste = new ArrayList<>();
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM BATCH  WHERE state = 2");
                
                while (rs.next())
                {
                    Model model = ModelManager.getModel(rs.getString(6));
                    liste.add(new Batch(rs.getShort(1), rs.getDate(2), rs.getShort(3), rs.getShort(4), rs.getShort(5), model));
                    
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
           
            ex.printStackTrace();
        }
        return liste;
    }
    
    
    /**
     * Récupère la liste de tous les Batch en état 2 ou 3
     * @return une Arraylist
     */
    public static ArrayList<Batch> fillListStopBatch()
    {
           ArrayList<Batch> liste = new ArrayList<>();
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM BATCH  WHERE state = 3 OR state = 2");
                
                while (rs.next())
                {
                    Model model = ModelManager.getModel(rs.getString(6));
                    liste.add(new Batch(rs.getShort(1), rs.getDate(2), rs.getShort(3), rs.getShort(4), rs.getShort(5), model));
                    
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
           
            ex.printStackTrace();
        }
        return liste;
    }
    
       
    /**
     * Dit si le modèle donné est lancé ou pas.
     * @param modele le Model dont on veut savoir s'il est lancé
     * @return un booléen vrai si le modèle est lancé
     */
    public static Boolean isLaunched(String modele)
    {
        Boolean result = false;
        
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM STOCKUNDERLIMIT SUL "
                                               + "JOIN BATCH BA ON BA.MODEL = SUL.MODEL "
                                               + "WHERE BA.MODEL = '" + modele + "' AND BA.STATE != 4");
                
                if (rs.next())
                {
                    result = true; 
                    
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
          
            ex.printStackTrace();
        }
        return result;
    }
   
    
    
    /**
     * Affecte au Batch donné le nombre de pièces donné
     * @param batch le Batch
     * @param rest le nombre à affecter
     * @return vrai si l'opération s'est bien passée
     */
    public static boolean setBreak(Batch batch, int rest)
    {
        Boolean result = false;
        int id = batch.getId();
        
        try
        {
 
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                st.execute("UPDATE BATCH SET piecesNumber = '" + rest + "' WHERE batch.id = '" + id + "'");
                result = true;
                
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    c.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
        catch(SQLException ex)
        {
          
            ex.printStackTrace();
        }
        return result;
    }
    
        

}




