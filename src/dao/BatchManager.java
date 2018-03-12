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
 *
 * @author mattar
 */
public class BatchManager {
    /*
    procedure stopBatch
       
    */
    
    private BatchManager()
    {
        
    }
    
    /**
     * TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @return 
     */
    public static Batch get(int id)
    {
        return null;
    }
    
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
    
    public static void setStateThree(Batch b)
    {
        
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateThree (?, ?)}");
              
                System.out.println(b.getId());
         
                
                cs.setInt(2, b.getId());

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
    
    public static void setStateTwo(Batch b,Press p)
    {
        
        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateTwo (?, ?, ?)}");
              
                System.out.println(b.getId());
                System.out.println(p.getId());
                
                cs.setInt(2, b.getId());
                cs.setInt(3, p.getId());

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
    
    public static void setStateFour (Batch b)
    {
 try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call setBatchStateFour (?, ?)}");
              
                cs.setInt(2, b.getId());

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
    
    public static ArrayList<Batch> loadBatch()
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




