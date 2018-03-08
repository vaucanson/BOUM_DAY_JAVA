/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import entity.Batch;
import entity.Press;
import view.panel.popup.ControlCancelPopUpPanel;

public class ControlCancelPopUpFrame extends StylePopUpFrame {

   private ControlCancelPopUpPanel ccpup = new ControlCancelPopUpPanel(this);
   private static ControlCancelPopUpFrame instance;
   private Press press;

   
    private ControlCancelPopUpFrame(Press p) {
       super();
       add(ccpup);
       press = p;
    }
 
    public static ControlCancelPopUpFrame getInstance(Press p)
    {
        
        if (instance == null || !instance.isVisible())
        {
            synchronized (ControlCancelPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new ControlCancelPopUpFrame(p);
            }
        } 
        return instance;
    }
    
    public  Press getPress() {
    return press;
    }

    public void setPress(Press p) {
        this.press = p;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
