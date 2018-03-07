package dao;

import entity.Category;
import entity.Model;
import entity.Stock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Connexion;

/**
 *
 * @author mattar
 */
public abstract class CategoryManager {
    
    private CategoryManager()
    {
        
    }
    
    public static Category getCategory(String name)
    {
       Category myCat = null;
       
       try
        {
            
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM CATEGORY WHERE NAME = '" + name + "'");
                
                if (rs.next())
                {
                   myCat = new Category(rs.getString(1), rs.getFloat(2), rs.getFloat(3));
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
          
        }
        catch(SQLException ex)
        {
       
            ex.printStackTrace();
        }
        return myCat;
    }
    
    public static ArrayList<Category> load()
    {
        ArrayList<Category> cList = new ArrayList<>();
        
        try
        {
            Connection c;
            c = Connexion.getInstance("badaroux", "badaroux");
            
            try
            {
                Statement st = c.createStatement();
                
                ResultSet rs = st.executeQuery("SELECT * FROM CATEGORY ORDER BY NAME ");
                
                while (rs.next())
                {
                   cList.add(new Category(rs.getString(1), rs.getFloat(2), rs.getFloat(3)));
                }
                st.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally 
            {
                if (c != null) 
                {
                    try 
                    {
                        c.close();
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                        
                    }
                }
            }
        }
        catch(SQLException ex)
        {
          
            ex.printStackTrace();
        }
        return cList;
    }
              
}
    

