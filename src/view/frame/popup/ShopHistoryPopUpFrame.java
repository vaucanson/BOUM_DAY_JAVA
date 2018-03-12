/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import java.awt.GridLayout;
import view.panel.popup.ShopHistoryPopUpPanel;

/**
 *
 * @author mattar
 */
public class ShopHistoryPopUpFrame extends StylePopUpFrame {

    private ShopHistoryPopUpPanel shpup;
    private static ShopHistoryPopUpFrame instance;
    
    public ShopHistoryPopUpFrame() {
        super();
        shpup = new ShopHistoryPopUpPanel(this);
        this.add(shpup);
        
    }

   public static ShopHistoryPopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (ShopHistoryPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new ShopHistoryPopUpFrame();
            }
        } 
        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
