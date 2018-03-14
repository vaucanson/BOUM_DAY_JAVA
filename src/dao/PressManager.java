/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Batch;
import entity.Press;
import java.sql.CallableStatement;
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
 * @author badaroux
 */
public class PressManager {

    public PressManager() {
    }

    public static ArrayList<Press> fillNonBusyPressList() {
        ArrayList<Press> pressList = new ArrayList<>();
        try {

            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM nonBusyPresses");

                while (rs.next()) {

                    int myId = rs.getInt("id");
                    Press press = new Press(myId);
                    pressList.add(press);
                }

                st.close();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PressManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (SQLException ex) {
          ex.printStackTrace();

        }
        return pressList;
    }

    public static ArrayList<Press> fillBusyPressList() {
        ArrayList<Press> busyPressList = new ArrayList<>();
        try {

            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT press.id FROM press JOIN batch on batch.press = press.id WHERE batch.state = 2");

                while (rs.next()) {

                    short pressId = rs.getShort(1);
                    Press press = new Press(pressId);
                    
                    busyPressList.add(press);
                }

                st.close();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PressManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return busyPressList;
    }

    public static int add() {
        int id = 0;

        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {

                CallableStatement cs = c.prepareCall("{?=call addPress (?, ?)}");

                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.registerOutParameter(2, java.sql.Types.VARCHAR);
                cs.registerOutParameter(3, java.sql.Types.INTEGER);

                cs.execute();

                int resultat = cs.getInt(1);

                if (resultat == 0) {
                    id = cs.getInt(3);
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
        return id;
    }

    public static boolean remove(int i) {
        boolean ret = false;

        try {
            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {
                String msg = "";
                CallableStatement cs = c.prepareCall("{?=call removePress (?, ?)}");

                cs.setString(3, msg);
                cs.setInt(2, i);
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                cs.executeUpdate();

                int resultat = cs.getInt(1);

                if (resultat == 0) {
                    ret = true;
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
            ret = false;
        }
        return ret;
    }

    public static Press getOne(Batch batch)
    {
        Press press = null;
       
                try
            {

                Connection c;
                c = Connexion.getInstance("badaroux", "badaroux");

                try
                {
                    Statement st = c.createStatement();

                    ResultSet rs = st.executeQuery("SELECT press.id FROM PRESS JOIN BATCH on batch.press = press.id WHERE batch.id ='" + batch.getId() +"'");

                    if (rs.next())
                    {
                        press = new Press(rs.getShort(1));  
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

            return press;
    }
    
    public static boolean isActive(Press p)
    {       
        boolean active = false;
        try
            {

                Connection c;
                c = Connexion.getInstance("badaroux", "badaroux");

                try
                {
                    Statement st = c.createStatement();

                    ResultSet rs = st.executeQuery("SELECT ACTIVE FROM PRESS WHERE PRESS.ID = '" + p.getId() +"'");

                    if (rs.next())
                    {
                        if (rs.getByte(1) == 1){active = true;}
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
            return active;
    }
    
    public static boolean isFree(Press p)
    {
        boolean free = false;
        try {

            Connection c = Connexion.getInstance("badaroux", "badaroux");

            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM nonBusyPresses WHERE ID = '" + p.getId() + "'");

                if (rs.next()) {

                    free = true;
                }

                st.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();

            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PressManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (SQLException ex) {
          ex.printStackTrace();

        }
        return free;
    
    }
}
