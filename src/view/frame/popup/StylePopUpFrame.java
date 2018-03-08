/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import java.awt.GridLayout;

/**
 *
 * @author badaroux
 */
public class StylePopUpFrame extends javax.swing.JFrame {

    
    private static StylePopUpFrame instance;
    
    public StylePopUpFrame() {
        this.initComponents();
        this.setVisible(true);
        this.setLayout(new GridLayout(1, 1, 10, 0));
        this.setBounds(200, 200, 500, 400);
    }

      public static StylePopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (ControlValidationPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new StylePopUpFrame();
            }
        } 
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
