/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.frame.MainFrame;
import tool.Connexion;

/**
 *
 * @author badaroux
 */
public class HomePanel extends StylePanel {

    /**
     * Creates new form homeScreen
     */
    private MainFrame parent;
    private ControlChoosePressPanel cpcp;
    private WorkshopPanel wp;
    private ApplicationPanel ahop;
    private ShopPanel sp;
    private ProductionPanel pp;
    private boolean isApplicationHeadOf;
    private boolean isProductionHeadOf;
    private boolean isWorkshopHeadOf;
    private boolean isController;
    private boolean isStoreKeeper;
    private boolean isQualityHeadOf;
   
    
    public boolean isApplicationHeadOf() {
        return isApplicationHeadOf;
    }

    public boolean isProductionHeadOf() {
        return isProductionHeadOf;
    }

    public boolean isWorkshopHeadOf() {
        return isWorkshopHeadOf;
    }

    public boolean isController() {
        return isController;
    }

    public boolean isStorekeeper() {
        return isStoreKeeper;
    }

    public boolean isQualityHeadOf() {
        return isQualityHeadOf;
    }

    public void setIsApplicationHeadOf(boolean isApplicationHeadOf) {
        this.isApplicationHeadOf = isApplicationHeadOf;
    }

    public void setIsProductionHeadOf(boolean isProductionHeadOf) {
        this.isProductionHeadOf = isProductionHeadOf;
    }

    public void setIsWorkshopHeadOf(boolean isWorkshopHeadOf) {
        this.isWorkshopHeadOf = isWorkshopHeadOf;
    }

    public void setIsController(boolean isController) {
        this.isController = isController;
    }

    public void setIsStorekeeper(boolean isStorekeeper) {
        this.isStoreKeeper = isStorekeeper;
    }

    public void setIsQualityHeadOf(boolean isQualityHeadOf) {
        this.isQualityHeadOf = isQualityHeadOf;
    }
   
    
    public HomePanel(MainFrame parent) {
        initComponents();
        this.parent = parent;   
        try
        {
            // ajout de l'image
            ImageIcon iconPiston = new ImageIcon(this.getClass().getResource("/img/piston.png"));
            labLogo.setIcon(iconPiston);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labIdentificationName = new javax.swing.JLabel();
        tfIdentificationName = new javax.swing.JTextField();
        labIdentificationPassword = new javax.swing.JLabel();
        labIdentificationTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfIdentificationPassword = new javax.swing.JPasswordField();
        labLogo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labIdentificationName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labIdentificationName.setLabelFor(tfIdentificationName);
        labIdentificationName.setText("- Identifiant");

        tfIdentificationName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfIdentificationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdentificationNameActionPerformed(evt);
            }
        });

        labIdentificationPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labIdentificationPassword.setLabelFor(tfIdentificationPassword);
        labIdentificationPassword.setText("- Mot de passe");

        labIdentificationTitle.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        labIdentificationTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labIdentificationTitle.setText("IDENTIFICATION");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("c : controleur, w : atelier, a : application, s : magasin, p : production");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labIdentificationTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labIdentificationPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labIdentificationName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIdentificationPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdentificationName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(labLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labIdentificationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfIdentificationName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labIdentificationName))
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labIdentificationPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tfIdentificationPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        // ceci est le système utilisé pendant le dev
//        try {
//             switch (tfIdentificationName.getText()) {
//            case "c":
//            cpcp = new ControlChoosePressPanel(parent);
//            parent.changePanel(cpcp);
//            break;
//            case "w":
//            wp = new WorkshopPanel(parent);
//            parent.changePanel(wp);
//            break;
//            case "a":
//            ahop = new ApplicationPanel();
//            parent.changePanel(ahop);
//            break;
//            case "s":
//            sp = new ShopPanel(parent);
//            parent.changePanel(sp);
//            break;
//            case "p":
//            pp = new ProductionPanel(parent);
//            parent.changePanel(pp);
//            break;
//            }
//             
//            Connexion.getInstance("badaroux", "badaroux");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        
           
        String user = this.tfIdentificationName.getText();
        String password = this.tfIdentificationPassword.getText();
        
        Connection maconn = null;
        
        try 
        {
            maconn = Connexion.getInstance(user, password);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                    ps = maconn.prepareStatement("select * from getRoles");
                    if (ps.execute()) 
                    {
                            rs = ps.getResultSet();
                                    
                            while (rs.next())
                            {
                                this.setIsApplicationHeadOf(rs.getBoolean("applicationHeadOf"));
                                this.setIsProductionHeadOf(rs.getBoolean("productionHeadOf"));
                                this.setIsWorkshopHeadOf(rs.getBoolean("workshopHeadOf"));
                                this.setIsController(rs.getBoolean("controller"));
                                this.setIsStorekeeper(rs.getBoolean("storekeeper"));
                                this.setIsQualityHeadOf(rs.getBoolean("qualityHeadOf"));
                            }
                    }
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        
        } catch (SQLException ex) {
//            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        if (this.isApplicationHeadOf)
        {
            ahop = new ApplicationPanel();
            parent.changePanel(ahop);
        }
        else if (this.isController)
        {
            cpcp = new ControlChoosePressPanel(parent);
            parent.changePanel(cpcp);
        }
        else if (this.isProductionHeadOf)
        {
            pp = new ProductionPanel(parent);
            parent.changePanel(pp);
        }
        else if (this.isWorkshopHeadOf)
        {
            wp = new WorkshopPanel(parent);
            parent.changePanel(wp);
        }
        else if (this.isStoreKeeper)
        {
            sp = new ShopPanel(parent);
                parent.changePanel(sp); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfIdentificationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdentificationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdentificationNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labIdentificationName;
    private javax.swing.JLabel labIdentificationPassword;
    private javax.swing.JLabel labIdentificationTitle;
    private javax.swing.JLabel labLogo;
    private javax.swing.JTextField tfIdentificationName;
    private javax.swing.JPasswordField tfIdentificationPassword;
    // End of variables declaration//GEN-END:variables
}
