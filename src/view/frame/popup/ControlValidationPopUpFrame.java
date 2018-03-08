/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import view.panel.popup.ControlValidationPopUpPanel;

/**
 *
 * @author badaroux
 */
public class ControlValidationPopUpFrame extends StylePopUpFrame {

    private ControlValidationPopUpPanel vcpup;
    private static ControlValidationPopUpFrame instance;
    
    private ControlValidationPopUpFrame() {
        super();
        vcpup = new ControlValidationPopUpPanel(this);
        this.add(vcpup);
       
    }

    public static ControlValidationPopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (ControlValidationPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new ControlValidationPopUpFrame();
            }
        } 
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
